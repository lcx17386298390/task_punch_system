package com.acm.front.controller;

import com.acm.api.model.TaskItem;
import com.acm.common.constants.Contants;
import com.acm.front.Dao.TaskItemDTO;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ViewTaskController extends BaseController{



    @GetMapping("/viewSelfTask")
    public List<TaskItem> viewSelfTaskItem(@RequestParam("name") String name) {
        List<TaskItem> taskItems = taskItemService.viewTaskItemFromStu(name, Contants.SESSION_STUDENT);
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
        List<TaskItem> taskItems=taskItemService.viewTaskItemFromStu(name,Contants.SESSION_STUDENT);
        TaskItemDTO taskItemDTO=new TaskItemDTO();
        BigDecimal totalJudgeFinish = BigDecimal.valueOf(0.0);
        if(taskItems!=null&&!taskItems.isEmpty()){
            for(TaskItem t:taskItems){
                t.getJudgefinish();
                totalJudgeFinish = totalJudgeFinish.add(t.getJudgefinish());
            }
            taskItemDTO.setAverageJudgeFinish(totalJudgeFinish.subtract(BigDecimal.valueOf(taskItems.size())));
        }else {
            System.out.println("统计错误！！");
        }
        return taskItemDTO;
}


    }
