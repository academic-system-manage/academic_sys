package com.acasys.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * author:lixuewei
 */
@Data
@TableName("tb_student")
public class Student {
    private Integer studentID;
    private String studentName;
    private String sex;
    private Integer collegeID;
}
