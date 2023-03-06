package com.xiayu.demo.vo.user;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * @author xuhongyu
 * @create 2022-04-26 12:45 下午
 */

@Data
//@ApiModel("用户登录")
public class LoginReqVo {
//    @ApiModelProperty("用户名称")
    @NotNull(message = "用户ID不能为空")
    private String userName;

   // @ApiModelProperty("密码")
    @NotNull(message = "密码不能为空")
    private String password;
}
