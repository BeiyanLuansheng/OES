package org.oes.start.tools.shiro;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.crazycake.shiro.RedisCacheManager;
import org.oes.biz.component.RedisClient;
import org.oes.biz.component.SessionClient;
import org.oes.biz.entity.User;
import org.oes.biz.service.UserService;
import org.oes.common.constans.LogFileNameConstant;
import org.oes.common.constans.OesConstant;
import org.oes.common.constans.StringConstant;
import org.oes.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * 自定义实现 ShiroRealm，包含认证和授权两大模块
 *
 * @author XuJian
 * @since 2021/12/11
 */
@Component
public class ShiroRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(ShiroRealm.class);
    private static final Logger LOGGER = LoggerFactory.getLogger(LogFileNameConstant.OES);

    @Value("${" + OesConstant.ENABLE_REDIS_CACHE + "}")
    private boolean enableRedisCache;

    @Resource
    private UserService userService;
    @Resource
    private SessionClient sessionClient;
    @Resource
    private RedisClient redisClient;
    @Resource
    private CacheManager cacheManager;

    @PostConstruct
    private void initConfig() {
        setAuthenticationCachingEnabled(false);
        setAuthorizationCachingEnabled(true);
        setCachingEnabled(true);
        setCacheManager(cacheManager);
    }

    /**
     * 授权模块，获取用户角色和权限
     *
     * @param principal principal
     * @return AuthorizationInfo 权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        User user = (User) principal.getPrimaryPrincipal();
        user = userService.doGetUserAuthorization(user);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(user.getRoleNames());
        simpleAuthorizationInfo.setStringPermissions(user.getPermissions());
        return simpleAuthorizationInfo;
    }

    /**
     * 用户认证
     *
     * @param token AuthenticationToken 身份认证 token
     * @return AuthenticationInfo 身份认证信息
     * @throws AuthenticationException 认证相关异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取用户输入的手机号和密码
        String phone = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        // 通过用户名到数据库查询用户信息
        User user = this.userService.findByPhone(phone);
        if (user == null || !StringUtils.isEquals(password, user.getPassword())) {
            throw new IncorrectCredentialsException("手机号或密码错误！");
        }
        if (User.STATUS_LOCK.equals(user.getStatus())) {
            throw new LockedAccountException("账号已被锁定，请联系客服！");
        }
        return new SimpleAuthenticationInfo(user, password, getName());
    }

    /**
     * 下线
     */
    @Override
    public void onLogout(PrincipalCollection principals) {
        super.onLogout(principals);
        if (enableRedisCache) {
            this.cleanCacheFragment(principals);
        }
    }

    @Async(OesConstant.OES_THREAD_POOL)
    public void cleanCacheFragment(PrincipalCollection principals) {
        User principal = (User) principals.getPrimaryPrincipal();
        String key = RedisCacheManager.DEFAULT_CACHE_KEY_PREFIX + ShiroRealm.class.getName()
                + StringConstant.DOT + "authenticationCache" + StringConstant.COLON + principal.getUserId();
        redisClient.del(key);
        logger.info("async clean up user cache fragment,cache key: [{}]", key);
    }

    /**
     * 清除当前用户权限缓存
     */
    public void clearCache(Long userId) {
        List<SimplePrincipalCollection> principals = sessionClient.getPrincipals(userId);
        if (CollectionUtils.isNotEmpty(principals)) {
            for (SimplePrincipalCollection principal : principals) {
                super.clearCache(principal);
            }
        }
    }
}