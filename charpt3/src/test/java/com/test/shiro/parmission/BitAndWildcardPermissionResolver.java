package com.test.shiro.parmission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

/**
 * Created by Administrator on 2017/7/1 0001.
 */
public class BitAndWildcardPermissionResolver implements PermissionResolver {

    //判断输入权限是否以+号开头，从而选择解析模式
    public Permission resolvePermission(String s) {
        if(s.startsWith("+")){
            return new BitPermission(s);
        }
        return new WildcardPermission(s);
    }
}
