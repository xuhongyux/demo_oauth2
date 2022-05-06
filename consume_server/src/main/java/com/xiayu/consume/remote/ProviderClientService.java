package com.xiayu.consume.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xuhongyu
 * @create 2022-04-28 5:30 下午
 */
@FeignClient("provider")
public interface ProviderClientService {

    /**
     * 测试接口
     * @param name
     * @return
     */
    @GetMapping(value = "/hello/")
    public String hello(@RequestParam String name);

}
