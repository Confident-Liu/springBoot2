package com.example.one.dao;

import com.example.one.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuJiangFeng
 * @ClassName: UserDao
 * @Date 2019/2/15 13:40
 */
@Repository
public class UserDao {

   @Resource
   private JdbcTemplate jdbcTemplate;

   public List<User> getListUser(String sql, List<String> list){

     List<User>  list1 = jdbcTemplate.query(sql,list.toArray(),new BeanPropertyRowMapper<>(User.class));
       return list1;
   }




}
