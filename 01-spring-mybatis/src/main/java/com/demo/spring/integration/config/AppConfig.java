package com.demo.spring.integration.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.demo.spring.integration.mapper.UserMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        return factoryBean.getObject();
    }

    @Bean
    public DataSource dataSource() throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test?useSSL=false&serverTimezone=Hongkong&characterEncoding=UTF-8&autoReconnect=true");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    public MapperFactoryBean getMapperFactoryBean() throws Exception {
        MapperFactoryBean mapperFactoryBean = new MapperFactoryBean();
        mapperFactoryBean.setMapperInterface(UserMapper.class);
        mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory());
        return mapperFactoryBean;
    }

}
