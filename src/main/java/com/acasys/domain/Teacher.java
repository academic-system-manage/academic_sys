package com.acasys.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * author:lixuewei
 */
@Data
@TableName("teacher")
public class Teacher {
    private Integer teacherID;
    private String teacherName;
    private String sex;
    private Integer collegeID;
}
