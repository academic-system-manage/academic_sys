package com.acasys.mapper;

import com.acasys.domain.DetailMark;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * author:lixuewei
 */
@Mapper
public interface DetailMarkMapper extends BaseMapper<DetailMark> {

    @Select("select * from detailmark where studentid=#{studentid} and courseid=#{courseid}")
    @Results(
            @Result(column = "taskid",property = "task.idtask")
    )
    List<DetailMark> getAll(Integer studentid, Integer courseid);

    @Insert("insert into detailmark values( #{mark}, #{studentid}, #{courseid}, #{task.idtask})")
    int add(DetailMark detailMark);
}
