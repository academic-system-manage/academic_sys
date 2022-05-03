package com.acasys.controller;

import com.acasys.domain.CourseSelect;
import com.acasys.domain.DetailMark;
import com.acasys.service.GradeService;
import com.acasys.utils.R;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xml.internal.serializer.utils.BoolStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author:lixuewei
 */
@RestController
@RequestMapping("/grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    /**
    根据学生id获取每门课的成绩
     */
    @GetMapping("/all/{id}")
    public R getGrades(@PathVariable Integer id){
        List<CourseSelect> list= gradeService.getCourseGrade(id);
        return new R(1,"查询成功",list);
    }

    /**
     * 根据学生id、课程id获取该课程的作业、实验、考试信息和成绩
     */
    @GetMapping("/detail/{studentid}/{courseid}")
    public R getDetailGrade(@PathVariable Integer studentid,@PathVariable Integer courseid){
        List<DetailMark> detailMarkList = gradeService.getDetailGrade(studentid,courseid);
        return new R(1,"查询成功",detailMarkList);
    }

    /**
     * 分类获取（作业、实验、考试）
     * 根据学生id、课程id获取该课程的作业、实验、考试信息和成绩
     */


    /**
     * 登记成绩
     * 参数：课程id，学生id，课程总分
     */
    @PostMapping("/setGrade")
    public R setGrade(@RequestBody JSONObject jsonObject){
//        Integer teacherid = jsonObject.getInteger("teacherid");
        Integer courseid = jsonObject.getInteger("courseid");
        Integer studentid = jsonObject.getInteger("studentid");
        Integer mark = jsonObject.getInteger("mark");

        Boolean flag = gradeService.setGrade(courseid,studentid,mark);
        if(flag)return new R(1,"录入成功",null);
        else return new R(0,"录入失败",null);
    }

    /**
     * 登记成绩
     * 参数：课程id，
     *      学生id，task id，mark
     */
    @PostMapping("/setDetailGrade")
    public R setDetailGrade(@RequestBody JSONObject jsonObject){
        Integer courseid = jsonObject.getInteger("courseid");
        Integer studentid = jsonObject.getInteger("studentid");
        Integer taskid = jsonObject.getInteger("taskid");
        Integer mark = jsonObject.getInteger("mark");

        Boolean flag = gradeService.setDetailGrade(courseid,studentid,taskid,mark);
        if(flag)return new R(1,"录入成功",null);
        else return new R(0,"录入失败",null);
    }

}
