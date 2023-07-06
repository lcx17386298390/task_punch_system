package com.acm.front.controller;

import com.acm.api.service.TaskItemService;
import com.acm.api.service.TaskService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.CrossOrigin;


public class BaseController {
    @DubboReference(interfaceClass = TaskService.class,version = "1.0",check = false)
    protected TaskService taskService;

    @DubboReference(interfaceClass = TaskItemService.class,version = "1.0",check = false)
    protected TaskItemService taskItemService;
}
