package com.acm.front.controller;

import com.acm.front.Dao.TaskItemDTO;
import com.acm.api.model.TaskItem;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class ViewTaskController extends BaseController{



    @RequestMapping("/6")
    public String hello(){
        return "index";
    }

    @GetMapping("/insertItem")
    public List<TaskItem> viewTaskItemByName(@RequestParam("name") String name) {
        List<TaskItem> taskItems = taskItemService.viewTaskItemByName(name);
        if (taskItems != null && !taskItems.isEmpty()) {
            for (TaskItem taskItem : taskItems) {
                taskItem.getName();
                taskItem.getContent();
                taskItem.getJudgefinish();
                taskItem.getId();
                System.out.println("查询成功" + " =" + taskItem);
            }

        }else {
            System.out.println("查询失败！！！！");
        }
        return taskItems;
        }
@RequestMapping("/score")
    public TaskItemDTO score(@RequestParam("name") String name){
        List<TaskItem> taskItems=taskItemService.viewTaskItemByName(name);
        TaskItemDTO taskItemDTO=new TaskItemDTO();
        double totalJudgeFinish = 0;
        if(taskItems!=null&&!taskItems.isEmpty()){
            for(TaskItem t:taskItems){
                t.getJudgefinish();
                totalJudgeFinish+=t.getJudgefinish();
            }
            taskItemDTO.setAverageJudgeFinish(totalJudgeFinish/ taskItems.size());
        }else {
            System.out.println("统计错误！！");
        }
        return taskItemDTO;
}


    }
