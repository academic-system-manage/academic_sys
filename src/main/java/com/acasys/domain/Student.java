package com.acasys.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * author:lixuewei
 */
@Data
@TableName("student")
public class Student {
    private Integer studentid;
    private String studentname;
    private String sex;
    private Integer collegeid;
}
