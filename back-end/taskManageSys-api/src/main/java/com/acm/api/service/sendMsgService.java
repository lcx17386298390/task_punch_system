package com.acm.api.service;

import com.acm.api.model.sendMsg;


public interface sendMsgService {

    int deleteByPrimaryKey(String id);

    int insert(sendMsg record);

    int insertSelective(sendMsg record);

    sendMsg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(sendMsg record);

    int updateByPrimaryKey(sendMsg record);

    int insertMsgBytouser(String fromuser,String touser,String msg);

}
