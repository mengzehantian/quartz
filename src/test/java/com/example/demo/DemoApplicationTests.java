package com.example.demo;

import com.example.demo.mybatis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class DemoApplicationTests {

    @Resource
    UserService userService;

    @Test
    public void test1(){
        userService.selectById(new Long(4));
    }

}
