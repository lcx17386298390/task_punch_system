package com.acm.dataservice.mapper;

import com.acm.api.model.TaskItem;

public interface TaskItemMapper {
    int deleteByPrimaryKey(String id);

    int insert(TaskItem record);

    int insertSelective(TaskItem record);

    TaskItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TaskItem record);

    int updateByPrimaryKey(TaskItem record);

    int deleteByIdAndName(String id,String name);

    int editTaskItemById(String id, String name, String content, Double judgefinish);

    TaskItem viewTaskItemByIdAndName(String id,String name);
}