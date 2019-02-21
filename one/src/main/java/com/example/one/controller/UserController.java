package com.example.one.controller;

import com.example.one.model.User;
import com.example.one.service.RedisService;
import com.example.one.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiuJiangFeng
 * @ClassName: UserController
 * @Date 2019/2/15 13:35
 */
@Controller
@RequestMapping(produces="application/json;charset=UTF-8")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private RedisService redisService;

    @RequestMapping("/")
    public String login(String name){

        return "login";
    }

    @RequestMapping("/deploy")
    public String deploy(String name){

        return "deploy";
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(HttpServletRequest request, String login_name, String password){

        User user = userService.selectOneUserByNameAndPsd(login_name,password);
        if(user!=null){
            request.getSession(true).setAttribute("user",user);
            return "SUCCESS";
        }else{
            return "ERROR";
        }
    }



    @RequestMapping(value ="/getListUser",produces="application/json;charset=UTF-8")
    public String getListUser(String name, Model model){

      model.addAttribute("userList", userService.getListUser());
        return "yingpin/userList";
    }

    /**
     * 批量添加页面
     * @param name
     * @param model
     * @return
     */
    @RequestMapping(value ="/addUser",produces="application/json;charset=UTF-8")
    public String addUser(String name, Model model){

        return "yingpin/addUser";
    }
    /**
     * 批量添加
     * @param ListUser
     * @return
     */
   @RequestMapping("/saveUserList")
   @ResponseBody
    public int saveUserList(@RequestBody List<User> ListUser) {
        return userService.saveUserList(ListUser);
    }

    /**
     * 模糊查询1
     * @param flag
     * @param model
     * @return
     */
    @RequestMapping("/selectUserList")
    public String selectUserList(String flag,Model model) {
    model.addAttribute("userList",userService.selectUserList(flag));
        return "yingpin/selectUserList";
    }
    /**
     * 模糊查询2
     * @param flag
     * @param model
     * @return
     */
    @RequestMapping("/selectUserListTwo")
    public String selectUserListTwo(String flag,Model model) {
    model.addAttribute("userList",userService.selectUserListTwo(flag));
        return "yingpin/selectUserList";
    }

    /**
     * 批量更新
     * @param
     * @return
     */
    @RequestMapping("/updateUserHtml")
    public String updateUserHtml() {
        return "yingpin/addUser";
    }

    /**
     * 批量更新
     * @param ListUser
     * @return
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public String updateUser(@RequestBody List<Map<String, Object>> ListUser) {
        return String.valueOf(userService.updateUser(ListUser));
    }

    /**多数据源测试
     *
     * @param username
     * @return
     */
    @RequestMapping("/selectUs")
    @ResponseBody
    public List<User>  selectUs(String username) {
        return userService.selectUs(username);
    }

    /**
     * redis测试
     * @param key
     * @param value
     * @return
     */
    @RequestMapping("/addRedis")
    @ResponseBody
    public Object  addRedis(String key,String value) {
       /* String values="";
        if(redisService.set(key,value)){
         values =    (String) redisService.get(key);
        }
        return values;*/


      /* List<String> list = new ArrayList<>();
       list.add("a");
       list.add("b");
       list.add("c");
        if(redisService.set("list",list)){
            return redisService.get("list");
        }

        return null;*/

      Map<String, Object> map = new HashMap<>();
      map.put("a","秦艳芸");
      map.put("b","江峰");
      map.put("c","秦峰颖");
      map.put("d","宋晓亮");
        if(redisService.set("map",map)){
            return redisService.get("map");
        }
        return null;

    }



}
