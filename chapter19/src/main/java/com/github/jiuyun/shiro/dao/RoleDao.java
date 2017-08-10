package com.github.jiuyun.shiro.dao;

import com.github.jiuyun.shiro.entity.Role;

import java.util.List;

/**
 * Created by Li Jie on 2017/7/14.
 */
public interface RoleDao {

    public Role createRole(Role role);

    public Role updateRole(Role role);

    public void deleteRole(Long roleId);

    public Role findOne(Long roleId);

    public List<Role> findAll();
}
