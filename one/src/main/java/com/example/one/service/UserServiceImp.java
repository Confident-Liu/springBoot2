package com.example.one.service;

import com.baomidou.mybatisplus.annotations.DataSource;
import com.example.one.dao.UserDao;
import com.example.one.dao.UserDaoMapper;
import com.example.one.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author LiuJiangFeng
 * @ClassName: UserServiceImp
 * @Date 2019/2/15 13:38
 */
@Service
@Transactional
public class UserServiceImp implements UserService {

    @Resource
    private UserDao userDao;
    @Resource
    private UserDaoMapper userDaoMapper;
    @Resource
    @Qualifier("Oracle2JdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public List<User> getListUser(){
     String sql = "select * from tb_user";
      List<String> list = new ArrayList<String>();
        return userDao.getListUser(sql,list);
    }

    @Override
    public int saveUserList(List<User> ListUser) {
        return userDaoMapper.saveUserList(ListUser);
    }

    @Override
    public List<User> selectUserList(String flag) {
        return userDaoMapper.selectUserList(flag);
    }

    @Override
    public List<User> selectUserListTwo(String flag) {
        return userDaoMapper.selectUserListTwo(flag);
    }

    @Override
    public int updateUser(List<Map<String, Object>> listMap) {
        return userDaoMapper.updateUser(listMap);
    }

    @Override
    public List<User> selectUs(String name) {
        String sql="select * from  tb_user t where t.age=?";
        List<String> list=new ArrayList<>();
        list.add(name);
        return jdbcTemplate.query(sql,list.toArray(),new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User selectOneUserByNameAndPsd(String name, String age) {
        return userDaoMapper.selectOneUserByNameAndPsd(name,age);
    }
}
