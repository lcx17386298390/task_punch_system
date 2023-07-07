package com.acm.msgtomail.front.controller;

import com.acm.api.model.SendMsg;
import com.acm.common.view.ReturnObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class msgToMailController extends BaseController{

    @RequestMapping("/sendmessage")
    public SendMsg intsendMsg(@RequestParam("id") String id,
                              @RequestParam("fromuser") String fromuser,
                              @RequestParam("toname") String  toname,
                              @RequestParam("msg")String msg){
        SendMsg sendMsg=new SendMsg();
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
        returnObject.setMessage("发送失败");
        return sendMsg;
    }

    @RequestMapping("/querymsg")
    public List<SendMsg> selectMsg(@RequestParam("fromuser")String fromuser,
                                   @RequestParam("touser") String touser){
        List<SendMsg> sendMsgs =sendMsgService.selectByFromUserAndToUser(fromuser,touser);
        if (sendMsgs != null && !sendMsgs.isEmpty()) {
            for(SendMsg sendMsg:sendMsgs){
                sendMsg.getFromuser();
                sendMsg.getMsg();
                sendMsg.getTouser();
                sendMsg.getId();
                System.out.println("成功" + " =" + sendMsg);
            }
        }else {
            System.out.println("失败");
        }
        return sendMsgs;

    }


}
