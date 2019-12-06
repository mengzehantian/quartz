package com.example.demo.mybatis.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: user登录controller
 * @author: halo
 * @create: 2019-12-06 09:10
 **/
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        //如果已经认证通过，直接跳转到首页
        if(SecurityUtils.getSubject().isAuthenticated()){
            return "redirect:/index";
        }
        return "login";
    }
    
    /** 
    * @Description: post表单提交，dengl
    * @Param:  String userName, String password, Model model
    * @return:  Object object
    * @Author: halo
    * @Date: 2019/12/6 
    */ 
    @PostMapping("/login")
    public Object login(String userName, String password, Model model){
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
        try{
            //shiro帮我们匹配密码什么的，我们只需要把东西传递给它，它会根据我们在userRealm里认证方法设置的来验证
            user.login(token);
            return "redirect:/index";
        }catch (UnknownAccountException e){
            model.addAttribute("message","账号不存在！");
        }catch (DisabledAccountException e){
            model.addAttribute("message","账号未启用！");
        }catch (IncorrectCredentialsException e){
            model.addAttribute("message","密码错误！");
        }catch (Throwable e){
            model.addAttribute("message","未知错误！");
        }
        return "login";
    }

    /**
     * 退出
     */
    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "login";
    }
}
