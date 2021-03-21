package com.example.chatroom.dao;

import com.example.chatroom.mapper.GroupMapper;
import com.example.chatroom.mapper.UserMapper;
import com.example.chatroom.model.po.Group;
import com.example.chatroom.model.po.GroupInfo;
import com.example.chatroom.model.po.User;
import com.example.chatroom.model.po.UserInfo;
import com.example.chatroom.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Repository
public class UserInfoDao {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GroupMapper groupMapper;

    public void loadUserInfo() {
        Group group=groupMapper.getByGroupId("01");

        List<Group> groupList = new ArrayList<Group>();
        groupList.add(group);
        List<User> users=userMapper.getUser();
        // 设置用户好友列表
        int len=users.size();
        for(int i=0;i<len;i++){
            User user=users.get(i);
            UserInfo userInfo = new UserInfo(user.getUserId(), user.getUsername(), user.getPassword(), user.getAvatarUrl());
            userInfo.setFriendList(userMapper.generateFriendList(userInfo.getUserId()));
            userInfo.setGroupList(groupList);
            Constant.userInfoMap.put(userInfo.getUsername(), userInfo);
        }
    }

    public UserInfo getByUsername(String username) {
        return Constant.userInfoMap.get(username);
    }

    public UserInfo getByUserId(String userId) {
        UserInfo result = null;
        Iterator<Map.Entry<String, UserInfo>> iterator = Constant.userInfoMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, UserInfo> entry = iterator.next();
            if (entry.getValue().getUserId().equals(userId)) {
                result = entry.getValue();
                break;
            }
        }
        return result;
    }

//    private List<UserInfo> generateFriendList(String userId) {
//        UserInfo userInfo = new UserInfo("001", "Member001", "001", "img/avatar/Member001.jpg");
//        UserInfo userInfo2 = new UserInfo("002", "Member002", "002", "img/avatar/Member002.jpg");
//        UserInfo userInfo3 = new UserInfo("003", "Member003", "003", "img/avatar/Member003.jpg");
//        UserInfo userInfo4 = new UserInfo("004", "Member004", "004", "img/avatar/Member004.jpg");
//        UserInfo userInfo5 = new UserInfo("005", "Member005", "005", "img/avatar/Member005.jpg");
//        UserInfo userInfo6 = new UserInfo("006", "Member006", "006", "img/avatar/Member006.jpg");
//        UserInfo userInfo7 = new UserInfo("007", "Member007", "007", "img/avatar/Member007.jpg");
//        UserInfo userInfo8 = new UserInfo("008", "Member008", "008", "img/avatar/Member008.jpg");
//        UserInfo userInfo9 = new UserInfo("009", "Member009", "009", "img/avatar/Member009.jpg");
//        List<UserInfo> friendList = new ArrayList<UserInfo>();
//        friendList.add(userInfo);
//        friendList.add(userInfo2);
//        friendList.add(userInfo3);
//        friendList.add(userInfo4);
//        friendList.add(userInfo5);
//        friendList.add(userInfo6);
//        friendList.add(userInfo7);
//        friendList.add(userInfo8);
//        friendList.add(userInfo9);
//        Iterator<UserInfo> iterator = friendList.iterator();
//        while(iterator.hasNext()) {
//            UserInfo entry = iterator.next();
//            if (userId.equals(entry.getUserId())) {
//                iterator.remove();
//            }
//        }
//        return friendList;
//    }


}
