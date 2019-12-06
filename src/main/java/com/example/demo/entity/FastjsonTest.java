package com.example.demo.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @description:
 * @author: halo
 * @create: 2019-12-04 16:48
 **/

public class FastjsonTest {
    private Integer id;
    private String string;

    /**
     * 格式化日期
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    /**
     * 装换为json是不包括改属性
     */
    @JSONField(serialize = false)
    private String ignore;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIgnore() {
        return ignore;
    }

    public void setIgnore(String ignore) {
        this.ignore = ignore;
    }
}
