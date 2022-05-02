package com.acasys.mapper;

import com.acasys.domain.Task;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CheckTaskDao extends BaseMapper<Task> {
    @Select("select * from task where courseid=#{courseid}")
    List<Task> selectByCourseid(Integer courseid);
}
