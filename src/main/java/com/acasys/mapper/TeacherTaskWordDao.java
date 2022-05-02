package com.edusystem.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edusystem.Domain.Task;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherTaskWordDao extends BaseMapper<Task> {
}
