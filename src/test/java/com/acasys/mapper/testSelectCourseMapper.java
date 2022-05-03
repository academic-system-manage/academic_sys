package com.acasys.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class testSelectCourseMapper {
    @Autowired
    private CourseSelectMapper courseSelectMapper;

    @Test
    public void test(){
        List<Integer> studentList = courseSelectMapper.selectStudents(1);
        System.out.println(studentList);
    }
}
