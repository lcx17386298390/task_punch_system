package com.acm.msgtomail.front.controller;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class msgToMailController extends BaseController{

    @RequestMapping("/sendmessage")
    public String sendmessage(@RequestParam("fromuser") String fromuser,
                              @RequestParam("touser") String touser,
                              @RequestParam("msg") String msg)
    {

        int result=sendMsgService.insertMsgBytouser(fromuser,touser,msg);
        if(result!=0)
        {
            return "发送成功！";
        }else {
            return "发送失败！";
        }
    }




}
