package com.example.chatroom.config;

import com.example.chatroom.web.websocket.WebSocketChildChannelHandler;
import com.example.chatroom.web.websocket.WebSocketServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.chatroom.web.websocket")
@ComponentScan("com.example.chatroom.web.controller")
@ComponentScan("com.example.chatroom.config")
@ComponentScan("com.example.chatroom.service")
@ComponentScan("com.example.chatroom.dao")
//netty线程服务器配置
public class WebSocketConfig {
    @Bean(name="bossGroup")
    public EventLoopGroup bossGroup(){
        return new NioEventLoopGroup();
    }
    @Bean(name="workerGroup")
    public EventLoopGroup workerGroup(){
        return new NioEventLoopGroup();
    }
	@Bean(name="serverBootstrap")
    public ServerBootstrap serverBootstrap(){
        return new ServerBootstrap();
    }
    @Bean(name="webSocketServer")
    public WebSocketServer webSocketServer(WebSocketChildChannelHandler webSocketChildChannelHandler){
        WebSocketServer webSocketServer=new WebSocketServer();
        webSocketServer.setPort(3333);
        webSocketServer.setChildChannelHandler(webSocketChildChannelHandler);
        return webSocketServer;
    }
}
