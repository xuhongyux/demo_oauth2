package com.xiayu.consume.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhongyu
 * @create 2022-04-28 5:08 下午
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String hello(@RequestParam String name) {


        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)
                SecurityContextHolder.getContext().getAuthentication().getDetails();

        return "consumer" + "-你好：" + name;
    }
}
