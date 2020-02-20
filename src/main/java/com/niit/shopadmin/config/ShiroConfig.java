package com.niit.shopadmin.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.niit.shopadmin.shiro.ShopRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: shop-admin
 * @description: Shiro配置文件
 * @author: hanliang
 * @create: 2020-02-19 09:59
 **/
@Configuration   // 相当于applicationContext.xml（spring的bean的配置文件)
public class ShiroConfig {
    //
    @Bean
    public ShopRealm shopRealm(){
        return new ShopRealm();
    }

    // SecurityManager
    // <bean id="securityManager " class="org.apache.shiro.web.mgt.DefaultWebSecurityManager">
    // 返回值相当于以前的class="xx" 方法名称相当于以前的 id="xx"
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shopRealm()); // 注入一个 shopRealm
        return securityManager;
    }

    //Filter工厂，设置对应的过滤条件和跳转条件
    // anon 拦截器表示匿名访问（即不需要登录即可访问）；authc 拦截器表示需要身份认证通过后才能访问；
    // roles[admin]拦截器表示需要有 admin 角色授权才能访问；而 perms["user:create"]拦截器表示需要有 “user:create” 权限才能访问。
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> map = new HashMap<>();
        //登出
        map.put("/logout", "logout");
        map.put("/", "anon");
        map.put("/login", "anon");
        map.put("/css/**", "anon");
        map.put("/js/**", "anon");
        // 对所有用户认证
        map.put("/**", "authc");

        // 登录路径
        shiroFilterFactoryBean.setLoginUrl("/");
        // 登陆成功之后访问的路径
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //错误页面，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/error");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }

    //加入注解的使用，不加入这个注解不生效
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * shiro方言 支持shiro标签
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}
