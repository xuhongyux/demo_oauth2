package com.xiayu.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhongyu
 * @create 2022-04-25 2:38 下午
 */

@RestController
@RequestMapping("hello")
public class HelloController {


    @GetMapping(value = "/")
    public String hello(){
        return "name"+"你好！";
    }
}
