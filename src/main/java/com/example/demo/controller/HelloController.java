package com.example.demo.controller;

import com.example.demo.entity.RandomData;
import com.example.demo.entity.TestEntity;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: halo
 * @create: 2019-12-02 17:29
 **/
@RestController
public class HelloController {

    @Value("${pocket.name}")
    private String name;

    @Value("${pocket.age}")
    private Integer age;

    @Value("${pocket.address}")
    private String address;

    @Autowired
    private User user;

    @Autowired
    private RandomData randomData;

    @Autowired
    private TestEntity testEntity;

    @GetMapping("/hello")
    public String hello(){
        return "hello Spring Boot";
    }

    @GetMapping("/user")
    public String user(){
        return "名字是"+user.getName()+"，年纪是"+user.getAge()+"，地址是"+user.getAddress();
    }
    @GetMapping("/random")
    public RandomData randomData(){
        return randomData;
    }

    @GetMapping("/test")
    public TestEntity getTestEntity(){
        return testEntity;
    }
}
