package com.xiayu.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author xuhongyu
 * @create 2022-04-25 4:28 下午
 */

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                //下边的路径放行
                .antMatchers(
                        //swagger界面接口放行
                        "/v2/api-docs",
                        "/doc.html",
                        "/swagger-ui.html",
                        "/course/coursebase/**",
                        "/webjars/**",
                        "/swagger-resources/**"

                ).permitAll()
                //拦截所有请求    并设置访问该资源的权限，这里设置为USER
                .antMatchers("/**").hasRole("USER");
    }
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        // 配置资源 ID
        resources.resourceId("oauth2");
    }

}
