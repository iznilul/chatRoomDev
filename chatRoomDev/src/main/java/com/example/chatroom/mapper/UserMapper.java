package com.example.chatroom.mapper;

import com.example.chatroom.model.po.User;
import com.example.chatroom.model.po.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

//    void loadUserInfo();
    @Select("select * from user")
    List<User> getUser();

    @Select("select * from user where userId = #{userId}")
    User getByUserId(String userId);

    @Select("select * from user where userId in(select friendId from friendlist where userId = #{userId})")
    List<User> generateFriendList(String userId);
}
