package com.example.chatroom.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.chatroom.model.vo.ResponseJson;
import com.example.chatroom.service.SecurityService;

import javax.servlet.http.HttpSession;

@Controller
public class SecurityController {

    @Autowired
    SecurityService securityService;

//    @RequestMapping(value = {"login", "/"}, method = RequestMethod.GET)
//    @ResponseBody
    @GetMapping("/")
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseJson login(HttpSession session,
                              @RequestParam String username,
                              @RequestParam String password) {
        return securityService.login(username, password, session);
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    @ResponseBody
    public ResponseJson logout(HttpSession session) {
        return securityService.logout(session);
    }
}
