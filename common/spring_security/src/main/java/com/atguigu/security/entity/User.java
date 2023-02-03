package com.atguigu.security.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "用户实体类")
public class User {

    private static final long serialVersionUID = 1l;
    @ApiModelProperty(value = "姓名")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "昵称")
    private String nickName;
    @ApiModelProperty(value = "用户头像")
    private String salt;
    @ApiModelProperty(value = "用户签名")
    private String token;

}
