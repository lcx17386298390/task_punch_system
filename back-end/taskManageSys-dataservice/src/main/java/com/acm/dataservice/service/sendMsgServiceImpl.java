package com.acm.dataservice.service;
import com.acm.dataservice.mapper.sendMsgMapper;

import com.acm.api.model.SendMsg;
import com.acm.api.service.sendMsgService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.List;

@DubboService(interfaceClass = sendMsgService.class,version = "1.0")
public class sendMsgServiceImpl implements sendMsgService {


    @Resource
   private sendMsgMapper sendMsgMapper;


    @Override
    public int deleteByPrimaryKey(String id) {
        return sendMsgMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SendMsg sendMsg) {
        return sendMsgMapper.insert(sendMsg);
    }

    @Override
    public int insertSelective(SendMsg record) {
        return sendMsgMapper.insertSelective(record);
    }

    @Override
    public SendMsg selectByPrimaryKey(String id) {
        return sendMsgMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SendMsg record) {
        return sendMsgMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SendMsg record) {
        return sendMsgMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SendMsg> selectByFromUserAndToUser(String fromuser, String touser) {
        return  sendMsgMapper.selectByFromUserAndToUser(fromuser,touser);
    }

}
