package com.example.chatroom.service.impl;

import com.example.chatroom.dao.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.chatroom.mapper.UserMapper;
import com.example.chatroom.model.po.UserInfo;
import com.example.chatroom.model.vo.ResponseJson;
import com.example.chatroom.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;
    
    @Override
    public ResponseJson getByUserId(String userId) {
        UserInfo userInfo = userInfoDao.getByUserId(userId);
        return new ResponseJson().success()
                .setData("userInfo", userInfo);
    }

}
