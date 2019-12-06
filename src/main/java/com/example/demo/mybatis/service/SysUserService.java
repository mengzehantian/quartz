package com.example.demo.mybatis.service;

import com.example.demo.mybatis.dao.SysUserMapper;
import com.example.demo.mybatis.entity.SysUser;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @description:
 * @author: halo
 * @create: 2019-12-05 16:15
 **/
@Service
public class SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    /**
    * @Description: 根据用户名查询用户信息(给shiro提供登录认证信息)
    * @Param:
    * @return:
    * @Author: halo
    * @Date: 2019/12/5
    */
    public SysUser findByUserName(String userName){
        try{
            Example example = new Example(SysUser.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("userName",userName);
            return sysUserMapper.selectOneByExample(example);
        }catch (Exception e){
            throw e;
        }
    }
}
