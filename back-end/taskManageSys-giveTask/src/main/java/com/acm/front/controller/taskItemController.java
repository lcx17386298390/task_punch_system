package com.acm.front.controller;

import com.acm.api.model.TaskItem;
import com.acm.common.constants.Contants;
import com.acm.common.util.UUIDUtils;
import com.acm.common.view.PageInfo;
import com.acm.common.view.ReturnObject;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
@CrossOrigin
@RestController
public class taskItemController extends BaseController{
    /**
     * 管理者创建任务点
     * @param id
     * @param content
     * @param name
     * @return
     */
    @RequestMapping("/taskitem/create")
    public @ResponseBody Object createTaskItem(String id,String content,String  name){
        TaskItem taskItem = new TaskItem();
        ReturnObject returnObject = new ReturnObject();
        taskItem.setContent(content);
        taskItem.setId(id);
        taskItem.setJudgefinish(BigDecimal.valueOf(0.0));
        taskItem.setName(name);
        taskItem.setPublisher(Contants.SESSION_ADMIN);
        int cnt = taskItemService.insert(taskItem);
        if(cnt > 0){
            returnObject.setMessage("创建成功");
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setRetData(taskItem);
            return returnObject;
        }
        returnObject.setMessage("创建失败！请稍后再试");
        returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
        return returnObject;
    }


    /**
     * 管理者/学生可删除自己布置的任务点
     * @param id
     * @param name
     * @return
     */

    @RequestMapping("/taskitem/delete")
    public @ResponseBody Object deleteTaskItem(String id,String name){
        ReturnObject returnObject = new ReturnObject();
        int cnt = taskItemService.deleteByIdAndName(id,name);
        if(cnt > 0){
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("删除成功");
            return returnObject;
        }
        returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
        returnObject.setMessage("删除失败！请稍后再试");
        return returnObject;
    }

    /**
     * 管理者可修改自己的任务点
     * @param id
     * @param name
     * @param content
     * @param judgefinish
     * @return
     */
    @RequestMapping("/taskitem/edit")
    public @ResponseBody Object editTaskItemById(String id,String name,String content,Double judgefinish){
        TaskItem taskItem = new TaskItem();
        taskItem.setName(name);
        taskItem.setContent(content);
        taskItem.setJudgefinish(BigDecimal.valueOf(judgefinish));
        ReturnObject returnObject = new ReturnObject();
        int cnt = taskItemService.editTaskItemById(id,name,content,judgefinish);
        if(cnt > 0){
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("修改成功");
            return returnObject;
        }
        returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
        returnObject.setMessage("修改失败！请稍后再试");
        return returnObject;
    }

    /**
     * 管理者可通过学生姓名的切换以查看给学生布置的任务点
     * @param name
     * @param id
     * @return
     */

    @RequestMapping("/taskitem/view")
    public @ResponseBody Object viewTaskItemByIdAndName(String name,String id){
        ReturnObject returnObject = new ReturnObject();
        TaskItem taskItem = taskItemService.viewTaskItemByIdAndName(id,name);
        if(taskItem != null){
            returnObject.setRetData(taskItem);
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("查找成功");
            return returnObject;
        }
        returnObject.setMessage("查找失败！请稍后再试");
        returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
        return returnObject;
    }

    /**
     * 学生创建自己的任务
     * @param content
     * @param name
     * @return
     */
    @RequestMapping("/taskitem/createSelfTaskItem")
    public @ResponseBody Object createSelfTaskItem(String content,String name){
        TaskItem taskItem = new TaskItem();
        taskItem.setContent(content);
        taskItem.setName(name);
        taskItem.setId(UUIDUtils.getUUID());
        taskItem.setJudgefinish(BigDecimal.valueOf(0.0));
        taskItem.setPublisher(Contants.SESSION_STUDENT);
        ReturnObject returnObject = new ReturnObject();
        int cnt = taskItemService.insert(taskItem);
        if(cnt > 0){
            returnObject.setMessage("创建成功");
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setRetData(taskItem);
            return returnObject;
        }
        returnObject.setMessage("创建失败！请稍后再试");
        returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
        return returnObject;
    }

    /**
     * 查看当前学生的所有给自己布置任务的页码信息
     * @param pageNo
     * @param pageSize
     * @param name
     * @return
     */
    @RequestMapping("/taskitem/cal")
    public @ResponseBody Object calCountOfTask( @RequestParam(value = "pageNo",required = false,defaultValue = "1") Integer pageNo,
                                                @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize,String name){
        int totalRecord = taskItemService.calCountOfTaskItem(name,Contants.SESSION_STUDENT);
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

    /**
     * 管理者给学生任务点评分
     * @param name
     * @param judgefinish
     * @param id
     * @return
     */
    @RequestMapping("/taskitem/givemark")
    public @ResponseBody Object giveMark(String name,BigDecimal judgefinish,String id){
        ReturnObject returnObject = new ReturnObject();
        int cnt = taskItemService.giveMark(name,judgefinish,id);
        if(cnt > 0){
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("评分成功");
            return returnObject;
        }
        returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
        returnObject.setMessage("评分失败！请稍后再试");
        return returnObject;
    }
}
