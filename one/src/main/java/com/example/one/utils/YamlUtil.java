package com.example.one.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiuJiangFeng
 * @ClassName: YamlUtil
 * @Date 2019/2/14 20:23
 */
public class YamlUtil {
    /**
     * 读取yaml配置文件
     * @param yamlName
     * @return
     */
    public static Map<String,String> readYaml(String yamlName) {
        Yaml yaml = new Yaml();
        URL url = Yaml.class.getClassLoader().getResource(yamlName);
        System.out.println(url.getFile());
        Map<String,String> resultMap = new HashMap<String,String>();
        try {
            URI uri = new URI(url.toString());
            FileInputStream fis = new FileInputStream(uri.getPath());
            resultMap = (Map<String, String>) yaml.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;


       /* try {
            Yaml yaml = new Yaml();
            URL url = Test.class.getClassLoader().getResource("Test.yaml");
            if (url != null) {
                //获取test.yaml文件中的配置数据，然后转换为obj，
                Object obj =yaml.load(new FileInputStream(url.getFile()));
                System.out.println(obj);
                //也可以将值转换为Map
                Map map =(Map)yaml.load(new FileInputStream(url.getFile()));
                System.out.println(map);
                //通过map我们取值就可以了.

            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
