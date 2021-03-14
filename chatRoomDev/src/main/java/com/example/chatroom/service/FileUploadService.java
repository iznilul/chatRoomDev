package com.example.chatroom.service;

import org.springframework.web.multipart.MultipartFile;
import com.example.chatroom.model.vo.ResponseJson;

import javax.servlet.http.HttpServletRequest;

public interface FileUploadService {

    ResponseJson upload(MultipartFile file, HttpServletRequest request);
}
