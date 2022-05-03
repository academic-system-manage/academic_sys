package com.acasys.controller;


import com.acasys.domain.Student;
import com.acasys.domain.Teacher;
import com.acasys.domain.User;
import com.acasys.service.MailService;
import com.acasys.service.UserService;
import com.acasys.utils.R;
import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * author:lixuewei
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MailService mailService;


    private String regist_msg;
    private String modify_msg;

    /**
     * 登录，根据邮箱、密码
     * @param
     * @return
     */
    @PostMapping(value = "/login" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public R login(@RequestBody User u, HttpSession session){

        User user = userService.login(u,session);//返回当前登录User对象
        System.out.println(user);
        if(user!=null){
            user.setPassword(null);
            return new R(1,"登录成功",user);
        }
        else {
            return new R(1,"登录失败",user);
        }
    }

    /**
     * 获取当前用户详细信息
     * @return
     */
    @GetMapping("/info")
    public R getInfo(HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user==null)return new R(0,"查询失败，请先登录",null);
        if("老师".equals(user.getRole())){
            Teacher teacher = (Teacher) session.getAttribute("teacher");
            return new R(1,"查询成功",teacher);
        }
        if(user.getRole()=="学生"){
            Student student = (Student) session.getAttribute("student");
            return new R(1,"查询成功",student);
        }
        return new R(0,"查询失败",null);
    }

    /**
     * 老师查看选某一门课的所有学生
     */
    @GetMapping("/students/{courseid}")
    public R getStudents_Course(@PathVariable Integer courseid){
        List<Student> studentList= userService.getStudentsOfCourse(courseid);
        return new R(1,"查询成功",studentList);
    }

    /**
     * 获取验证码接口
     * @param
     * @param httpSession
     * @return
     */
    @PostMapping("/sendEmail")
    public R sendEmail(@RequestBody JSONObject jsonObject, HttpSession httpSession)  {
        String email = jsonObject.getString("email");
        //调用mailService向用户邮箱发送验证码邮件
        mailService.sendEmail(email, httpSession);
        return new R(1,"验证码已成功发送",null);
    }

//    /**
//     * 注册，即增加用户
//     * @param
//     * @return
//     */
//    @PostMapping(value = "/regist",produces = MediaType.APPLICATION_JSON_VALUE)
//    public R regist(@RequestBody JSONObject jsonObject, HttpSession httpSession) throws Exception {
//        //获取并封装数据
//        User user = new User();
//        user.setPassword(jsonObject.getString("password"));
//        user.setUsername(jsonObject.getString("username"));
//        user.setEmail(jsonObject.getString("email"));
//        user.setCode(jsonObject.getString("code"));
//        //注册
//        Boolean rf = userService.regist(user, httpSession);
//        if(rf) return new R(1,"注册成功",null);//返回注册成功
//        else {
//            regist_msg= (String) httpSession.getAttribute("regist_msg");
//            return new R(0,regist_msg,null);//注册失败
//        }
//    }

    /**
     * 修改密码
     * @param jsonObject
     * @param session
     * @return
     * @throws Exception
     */
//    @PostMapping(value = "/modifyPass",produces = MediaType.APPLICATION_JSON_VALUE)
//    public R modifyPass(@RequestBody JSONObject jsonObject, HttpSession session) {
//        String email = jsonObject.getString("email");
//        String newPSW = jsonObject.getString("newPSW");
//        String code = jsonObject.getString("code");
//        Boolean mf = userService.updatePassword(email, newPSW, code, session);
//        if(mf) return new R(1,"修改密码成功",null);
//        else {
//            modify_msg= (String) session.getAttribute("modify_msg");
//            return new R(0,modify_msg,null);
//        }
//    }


}
