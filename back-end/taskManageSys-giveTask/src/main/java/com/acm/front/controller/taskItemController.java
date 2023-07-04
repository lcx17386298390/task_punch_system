package com.acm.front.controller;

import com.acm.api.model.Task;
import com.acm.api.model.TaskItem;
import com.acm.common.constants.Contants;
import com.acm.common.view.ReturnObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class taskItemController extends BaseController{

    @RequestMapping("/taskitem/create")
    public @ResponseBody Object createTaskItem(String id,String content,String  name){
        TaskItem taskItem = new TaskItem();
        ReturnObject returnObject = new ReturnObject();
        taskItem.setContent(content);
        taskItem.setId(id);
        taskItem.setJudgefinish(0.0);
        taskItem.setName(name);
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

    @RequestMapping("/taskitem/edit")
    public @ResponseBody Object editTaskItemById(String id,String name,String content,Double judgefinish){
        TaskItem taskItem = new TaskItem();
        taskItem.setName(name);
        taskItem.setContent(content);
        taskItem.setJudgefinish(judgefinish);
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
}
