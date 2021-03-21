package com.example.chatroom.mapper;


import com.example.chatroom.model.po.Group;
import com.example.chatroom.model.po.User;
import com.example.chatroom.model.po.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Mapper
public interface GroupMapper {

//    void loadGroupInfo();

    @Select("select * from user")
    List<User> getUserInfo();

    @Select("select * from groupinfo where groupId = #{groupId}")
    Group getByGroupId(String groupId);
}
