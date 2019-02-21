package com.example.one.controller;

import com.example.one.model.Helloword;
import com.example.one.utils.YamlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author LiuJiangFeng
 * @ClassName: HelloWordController
 * @Date 2019/2/13 12:44
 */
@Controller
@RequestMapping("/HelloWordController")
public class HelloWordController {

    @Autowired
    private Helloword helloword;

    private Map<String,String> configMap =  YamlUtil.readYaml("config.yml");

    @RequestMapping("/helloWord/{id}")
    @ResponseBody
    public String helloWord( @PathVariable("id") String id){

        return id;
    }

    @RequestMapping(value = "/path",method = RequestMethod.GET)
    @ResponseBody
    public String path(String name){

        return name;
    }

    @RequestMapping(value = "/pathTestOne",method = RequestMethod.GET)
    @ResponseBody
    public String pathTestOne(String name){

        return "pathTestOne";
    }

    /**
     * 登陆
     * @param name
     * @return
     */
    @RequestMapping(value = "/pathTestLogin",method = RequestMethod.GET)
    @ResponseBody
    public String pathTestLogin(String name){

        return "loginto";
    }

    @RequestMapping(value = "/getApplicationList",method = RequestMethod.GET)
    @ResponseBody
    public String getApplicationList(String name){
        return helloword.getName()+":"+helloword.getActive()+":"+configMap.get("photoUrl");
    }

}
