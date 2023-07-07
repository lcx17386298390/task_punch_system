package com.acm.dataservice.mapper;

import com.acm.api.model.TaskItem;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface TaskItemMapper {
    int deleteByPrimaryKey(String id);

    int insert(TaskItem record);

    int insertSelective(TaskItem record);

    TaskItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TaskItem record);

    int updateByPrimaryKey(TaskItem record);

    int deleteByIdAndName(String id,String name);

    int editTaskItemById(String id, String name, String content, BigDecimal judgefinish,String title);

    TaskItem viewTaskItemByIdAndName(String id,String name);

    List<TaskItem> viewTaskItemFromStu(@Param("offset") Integer offset,
                                       @Param("pagesize") Integer pageSize,String name,String publisher);

    List<TaskItem> viewTaskItemForCal(String name,String publisher);

    Integer calCountOfTaskItem(String name, String publisher);

    List<TaskItem> viewAllTaskItemFromStu(Integer offset, Integer pageSize, String publisher);

    int calCountOfAllTaskItem(String publisher);

    int giveMark(String name, BigDecimal judgefinish, String id);
}