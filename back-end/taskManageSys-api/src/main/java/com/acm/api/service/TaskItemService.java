package com.acm.api.service;

//import com.acm.api.model.TaskItem;

import com.acm.api.model.TaskItem;

import java.math.BigDecimal;
import java.util.List;

public interface TaskItemService {
    //int deleteByPrimaryKey(String id);

    int insert(TaskItem record);

    int deleteByIdAndName(String id,String name);

    int editTaskItemById(String id,String name,String content,BigDecimal judgefinish,String title);

    TaskItem viewTaskItemByIdAndName(String id,String name);


    List<TaskItem> viewTaskItemFromStu(Integer offset,
                                       Integer pageSize,String name,String publisher);

    List<TaskItem> viewTaskItemForCal(String name,String publisher);

    Integer calCountOfTaskItem(String name,String publisher);

    List<TaskItem> viewAllTaskItemFromStu(Integer offset, Integer pageSize, String publisher);

    int calCountOfAllTaskItem(String publisher);

    int giveMark(String name, BigDecimal judgefinish, String id);

    List<TaskItem> viewAdminTaskItem(String publisher, Integer offset, Integer pageSize);

    int calAdminTaskItem(String publisher);

    int editAdminTaskItemTitleVal(String name, String id, String publisher,String title);
}
