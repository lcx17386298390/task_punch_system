package com.acm.dataservice.mapper;

import com.acm.api.model.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface TaskMapper {
    int deleteByPrimaryKey(String id);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    List<Task> queryTaskList(@Param("offset") Integer offset,
                             @Param("pagesize") Integer pageSize);


}