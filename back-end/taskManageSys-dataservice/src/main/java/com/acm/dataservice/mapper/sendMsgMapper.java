package com.acm.dataservice.mapper;

import com.acm.api.model.sendMsg;

public interface sendMsgMapper {
    int deleteByPrimaryKey(String id);

    int insert(sendMsg record);

    int insertSelective(sendMsg record);

    sendMsg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(sendMsg record);

    int updateByPrimaryKey(sendMsg record);

    int insertMsgBytouser(sendMsg sendMsg);

}