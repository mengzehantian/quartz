package com.example.demo.mybatis.service;

import com.example.demo.mybatis.dao.UserDao;
import com.example.demo.mybatis.dao.UserMapper;
import com.example.demo.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.swing.text.StyledEditorKit;
import java.util.List;

/**
 * @description:
 * @author: halo
 * @create: 2019-12-03 15:11
 **/
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired(required = false)
    private UserDao userDao;

    public List<User> getUsers(){
        List<User> users = userMapper.getUsers();
        return users;
    }

    @Cacheable(cacheNames = "users",key="#id")
    public User selectById(Long id){
//        Boolean b = userDao.existsWithPrimaryKey(id);
//        System.out.println(b);
//        User user = new User();
//        user.setUserAge(18);
//        List<User> users =userDao.select(user);
//
//        if(!users.isEmpty()){
//            for(User user1:users){
//                System.out.println(user1);
//            }
//        }
//        List<User> users1 = userDao.select(user);
//        if(!users1.isEmpty()){
//            for(User user1:users1){
//                System.out.println(user1);
//            }
//        }
//        Example example = new Example(User.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andBetween("userAge",18,20);
//        criteria.andLike("userName","%孙%");
//
//        Example.Criteria criteria1 = example.createCriteria();
//        criteria1.orEqualTo("userName","鲁班七号");
//        example.or(criteria1);

//        Example.Criteria criteria2 = example.createCriteria();
//        criteria2.andLike("userName","%成%");
//        example.or(criteria2);
//
//        example.setOrderByClause("user_age desc, user_id asc");
//        List<User> users1 = userDao.selectByExample(example);
//        if(!users1.isEmpty()){
//            for(User user1:users1){
//                System.out.println(user1);
//            }
//        }
//        Example example1 = new Example(User.class);
//
//        Example.Criteria criteria3 = example1.createCriteria();
//        criteria3.andLike("userName","成吉思汗");
//        criteria3.orLessThan("userAge","10");
//
//        int i = userDao.deleteByExample(example1);
//        System.out.println("i的值是："+i);

        System.out.println("没有缓存，开始查询数据可。。。");
        return userDao.selectByPrimaryKey(id);
    }

    @CacheEvict(value="users",key = "#id")
    public void evictUser(Long id){
        System.out.println("evict user:"+id);
    }
}
