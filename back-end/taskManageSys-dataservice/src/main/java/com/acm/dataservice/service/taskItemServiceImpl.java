package com.acm.dataservice.service;

import com.acm.api.model.TaskItem;
import com.acm.api.service.TaskItemService;
import com.acm.dataservice.mapper.TaskItemMapper;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
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
    public List<TaskItem> viewTaskItemFromStu(String name, String publisher) {
        return taskItemMapper.viewTaskItemFromStu(name,publisher);
    }


}
