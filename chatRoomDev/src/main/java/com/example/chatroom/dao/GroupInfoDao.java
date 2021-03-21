package com.example.chatroom.dao;


import com.example.chatroom.mapper.GroupMapper;
import com.example.chatroom.model.po.Group;
import com.example.chatroom.model.po.GroupInfo;
import com.example.chatroom.model.po.User;
import com.example.chatroom.model.po.UserInfo;
import com.example.chatroom.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GroupInfoDao {
    @Autowired
    private GroupMapper groupMapper;

    public void loadGroupInfo() {
        List<User> members = groupMapper.getUserInfo();
        Group group=groupMapper.getByGroupId("01");
        GroupInfo groupInfo = new GroupInfo(group.getGroupId(), group.getGroupName(), group.getGroupAvatarUrl(), members);
        Constant.groupInfoMap.put(groupInfo.getGroupId(), groupInfo);
    }

    public GroupInfo getByGroupId(String groupId) {
        return Constant.groupInfoMap.get(groupId);
    }

}
