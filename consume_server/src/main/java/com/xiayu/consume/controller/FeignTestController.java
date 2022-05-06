package com.xiayu.consume.controller;

import com.xiayu.consume.remote.ProviderClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhongyu
 * @create 2022-04-28 5:08 下午
 */
@RestController
@RequestMapping("/feign")
public class FeignTestController {

    @Autowired
    ProviderClientService providerClientService;

    @GetMapping
    public String hello(@RequestParam String name) {
        String hello = providerClientService.hello(name);
        return "feign"+hello;
    }
}
