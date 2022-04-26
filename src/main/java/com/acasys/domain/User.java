package com.acasys.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Users")
public class User {

    private int id;
    private String password;
    private String username;
    private String email;

    //验证码
    @TableField(exist = false)
    private String code;
}
