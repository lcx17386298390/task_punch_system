package com.acm.front.controller;

import com.acm.api.model.Task;
import com.acm.common.constants.Contants;
import com.acm.common.util.CommonUtil;
import com.acm.common.util.UUIDUtils;
import com.acm.common.view.PageInfo;
import com.acm.common.view.ReturnObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class taskController extends BaseController{

    @RequestMapping("/task/create")
    public @ResponseBody Object createTask(String title, String content){
        Task task = new Task();
        ReturnObject returnObject = new ReturnObject();
        /*if(title ==null && content == null){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("创建失败！标题或内容为空");
                return returnObject;
                标题和内容在前端判断
        }*/
        int cnt = taskService.insert(title, UUIDUtils.getUUID(), content);
        if(cnt > 0){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                returnObject.setMessage("创建成功");
                returnObject.setRetData(task);
            }else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("创建失败！请稍后再试");
                return returnObject;
            }
        return returnObject;
    }


    @RequestMapping("/task")
    public @ResponseBody Object queryTaskList(@RequestParam(value = "pageNo",required = false,defaultValue = "1") Integer pageNo,
                                    @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize){
        pageNo = CommonUtil.defaultPageNo(pageNo);
        pageSize = CommonUtil.defaultPageSize(pageSize);
        Integer offset = (pageNo - 1) * pageSize;
        List<Task> taskList = taskService.queryTaskList(offset, pageSize);
        return taskList;
    }

    @RequestMapping("/task/delete")
    public @ResponseBody Object deleteTaskById(String id){
        /**
         * id的值由前端判断
         */
        int cnt = taskService.deleteByPrimaryKey(id);
        ReturnObject returnObject = new ReturnObject();
        if(cnt > 0){
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("删除成功");
            return returnObject;
        }
        returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
        returnObject.setMessage("删除失败！请稍后再试");
        return returnObject;
    }

    @RequestMapping("/task/edit")
    public @ResponseBody Object editTaskById(String id,String title,String content){
        Task task = new Task();
        task.setTitle(title);
        task.setId(id);
        task.setContent(content);
        ReturnObject returnObject = new ReturnObject();
        int cnt = taskService.updateByPrimaryKey(task);
        if(cnt > 0){
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("修改成功");
            return returnObject;
        }
        returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
        returnObject.setMessage("修改失败！请稍后再试");
        return returnObject;
    }

    @RequestMapping("/task/cal")
    public @ResponseBody Object calCountOfTask( @RequestParam(value = "pageNo",required = false,defaultValue = "1") Integer pageNo,
                                                @RequestParam(value = "pageSize",required = false,defaultValue = "9") Integer pageSize){
        int totalRecord = taskService.calCountOfTask();
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
