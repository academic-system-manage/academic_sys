package com.acasys.service;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.servlet.http.HttpSession;

public interface MailService {
    public void sendEmail(String email, HttpSession httpSession);
}
