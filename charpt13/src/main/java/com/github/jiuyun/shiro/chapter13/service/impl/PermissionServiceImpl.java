package com.github.jiuyun.shiro.chapter13.service.impl;


import com.github.jiuyun.shiro.chapter13.dao.PermissionDao;
import com.github.jiuyun.shiro.chapter13.entity.Permission;
import com.github.jiuyun.shiro.chapter13.service.PermissionService;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public class PermissionServiceImpl implements PermissionService {

    private PermissionDao permissionDao;

    public void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    public Permission createPermission(Permission permission) {
        return permissionDao.createPermission(permission);
    }

    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }
}
