package com.acm.api.service;

import com.acm.api.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> queryTaskList(Integer pageNo,
                             Integer pageSize);

    int insert(String title,String id,String content);

    int deleteByPrimaryKey(String id);

    int updateByPrimaryKey(Task record);

    int calCountOfTask();

    int editAdminTaskItemTitleVal(String id, String title);
}
