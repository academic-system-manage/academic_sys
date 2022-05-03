package com.acasys.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * author:lixuewei
 */
@Data
@TableName("selectedcourse")
public class CourseSelect {
    private Integer studentid;
    private Integer courseid;
    private Integer mark;
}
