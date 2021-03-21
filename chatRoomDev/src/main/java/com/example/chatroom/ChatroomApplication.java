package com.example.chatroom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource({"classpath:spring\\ApplicationContext-mvc.xml","classpath:spring\\ApplicationContext-main.xml","classpath:spring\\ApplicationContext-netty.xml"})
@MapperScan("com.example.chatroom.dao")
public class ChatroomApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatroomApplication.class, args);
    }

}
