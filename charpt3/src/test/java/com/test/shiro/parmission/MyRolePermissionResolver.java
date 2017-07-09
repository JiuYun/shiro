package com.test.shiro.parmission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Administrator on 2017/7/1 0001.
 */
public class MyRolePermissionResolver implements RolePermissionResolver {



    public Collection<Permission> resolvePermissionsInRole(String roleStr) {
        if("role1".equals(roleStr)){
            return Arrays.asList((Permission)new WildcardPermission("menu:*"));
        }
        return null;
    }



}
