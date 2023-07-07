package com.acm.api.service;

import com.acm.api.model.SendMsg;

import java.util.List;


public interface sendMsgService {

    int deleteByPrimaryKey(String id);

    int insert(SendMsg sendMsg);

    int insertSelective(SendMsg record);

    SendMsg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SendMsg record);

    int updateByPrimaryKey(SendMsg record);

    List<SendMsg> selectByFromUserAndToUser(String fromuser, String touser);

}
