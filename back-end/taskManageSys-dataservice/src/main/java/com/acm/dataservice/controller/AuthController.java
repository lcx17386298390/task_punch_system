package com.acm.dataservice.controller;

import com.acm.dataservice.service.AuthService;
import com.acm.regandlogin.entity.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Pattern;

@Validated
@RestController
@RequestMapping("/api")
public class AuthController {
    @Resource
    AuthService authService;
    @PostMapping("/testEmail")
    public Result<String> testEmail(@Pattern (regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")
                                        @RequestParam String email,
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
