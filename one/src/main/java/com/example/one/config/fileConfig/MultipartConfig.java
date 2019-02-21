package com.example.one.config.fileConfig;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * 文件上传配置
 */
@Configuration
public class MultipartConfig {
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("50MB");//设置上传最大
        factory.setMaxRequestSize("100MB");//设置总上传数据大小
//        factory.setLocation(Constant.LOCATION);//设置上传目录路径
        return factory.createMultipartConfig();
    }
}
