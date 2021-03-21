package com.example.chatroom.model.po;

import java.io.Serializable;
import java.util.List;

public class GroupInfo {

    private String groupId;
    private String groupName;
    private String groupAvatarUrl;
    private List<User> members;
    
    public GroupInfo(String groupId, String groupName, String groupAvatarUrl, List<User> members) {
        super();
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupAvatarUrl = groupAvatarUrl;
        this.members = members;
    }

    public String getGroupId() {
        return groupId;
    }
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    public List<User> getMembers() {
        return members;
    }
    public void setMembers(List<User> members) {
        this.members = members;
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
