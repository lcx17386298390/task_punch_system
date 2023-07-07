package com.acm.msgtomail.front.controller;

import com.acm.api.service.sendMsgService;
import org.apache.dubbo.config.annotation.DubboReference;


public class BaseController {
    @DubboReference(interfaceClass = sendMsgService.class,version = "1.0",check = false)
    protected sendMsgService sendMsgService;


}
