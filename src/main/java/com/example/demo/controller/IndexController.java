package com.example.demo.controller;

import com.example.demo.entity.FastjsonTest;
import com.example.demo.mybatis.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @description:
 * @author: halo
 * @create: 2019-12-04 14:48
 **/
@RestController
public class IndexController {

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("index");

        view.addObject("userName","halo");
        return view;
    }

    @GetMapping("/fastjson")
    public FastjsonTest getFastjson(){
        FastjsonTest fastjsonTest = new FastjsonTest();
        fastjsonTest.setId(1);
        fastjsonTest.setString("fastjosn test");
        fastjsonTest.setIgnore("ignore field");
        fastjsonTest.setDate(new Date());

        return fastjsonTest;
    }

    @RequestMapping(value = {"/","index"})
    public String index(Model model){
        SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("userName",sysUser.getUserName());
        return "index";
    }
}
