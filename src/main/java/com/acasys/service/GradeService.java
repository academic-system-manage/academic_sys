package com.acasys.service;

import com.acasys.domain.CourseSelect;
import com.acasys.domain.DetailMark;

import java.util.List;

public interface GradeService {
    List<CourseSelect> getCourseGrade(Integer studentid);

    List<DetailMark> getDetailGrade(Integer studentid, Integer courseid);
}
