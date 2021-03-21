package com.example.chatroom.model.po;

import java.io.Serializable;

public class User {
    private String userId;
    private String username;
    private String password;
    private String avatarUrl;

    public User(String userId, String username, String password, String avatarUrl) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.avatarUrl = avatarUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
