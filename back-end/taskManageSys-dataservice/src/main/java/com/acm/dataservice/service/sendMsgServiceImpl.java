package com.acm.dataservice.service;
import com.acm.dataservice.mapper.sendMsgMapper;

import com.acm.api.model.sendMsg;
import com.acm.api.service.sendMsgService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
@DubboService(interfaceClass = sendMsgService.class,version = "1.0")
public class sendMsgServiceImpl implements sendMsgService {


    @Resource
   private sendMsgMapper sendMsgMapper;


    @Override
    public int deleteByPrimaryKey(String id) {
        return sendMsgMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(sendMsg record) {
        return sendMsgMapper.insert(record);
    }

    @Override
    public int insertSelective(sendMsg record) {
        return sendMsgMapper.insertSelective(record);
    }

    @Override
    public sendMsg selectByPrimaryKey(String id) {
        return sendMsgMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(sendMsg record) {
        return sendMsgMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(sendMsg record) {
        return sendMsgMapper.updateByPrimaryKey(record);
    }

    @Override
    public int insertMsgBytouser(String fromuser, String touser, String msg) {
        sendMsg sendMsg=new sendMsg();
        sendMsg.setFromuser(fromuser);
        sendMsg.setMsg(msg);
        sendMsg.setTouser(touser);
        return sendMsgMapper.insert(sendMsg);
    }
}
