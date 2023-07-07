package com.acm.dataservice.mapper;

import com.acm.api.model.SendMsg;

import java.util.List;

public interface sendMsgMapper {
    int deleteByPrimaryKey(String id);

    int insert(SendMsg record);

    int insertSelective(SendMsg record);

    SendMsg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SendMsg record);

    int updateByPrimaryKey(SendMsg record);

    int insertMsgBytouser(SendMsg sendMsg);
    List<SendMsg> selectByFromUserAndToUser(String fromuser, String touser);

}