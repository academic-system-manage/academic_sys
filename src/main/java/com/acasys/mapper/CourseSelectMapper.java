package com.acasys.mapper;

import com.acasys.domain.CourseSelect;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CourseSelectMapper extends BaseMapper<CourseSelect> {
}
