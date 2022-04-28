package com.xiayu.oauth2.controller;

import com.xiayu.oauth2.vo.user.LoginReqVo;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author xuhongyu
 * @create 2022-04-26 12:25 下午
 */
@Slf4j
@RestController
@RequestMapping("/user/")
public class UserController {

    //@Value("${business.oauth2.grant_type}")
    public String oauth2GrantType = "password";

   // @Value("${business.oauth2.client_secret}")
    public String oauth2ClientSecret = "secret";

   // @Value("${business.oauth2.client_id}")
    public String oauth2ClientId = "client";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value = "login/")
    public Object login(@RequestBody @Valid LoginReqVo loginReqVo){

        String url = "http://localhost:9876/oauth/token/";

        // 通过 HTTP 客户端请求登录接口
        Map<String, String> params = new HashMap<>();
        params.put("username", loginReqVo.getUserName());
        params.put("password", loginReqVo.getPassword());
        params.put("grant_type", oauth2GrantType);
        params.put("client_id", oauth2ClientId);
        params.put("client_secret", oauth2ClientSecret);

        ResponseEntity<Object> objectResponseEntity = restTemplate.postForEntity(url, params, Object.class);
        System.out.println(objectResponseEntity);
        try {
//            // 解析响应结果封装并返回
//            Response response = OkHttpClientUtil.getInstance().postData(URL_OAUTH_TOKEN, params);
//            String jsonString = Objects.requireNonNull(response.body()).string();
//            Map<String, Object> jsonMap = MapperUtils.json2map(jsonString);
//            String token = String.valueOf(jsonMap.get("access_token"));
//            if(MapperUtils.isBlank(token)){
//                return new ResponseResult<>(HttpStatus.OK.value(), BusinessConstants.BREAKING_MESSAGE, result);
//            }
//            result.put("token", token);
//            result.put("userName", loginParam.getUsername());
//            // 发送登录日志
//            sendAdminLoginLog(userDetails.getUsername(), request);
//            // 更新最后登录时间
//            updateUserLastTime(userDetails.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("用户登录成功",loginReqVo.getUserName());

        return null;
    }

}
