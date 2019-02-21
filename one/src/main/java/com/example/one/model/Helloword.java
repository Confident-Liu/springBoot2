package com.example.one.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author LiuJiangFeng
 * @ClassName: Helloword
 * @Date 2019/2/14 13:12
 */
@Component
public class Helloword {

  @Value("${spring.application.name}")
  private String name;
  @Value("${spring.profiles.active}")
  private String active;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
