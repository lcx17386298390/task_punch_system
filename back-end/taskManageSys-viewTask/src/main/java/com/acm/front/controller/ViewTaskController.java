package com.acm.front.controller;

import com.acm.api.model.TaskItem;
import com.acm.common.constants.Contants;
import com.acm.common.util.CommonUtil;
import com.acm.common.view.PageInfo;
import com.acm.front.Dao.TaskItemDTO;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
@CrossOrigin
@RestController
public class ViewTaskController extends BaseController{


    /**
     * 学生查看自己的所有自己布置的任务点
     * @param name
     * @param pageNo
     * @param pageSize
     * @return
     */
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

    /**
     * 计算管理者给学生所布置的任务点的均分
     * @param name
     * @return
     */
    @RequestMapping("/taskitem/score")
    public TaskItemDTO score(@RequestParam("name") String name){
        List<TaskItem> taskItems=taskItemService.viewTaskItemForCal(name,Contants.SESSION_ADMIN);
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

    /**
     * 管理者查看所有学生布置给学生自己的任务点
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/taskitem/viewAllTask")
    public List<TaskItem> viewAllSelfTaskItem(
                                           @RequestParam(value = "pageNo",required = false,defaultValue = "1") Integer pageNo,
                                           @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize) {
        pageNo = CommonUtil.defaultPageNo(pageNo);
        pageSize = CommonUtil.defaultPageSize(pageSize);
        Integer offset = (pageNo - 1) * pageSize;
        List<TaskItem> taskItems = taskItemService.viewAllTaskItemFromStu(offset,pageSize,Contants.SESSION_STUDENT);
        return taskItems;
    }

    /**
     * 管理者查看所有学生的任务点的页面信息
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/taskitem/calAllTaskItem")
    public @ResponseBody Object calCountOfTask( @RequestParam(value = "pageNo",required = false,defaultValue = "1") Integer pageNo,
                                                @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize){
        int totalRecord = taskItemService.calCountOfAllTaskItem(Contants.SESSION_STUDENT);
        PageInfo pageInfo = new PageInfo();
        Integer totalPage = 0;
        //计算总页数
        if( totalRecord % pageSize  == 0 ){
            totalPage = totalRecord / pageSize;
        } else {
            totalPage = totalRecord / pageSize + 1;
        }
        pageInfo.setPageNo(pageNo);
        pageInfo.setTotalPage(totalPage);
        pageInfo.setTotalRecord(totalRecord);
        return pageInfo;
    }
}
