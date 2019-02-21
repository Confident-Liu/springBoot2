package com.example.one.service;

import com.example.one.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserService {
    public List<User> getListUser();

    /**
     * 批量插入
     * @param ListUser
     * @return
     */
    public int saveUserList(List<User> ListUser);

    /**
     * 模糊查询1
     * @param flag
     * @return
     */
    public List<User> selectUserList(String flag); /**
     * 模糊查询2
     * @param flag
     * @return
     */
    public List<User> selectUserListTwo(String flag);

    /**
     * 批量修改
     * @param listMap
     * @return
     */
    int updateUser( @Param("listMap")List<Map<String, Object>> listMap);

    /**
     * 多数据源测试
     * @param name
     * @return
     */
    List<User> selectUs(String  name);

    /**
     * 登陆查询
     * @param name
     * @param age
     * @return
     */
    User selectOneUserByNameAndPsd(String  name,String age);
}
