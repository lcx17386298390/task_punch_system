package com.acm.dataservice.service;
import com.acm.dataservice.mapper.sendMsgMapper;

import com.acm.api.model.sendMsg;
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
    public int insert(sendMsg sendMsg) {
        return sendMsgMapper.insert(sendMsg);
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
    public List<sendMsg> selectByFromUserAndToUser(String fromuser, String touser) {
        return sendMsgMapper.selectByFromUserAndToUser(fromuser,touser);
    }

}
