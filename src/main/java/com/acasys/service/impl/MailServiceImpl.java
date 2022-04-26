package com.acasys.service.impl;

import com.acasys.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Random;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender mailSender;

    //获取配置的发件方邮箱
    @Value("${spring.mail.username}")
    private String from;

    private Date sendTime;

    /**
     * 向获得的用户邮箱发送验证码
     * @param email
     * @param httpSession
     * @return
     */
    @Override
    @Async
    public void sendEmail(String email, HttpSession httpSession) {
        try{
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setSubject("验证码邮件");//邮件主题
            //生成随机验证码
            String code = randomCode();
            sendTime=new Date();
            //将验证码保存到session中
            httpSession.setAttribute("email",email);
            httpSession.setAttribute("code",code);
            httpSession.setAttribute("sendTime",sendTime);
            mailMessage.setText("尊敬的用户,您好:\n"
                    + "\n本次请求的邮件验证码为:" + code + ",本验证码5分钟内有效，请及时输入。（请勿泄露此验证码）\n"
                    + "\n如非本人操作，请忽略该邮件。\n(这是一封自动发送的邮件，请不要直接回复）");//邮件正文
            mailMessage.setTo(email);//收件人
            mailMessage.setFrom(from);//发件人
            //发送
            mailSender.send(mailMessage);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *随机生成6位数的验证码
     * @return
     */
    public String randomCode(){
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }
}
