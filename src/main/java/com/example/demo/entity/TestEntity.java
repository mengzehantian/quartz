package com.example.demo.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @description: 测试自定义配置文件
 * @author: halo
 * @create: 2019-12-03 10:42
 **/
@ConfigurationProperties("test")
@Component
@PropertySource("classpath:test.properties")
public class TestEntity {
    private String name;
    private Integer num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
