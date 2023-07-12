package com.acm.givetask.controller;

import com.acm.api.service.TaskItemService;
import org.apache.dubbo.config.annotation.DubboReference;


public class BaseController {
    @DubboReference(interfaceClass = TaskItemService.class,version = "1.0",check = false)
    protected TaskItemService taskItemService;
}
