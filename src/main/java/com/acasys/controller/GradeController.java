package com.acasys.controller;

import com.acasys.domain.CourseSelect;
import com.acasys.domain.DetailMark;
import com.acasys.service.GradeService;
import com.acasys.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
     */

}
