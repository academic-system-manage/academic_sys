package com.acasys.mapper;

import com.acasys.domain.CourseSelect;
import com.acasys.domain.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author:lixuewei
 */
@Mapper
@Repository
public interface CourseSelectMapper extends BaseMapper<CourseSelect> {
    @Select("select studentid from selectedcourse where courseid=#{courseid}")

    List<Integer> selectStudents(Integer courseid);
}
