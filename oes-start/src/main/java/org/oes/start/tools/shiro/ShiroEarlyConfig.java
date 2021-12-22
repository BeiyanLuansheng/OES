package org.oes.start.tools.shiro;

import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.oes.common.constans.URIs;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

/**
 * 将注册时机较早的Bean单独提取出来，并且相关依赖延迟注入，
 * 尽可能的缩小对Bean后置处理器的影响
 * <p>
 * https://github.com/spring-projects/spring-boot/issues/16097
 * https://issues.apache.org/jira/browse/SHIRO-743
 *
 * @author XuJian
 * @since 2021/12/14
 */
@Configuration(proxyBeanMethods = false)
public class ShiroEarlyConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Lazy DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置 securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 登录的 url
        shiroFilterFactoryBean.setLoginUrl(URIs.LOGIN);
        // 登录成功后跳转的 url
        shiroFilterFactoryBean.setSuccessUrl(URIs.SUCCESS);
        // 未授权 url
        shiroFilterFactoryBean.setUnauthorizedUrl(URIs.UNAUTHORIZED);
        LinkedHashMap<String, String> filterChainDefinitionMap = URIs.unauthorized.stream()
                .collect(Collectors.toMap(url -> url, url -> "anon", (a, b) -> b, LinkedHashMap::new));
        filterChainDefinitionMap.put(URIs.LOGOUT, "logout");
        // 除登出以外所有 url都必须认证通过才可以访问，未通过认证自动访问 LoginUrl
        filterChainDefinitionMap.put(URIs.ALL, "user");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /*
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions)
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator和AuthorizationAttributeSourceAdvisor)即可实现此功能
     */

    /**
     * 配置此对象的目的是,在spring容器启动时,
     * 扫描所有的advisor(顾问)对象,基于advisor
     * 对象中切入点的描述,为目标对象创建代理对象
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Lazy DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
