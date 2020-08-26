package com.demo.spring.integration.mapper;

import com.demo.spring.integration.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User getUser(@Param("id") Integer id);
}
