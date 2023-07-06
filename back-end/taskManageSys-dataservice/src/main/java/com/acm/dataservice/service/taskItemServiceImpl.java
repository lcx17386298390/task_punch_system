package com.acm.dataservice.service;

import com.acm.api.model.TaskItem;
import com.acm.api.service.TaskItemService;
import com.acm.dataservice.mapper.TaskItemMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@DubboService(interfaceClass = TaskItemService.class,version = "1.0")
public class taskItemServiceImpl implements TaskItemService {
    @Resource
    private TaskItemMapper taskItemMapper;
    /*@Override
    public int deleteByPrimaryKey(String id) {
        return taskItemMapper.deleteByPrimaryKey(id);
    }*/



    @Override
    public int insert(TaskItem record) {
        return taskItemMapper.insert(record);
    }

    @Override
    public int deleteByIdAndName(String id, String name) {
        return taskItemMapper.deleteByIdAndName(id,name);
    }

    @Override
    public int editTaskItemById(String id, String name, String content, Double judgefinish) {
        return taskItemMapper.editTaskItemById(id, name, content, judgefinish);
    }

    @Override
    public TaskItem viewTaskItemByIdAndName(String id, String name) {
        return taskItemMapper.viewTaskItemByIdAndName(id,name);
    }


    @Override
    public List<TaskItem> viewTaskItemFromStu(Integer offset,
                                              Integer pageSize,String name, String publisher) {
        return taskItemMapper.viewTaskItemFromStu(
                offset,pageSize,name,publisher);
    }

    @Override
    public List<TaskItem> viewTaskItemForCal(String name, String publisher) {
        return taskItemMapper.viewTaskItemForCal(name, publisher);
    }

    @Override
    public Integer calCountOfTaskItem(String name, String publisher) {
        return taskItemMapper.calCountOfTaskItem(name,publisher);
    }

    @Override
    public List<TaskItem> viewAllTaskItemFromStu(Integer offset, Integer pageSize, String publisher) {
        return taskItemMapper.viewAllTaskItemFromStu(offset,pageSize,publisher);
    }

    @Override
    public int calCountOfAllTaskItem(String publisher) {
        return taskItemMapper.calCountOfAllTaskItem(publisher);
    }

    @Override
    public int giveMark(String name, BigDecimal judgefinish, String id) {
        return taskItemMapper.giveMark(name,judgefinish,id);
    }
}
