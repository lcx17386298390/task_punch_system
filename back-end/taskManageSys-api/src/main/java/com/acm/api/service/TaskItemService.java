package com.acm.api.service;

import com.acm.api.model.TaskItem;

public interface TaskItemService {
    //int deleteByPrimaryKey(String id);

    int insert(TaskItem record);

    int deleteByIdAndName(String id,String name);

    int editTaskItemById(String id,String name,String content,Double judgefinish);

    TaskItem viewTaskItemByIdAndName(String id,String name);

    TaskItem viewTaskItemByName(String name);
}
