package com.atom.service;

import com.atom.entity.SysPermissions;

/**
 * Created by Administrator on 2017/5/11.
 */
public interface PermissionService {

    public SysPermissions createPermission(SysPermissions sysPermissions);

    public void deleteSysPermission(Long permissionId);


}
