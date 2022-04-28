package com.xiayu.provider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author xuhongyu
 * @create 2022-04-25 4:28 下午
 */

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .exceptionHandling()
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                //下边的路径放行
//                .antMatchers("/v2/api-docs", "/swagger-resources/configuration/ui",
//                        "/swagger-resources","/swagger-resources/configuration/security",
//                        "/swagger-ui.html","/course/coursebase/**",
//                        //swagger界面接口放行
//                        "/csrf",
//                        "/webjars/springfox-swagger-ui/fonts/**",
//                        "/webjars/springfox-swagger-ui/**"
//
////                        "/webjars/springfox-swagger-ui/springfox.css",
////                        "/webjars/springfox-swagger-ui/swagger-ui.css",
////                        "/webjars/springfox-swagger-ui/swagger-ui-bundle.js",
////                        "/webjars/springfox-swagger-ui/swagger-ui-standalone-preset.js",
////                        "/webjars/springfox-swagger-ui/springfox.js",
////                        "/webjars/springfox-swagger-ui/favicon-32x32.png",
////                        "/webjars/springfox-swagger-ui/favicon-16x16.png",
////                        "/webjars/springfox-swagger-ui/fonts/source-code-pro-v7-latin-300.woff2",
////                        "/webjars/springfox-swagger-ui/fonts/open-sans-v15-latin-700.woff2",
////                        "/webjars/springfox-swagger-ui/fonts/titillium-web-v6-latin-700.woff2",
////                        "/webjars/springfox-swagger-ui/fonts/open-sans-v15-latin-regular.woff",
////                        "/webjars/springfox-swagger-ui/fonts/source-code-pro-v7-latin-600.woff",
////                        "/webjars/springfox-swagger-ui/fonts/open-sans-v15-latin-700.woff",
////                        "/webjars/springfox-swagger-ui/fonts/source-code-pro-v7-latin-300.woff",
////                        "/webjars/springfox-swagger-ui/fonts/titillium-web-v6-latin-700.woff",
////                        "/webjars/springfox-swagger-ui/fonts/open-sans-v15-latin-regular.woff2"
//
//
//
//                ).permitAll()
//                //拦截所有请求    并设置访问该资源的权限，这里设置为USER
//                .antMatchers("/**").hasAuthority("USER");
//    }
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        // 配置资源 ID
//        resources.resourceId("backend-resources");
//    }
}
