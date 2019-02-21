package com.example.one.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.one.model.User;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Resource
public interface UserDaoMapper extends BaseMapper<User> {

    public int saveUserList(@Param("LogBookList")List<User> ListUser);

    public List<User> selectUserList(@Param("flag")String flag);

    public List<User> selectUserListTwo(String flag);

    int updateUser( @Param("listMap")List<Map<String, Object>> listMap);

    public List<User> selectUs (String username);

    public User selectOneUserByNameAndPsd(String username,String age);

}
