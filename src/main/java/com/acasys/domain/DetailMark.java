package com.acasys.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("/detailmark")
public class DetailMark {
    private Integer studentid;
    private Integer courseid;
    private Integer mark;
    private Task task;
}
