package com.example.demo.mybatis.dao;

import com.example.demo.mybatis.base.BaseMapper;
import com.example.demo.mybatis.entity.User;

import java.util.List;

public interface UserDao extends BaseMapper<User> {
    List<User> getUsers();
}
