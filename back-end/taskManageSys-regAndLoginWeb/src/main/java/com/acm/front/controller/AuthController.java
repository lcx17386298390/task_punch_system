package com.acm.front.controller;

import com.acm.front.entity.Result;
import com.acm.front.service.Impl.AuthServiceImpl;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Pattern;

@Validated
@RestController
@RequestMapping("/api")
public class AuthController {
    @Resource
    AuthServiceImpl authService;
    @PostMapping("/testEmail")
    public Result<String> testEmail(@Pattern (regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$") @RequestParam("email")String email,
                                    HttpSession httpSession){
        if(authService.sendEmail(email,httpSession.getId())==null) {
            return Result.success("邮件发送成功");
        } else {
            return Result.failure(400,"邮件发送失败");
        }
    }
    @PostMapping("/register")
    public Result<String> register(@RequestParam("username")String username,
                                   @RequestParam("password")String password,
                                   @RequestParam("email")String email,
                                   @RequestParam("code")String code,
                                   HttpSession httpSession){
        if(authService.testRegister(username, password, email, code,httpSession.getId())==null){
            return Result.success("注册成功");
        }else{
            return Result.failure(400,"注册失败");
        }
    }
}
