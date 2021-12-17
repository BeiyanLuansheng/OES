package org.oes.start.tools.shiro;

import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.oes.common.constans.URIConstant;
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
        shiroFilterFactoryBean.setLoginUrl(URIConstant.LOGIN);
        // 登录成功后跳转的 url
        shiroFilterFactoryBean.setSuccessUrl(URIConstant.SUCCESS);
        // 未授权 url
        shiroFilterFactoryBean.setUnauthorizedUrl(URIConstant.UNAUTHORIZED);
        LinkedHashMap<String, String> filterChainDefinitionMap
                = URIConstant.unauthorized.stream().collect(
                        Collectors.toMap(url -> url, url -> "anon", (a, b)->b, LinkedHashMap::new));
        filterChainDefinitionMap.put(URIConstant.SUCCESS, "logout");
        // 除登出以外所有 url都必须认证通过才可以访问，未通过认证自动访问 LoginUrl
        filterChainDefinitionMap.put(URIConstant.ALL, "user");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Lazy DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
