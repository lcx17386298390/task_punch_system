package com.acm.dataservice.mapper;

import com.acm.api.model.sendMsg;

import java.util.List;

public interface sendMsgMapper {
    int deleteByPrimaryKey(String id);

    int insert(sendMsg sendMsg);

    int insertSelective(sendMsg record);

    sendMsg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(sendMsg record);

    int updateByPrimaryKey(sendMsg record);

     List<sendMsg> selectByFromUserAndToUser(String fromuser, String touser);

}