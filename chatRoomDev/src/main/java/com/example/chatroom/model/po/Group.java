package com.example.chatroom.model.po;

import java.io.Serializable;

public class Group {
    private String groupId;
    private String groupName;
    private String groupAvatarUrl;

    public Group(String groupId, String groupName, String groupAvatarUrl) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupAvatarUrl = groupAvatarUrl;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupAvatarUrl() {
        return groupAvatarUrl;
    }

    public void setGroupAvatarUrl(String groupAvatarUrl) {
        this.groupAvatarUrl = groupAvatarUrl;
    }
}
