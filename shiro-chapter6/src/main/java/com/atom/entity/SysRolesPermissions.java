package com.atom.entity;

/**
 * Created by Administrator on 2017/5/11.
 */
public class SysRolesPermissions {

    private Long roleId;
    private Long permissionId;


    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
