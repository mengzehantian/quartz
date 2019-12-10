package com.example.demo.mybatis.controller;


import com.example.demo.mybatis.entity.User;
import com.example.demo.mybatis.service.UserService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 本地分支dev 第四次修改
 * @author: halo
 * @create: 2019-12-03 15:14
 **/

@Slf4j
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUserList(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "2")int pageSize){
        PageHelper.startPage(pageNo,pageSize);
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public User selectUserById(@PathVariable("id") Long id){
        return userService.selectById(id);
    }

    @GetMapping("/user/del/{id}")
    public String delUser(@PathVariable("id")Long id){
        userService.evictUser(id);
        return "删除成功！";
    }
}
