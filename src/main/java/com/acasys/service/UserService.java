package com.acasys.service;


import com.acasys.domain.User;

import javax.servlet.http.HttpSession;

public interface UserService {
    public User login(User user, HttpSession session);
    public Boolean regist(User user, HttpSession session);
    Boolean updatePassword(String email, String newPSW, String code,HttpSession session);
}
