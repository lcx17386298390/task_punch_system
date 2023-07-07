package com.acm.msgtomail.front.controller;


import com.acm.api.model.TaskItem;
import com.acm.api.model.sendMsg;
import com.acm.common.constants.Contants;
import com.acm.common.view.ReturnObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
public class msgToMailController extends BaseController{

    @RequestMapping("/sendmessage")
    public sendMsg  intsendMsg(@RequestParam("id") String id,
                               @RequestParam("fromuser") String fromuser,
                               @RequestParam("toname") String  toname,
                               @RequestParam("msg")String msg){
        sendMsg sendMsg=new sendMsg();
        ReturnObject returnObject = new ReturnObject();
        sendMsg.setId(id);
        sendMsg.setFromuser(fromuser);
        sendMsg.setTouser(toname);
        sendMsg.setMsg(msg);
        int ak = sendMsgService.insert(sendMsg);
        if(ak > 0){
            returnObject.setMessage("发送成功");
            return sendMsg;
        }
        returnObject.setMessage("创建失败！请稍后再试");
        return sendMsg;
    }




}
