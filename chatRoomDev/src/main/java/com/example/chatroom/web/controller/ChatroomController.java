package com.example.chatroom.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.chatroom.model.vo.ResponseJson;
import com.example.chatroom.service.UserInfoService;
import com.example.chatroom.util.Constant;

import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping("/chatroom")
public class ChatroomController {

    @Autowired
    UserInfoService userInfoService;

    /**
     * 描述：登录成功后，调用此接口进行页面跳转
     * @return
     */
//    @RequestMapping(method = RequestMethod.GET)
//    @ResponseBody
    @GetMapping("/chatroom")
    public String toChatroom() {
        return "chatroom";
    }

    /**
     * 描述：登录成功跳转页面后，调用此接口获取用户信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "/chatroom/get_userinfo", method = RequestMethod.POST)
    @ResponseBody
    public ResponseJson getUserInfo(HttpSession session) {
        Object userId = session.getAttribute(Constant.USER_TOKEN);
        return userInfoService.getByUserId((String)userId);
    }
}
