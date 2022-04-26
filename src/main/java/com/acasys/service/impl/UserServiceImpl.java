package com.acasys.service.impl;

import com.acasys.domain.User;
import com.acasys.mapper.UserMapper;
import com.acasys.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    private Date date;

    /**
     * 登录（邮箱+密码）
     * @param user
     * @param session
     * @return
     */
    @Override
    public User login(User user, HttpSession session) {
        String email = user.getEmail();
        System.out.println(email);
        User user1 = userMapper.selectByEmail(email);
        if(user1==null)return null;
        else
            if (user.getPassword().equals(user1.getPassword())){
                //将User保存到session中
                session.setAttribute("user",user1);
                return user1;//密码正确，返回User对象
            }
            else return null;//密码错误，登录失败
    }

    /**
     * 注册，同时检验验证码
     * @param user
     * @return
     */
    @Override
    public Boolean regist(User user, HttpSession session) {
        //获取session中的验证信息
        String email = (String) session.getAttribute("email");
        String code = (String) session.getAttribute("code");
        Date sendTime= (Date) session.getAttribute("sendTime");
        //获取表单提交的验证信息并进行验证
        if(email==null||user.getEmail().isEmpty()/*||email.equals(user.getEmail())*/){//测试阶段只有一个邮箱可以用来测试
            System.out.println("email数据为空，或者不一致，注册失败");
            session.setAttribute("regist_msg","邮箱为空，或者不一致，注册失败");
            return false;//email数据为空，或者不一致，注册失败
        }else if(userMapper.selectByUsername(user.getUsername())!=null){
            System.out.println("用户名已存在，注册失败");
            session.setAttribute("regist_msg","用户名已存在，注册失败");
            return false;//用户名已存在，注册失败
        }else {
            if(code.isEmpty()||!code.equals(user.getCode())){
                System.out.println("验证码错误，注册失败");
                session.setAttribute("regist_msg","验证码错误，注册失败");
                return false;//验证码错误，注册失败
            }
            date=new Date();
            int i = (int) (date.getTime() - sendTime.getTime()) / (60 * 1000);
            if(i>5){
                System.out.println("验证码已失效，请重新获取");
                session.setAttribute("regist_msg","验证码已失效，请重新获取");
                return false;
            }
        }

        //保存数据
        userMapper.saveUser(user);
        //跳转成功页面
        return true;
    }

    /**
     * 修改密码
     * @param email
     * @param newPSW
     * @param code
     * @return
     */
    @Override
    public Boolean updatePassword(String email, String newPSW, String code,HttpSession session) {
        //获取session中的验证信息
        String s_email = (String) session.getAttribute("email");
        String s_code = (String) session.getAttribute("code");
        Date sendTime= (Date) session.getAttribute("sendTime");

        if(email==null||s_email==null/*||email.equals(s_email)*/){
            session.setAttribute("modify_msg","邮箱为空，或者不一致，修改密码失败");
            return false;//email数据为空，或者不一致，注册失败
        }else {
            if(code.isEmpty()||!code.equals(s_code)){
                session.setAttribute("modify_msg","验证码错误，修改密码失败");
                return false;//验证码错误，注册失败
            }
            date=new Date();
            int i = (int) (date.getTime() - sendTime.getTime()) / (60 * 1000);
            if(i>5){
                session.setAttribute("modify_msg","验证码已失效，请重新获取");
                return false;
            }
        }

        userMapper.updatePSW(email,newPSW);
        return true;
    }


}
