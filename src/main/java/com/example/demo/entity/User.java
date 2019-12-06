package com.example.demo.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description: 用户实体（由spring根据ConfigurationProperties自动注入属性值）
 * @author: halo
 * @create: 2019-12-03 09:49
 **/
@Component
@ConfigurationProperties(prefix = "pocket")
public class User {
    private String name;
    private Integer age;
    private String address;
    private String work;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}
