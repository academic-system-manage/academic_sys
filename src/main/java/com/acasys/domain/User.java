package com.acasys.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("userlogin")
public class User {
    private Integer userID;
    private String password;
    private String role;
//    private String email;

    //验证码
//    @TableField(exist = false)
//    private String code;
}
