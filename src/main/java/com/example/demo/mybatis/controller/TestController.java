package com.example.demo.mybatis.controller;

import com.example.demo.mybatis.service.SysPermissionService;
import com.example.demo.mybatis.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @description:
 * @author: halo
 * @create: 2019-12-05 17:27
 **/
@Controller
public class TestController {

    @Resource
    private SysPermissionService sysPermissionService;

    @Resource
    private SysUserService sysUserService;

    /**
     * 没有加shiro权限注解
     */
    @RequestMapping("test1")
    public String test1(){
        return "test1";
    }

    /**
     * 添加了shiro权限注解，需要用户有"systemUsetAdd"权限
     */
    @RequestMapping("/test2")
    @RequiresPermissions("systemUserAdd")
    public String test2(){
        return "test2";
    }
}
