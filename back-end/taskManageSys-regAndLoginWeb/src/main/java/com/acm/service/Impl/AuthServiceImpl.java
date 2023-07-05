package com.acm.service.Impl;

import com.acm.api.model.Admin;
import com.acm.dataservice.mapper.AdminMapper;
import com.acm.service.AuthService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class AuthServiceImpl implements AuthService {
    @Resource
    AdminMapper adminMapper;
    @Resource
    MailSender mailSender;
    @Value("${spring.mail.username}")
    String from;
    @Resource
    StringRedisTemplate stringRedisTemplate;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username==null)
            throw new UsernameNotFoundException("用户名不能为空");
        Admin admin=adminMapper.findAuthByName(username);
        if(admin==null)
            throw new UsernameNotFoundException("用户名或密码错误");
        return User
                .withUsername(admin.getUsername())
                .password(admin.getPassword())
                .roles("user")
                .build();
    }

    @Override
    public boolean sendEmail(String email,String sessionId) {
        String key="email:"+sessionId+":"+email;
        if(Boolean.TRUE.equals(stringRedisTemplate.hasKey(key))){
            Long expire= Optional.ofNullable(stringRedisTemplate.getExpire(key,TimeUnit.SECONDS)).orElse(0L);
            if(expire>120)
                return false;
        }
        Random random=new Random();
        int code= random.nextInt(800000)+100000;
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setSubject("验证邮件");
        simpleMailMessage.setText("验证码为:"+code);
        try{
            mailSender.send(simpleMailMessage);
            stringRedisTemplate.opsForValue().set(key,String.valueOf(code),3, TimeUnit.MINUTES);
            return true;
        }catch (MailException e){
            e.printStackTrace();
            return false;
        }
    }
}
