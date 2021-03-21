package com.example.chatroom.model.po;

import java.io.Serializable;
import java.util.List;

public class UserInfo {
    private String userId;
    private String username;
    private String password;
    private String avatarUrl;
    private List<User> friendList;
    private List<Group> groupList;
//    private List<UserInfo> friendList;
//    private List<GroupInfo> groupList;
    
    public UserInfo() {
        super();
    }
    
    public UserInfo(String userId, String username, String password, String avatarUrl) {
        super();
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

    public List<User> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<User> friendList) {
        this.friendList = friendList;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }


}
