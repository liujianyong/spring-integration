package com.demo.spring.integration;

import com.demo.spring.integration.config.AppConfig;
import com.demo.spring.integration.mapper.UserMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        try {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
            UserMapper userMapper = context.getBean(UserMapper.class);
            System.out.println(userMapper.getUser(1));
            System.out.println(userMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
