package com.acm.dataservice.service;

import com.acm.api.model.Task;
import com.acm.api.service.TaskService;
import com.acm.dataservice.mapper.TaskMapper;
import org.apache.dubbo.config.annotation.DubboService;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@DubboService(interfaceClass = TaskService.class,version = "1.0")
public class taskServiceImpl implements TaskService {

    @Resource
    private TaskMapper taskMapper;


    @Override
    public List<Task> queryTaskList(Integer offset, Integer pageSize) {
        return taskMapper.queryTaskList(offset, pageSize);
    }

    @Override
    public int insert(String title, String id, String content) {
        Task task = new Task();
        task.setId(id);
        task.setTitle(title);
        task.setContent(content);
        return taskMapper.insert(task);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return taskMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Task record) {
        return taskMapper.updateByPrimaryKey(record);
    }

    @Override
    public int calCountOfTask() {
        return taskMapper.calCountOfTask();
    }
}
