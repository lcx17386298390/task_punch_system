package com.acm.front.controller;

import com.acm.api.model.TaskItem;
import com.acm.common.constants.Contants;
import com.acm.common.util.CommonUtil;
import com.acm.front.Dao.TaskItemDTO;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
@CrossOrigin
@RestController
public class ViewTaskController extends BaseController{



    @RequestMapping("/taskitem/viewSelfTask")
    public List<TaskItem> viewSelfTaskItem(@RequestParam("name") String name,
                                           @RequestParam(value = "pageNo",required = false,defaultValue = "1") Integer pageNo,
                                           @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize) {
        pageNo = CommonUtil.defaultPageNo(pageNo);
        pageSize = CommonUtil.defaultPageSize(pageSize);
        Integer offset = (pageNo - 1) * pageSize;
        List<TaskItem> taskItems = taskItemService.viewTaskItemFromStu(offset,pageSize,name, Contants.SESSION_STUDENT);
        return taskItems;
        }
@RequestMapping("/score")
    public TaskItemDTO score(@RequestParam("name") String name){
        List<TaskItem> taskItems=taskItemService.viewTaskItemForCal(name,Contants.SESSION_STUDENT);
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
