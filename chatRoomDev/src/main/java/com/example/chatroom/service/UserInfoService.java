package com.example.chatroom.service;

import com.example.chatroom.model.vo.ResponseJson;

public interface UserInfoService {

    ResponseJson getByUserId(String userId);
}
