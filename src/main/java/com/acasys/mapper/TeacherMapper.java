package com.acasys.mapper;

import com.acasys.domain.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * author:lixuewei
 */
@Mapper
@Repository
public interface TeacherMapper extends BaseMapper<Teacher> {
}
