package com.acasys.mapper;

import com.acasys.domain.Task;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherTaskWordDao extends BaseMapper<Task> {
}
