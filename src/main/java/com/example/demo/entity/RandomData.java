package com.example.demo.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description: 随机生成数据entity
 * @author: halo
 * @create: 2019-12-03 10:06
 **/
@Component
@ConfigurationProperties(prefix = "ttest")
public class RandomData {
    private Integer randomInt;
    private Integer randomIntMax;
    private Integer randomIntMiddle;
    private Long randomLong;
    private String randomValue;
    private String randomUuid;

    public Integer getRandomInt() {
        return randomInt;
    }

    public void setRandomInt(Integer randomInt) {
        this.randomInt = randomInt;
    }

    public Integer getRandomIntMax() {
        return randomIntMax;
    }

    public void setRandomIntMax(Integer randomIntMax) {
        this.randomIntMax = randomIntMax;
    }

    public Integer getRandomIntMiddle() {
        return randomIntMiddle;
    }

    public void setRandomIntMiddle(Integer randomIntMiddle) {
        this.randomIntMiddle = randomIntMiddle;
    }

    public Long getRandomLong() {
        return randomLong;
    }

    public void setRandomLong(Long randomLong) {
        this.randomLong = randomLong;
    }

    public String getRandomValue() {
        return randomValue;
    }

    public void setRandomValue(String randomValue) {
        this.randomValue = randomValue;
    }

    public String getRandomUuid() {
        return randomUuid;
    }

    public void setRandomUuid(String randomUuid) {
        this.randomUuid = randomUuid;
    }
}
