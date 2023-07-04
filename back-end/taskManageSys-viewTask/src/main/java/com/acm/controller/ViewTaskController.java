package com.acm.controller;

import com.acm.api.model.TaskItem;
import com.acm.api.service.TaskItemService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DubboService(interfaceClass = TaskItemService.class,version = "1.0")

public class ViewTaskController {

    @Resource
    private TaskItemService taskItemService;


    @GetMapping("/insertTaskItem")
    public TaskItem viewTaskItemByName(@RequestParam("name") String name) {
        TaskItem taskItem = taskItemService.viewTaskItemByName(name);
        if (taskItem != null) {
            taskItem.getName();
            taskItem.getContent();
            taskItem.getJudgefinish();
            taskItem.getId();
            System.out.println("查询成功"+" ="+taskItem);
        }else if (taskItem==null){
            System.out.println("查询失败！！！！");
        }
        return taskItem;
    }
}
