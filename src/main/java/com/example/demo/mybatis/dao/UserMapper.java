package com.example.demo.mybatis.dao;

import com.example.demo.mybatis.entity.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);
    List<User> getUsers();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}