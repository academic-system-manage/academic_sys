package com.acasys.mapper;

import com.acasys.domain.DetailMark;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DetailMarkMapper extends BaseMapper<DetailMark> {

    @Select("select * from detailmark where studentid=#{studentid} and courseid=#{courseid}")
    @Results(
            @Result(column = "taskid",property = "task.idtask")
    )
    List<DetailMark> getAll(Integer studentid, Integer courseid);
}
