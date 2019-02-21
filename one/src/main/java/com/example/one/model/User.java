package com.example.one.model;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 * @author LiuJiangFeng
 * @ClassName: User
 * @Date 2019/2/15 13:33
 */
@TableName(value = "tb_user")
public class User {

    private String id;
    private String username;
    private String age;
    private String ctm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCtm() {
        return ctm;
    }

    public void setCtm(String ctm) {
        this.ctm = ctm;
    }
}
