	package com.example.chatroom.model.po;

import lombok.Data;

import java.io.Serializable;

    /**
     * 会话消息实体
     */
    @Data
    public class Message implements Serializable {

        /**
         * 消息推送者
         */
//        private User from;\
        private String fromUserId;

        /**
         * 消息内容
         */
        private String message;

        /**
         * 消息接收者：
         *      如果是私有（向指定窗口推送），to即为接受者User对象
         *      如果是公共消息（群组聊天），to设为null
         */
//        private User to;
        private String toUserId;

        /**
         * 创建时间
         */
        private String time;

        public void setMessage(String message) {
            this.message = message == null ? "" : message.replaceAll("\r\n|\r|\n", "");
        }
    }
