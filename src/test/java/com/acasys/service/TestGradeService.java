package com.acasys.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestGradeService {
    @Autowired
    private GradeService gradeService;
    @Test
    public void test1(){
        gradeService.setDetailGrade(1,2019303812,2,99);
    }

    @Test
    public void test2(){

        gradeService.setGrade(1,2019303815,100);
    }
}
