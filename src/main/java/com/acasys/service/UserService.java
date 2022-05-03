package com.acasys.service;


import com.acasys.domain.Student;
import com.acasys.domain.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {
    public User login(User user, HttpSession session);

    List<Student> getStudentsOfCourse(Integer courseid);
//    public Boolean regist(User user, HttpSession session);
//    Boolean updatePassword(String email, String newPSW, String code,HttpSession session);
}
