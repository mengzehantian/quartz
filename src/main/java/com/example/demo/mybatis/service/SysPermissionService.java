package com.example.demo.mybatis.service;

import com.example.demo.mybatis.dao.SysPermissionMapper;
import com.example.demo.mybatis.dao.SysRolePermissionMapper;
import com.example.demo.mybatis.dao.SysUserRoleMapper;
import com.example.demo.mybatis.entity.SysPermission;
import com.example.demo.mybatis.entity.SysRolePermission;
import com.example.demo.mybatis.entity.SysUserRole;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: halo
 * @create: 2019-12-05 16:04
 **/

@Service
public class SysPermissionService {

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;

    /**
     * 根据用户id查询权限字符串(给shiro提供授权数据信息)
     * @param userId
     * @return
     */
    public List<String> selectPermissionByUserId(long userId){

        List<String> permissionList = new ArrayList<>();
        try{
            Example example = new Example(SysUserRole.class);

            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("userId",userId);
            //存放查询到的权限信息
            List<SysPermission> sysPermissionList = new ArrayList<>();

//          根据用户id 查询用户和角色关系
            List<SysUserRole> sysUserRoleList = sysUserRoleMapper.selectByExample(example);
            if(!sysUserRoleList.isEmpty()){//根据角色id 查询角色与权限关系
                for(SysUserRole sysUserRole : sysUserRoleList){
                    Example example1 = new Example(SysUserRole.class);

                    Example.Criteria criteria1 = example1.createCriteria();
                    criteria1.andEqualTo("roleId",sysUserRole.getRoleId());
                    List<SysRolePermission> sysRolePermissionList = sysRolePermissionMapper.selectByExample(example1);
                    if(!sysRolePermissionList.isEmpty()){//根据权限id 查询权限信息
                        for(SysRolePermission sysRolePermission : sysRolePermissionList){
                            SysPermission sysPermission = sysPermissionMapper.selectByPrimaryKey(sysRolePermission.getPermissionId());
                            sysPermissionList.add(sysPermission);
                        }
                    }
                }
            }
            if(!sysPermissionList.isEmpty()){
                for(SysPermission sysPermission:sysPermissionList){
                    permissionList.add(sysPermission.getPermission());
                }
            }
        }catch (Exception e){
            throw e;
        }
        return permissionList;
    }

}
