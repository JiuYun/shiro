package com.test.shiro.parmission;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by Administrator on 2017/7/1 0001.
 */
public class MyRealm extends AuthorizingRealm {


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRole("role1");
        authorizationInfo.addRole("role2");
        authorizationInfo.addObjectPermission(new BitPermission("+user1+10"));
        authorizationInfo.addObjectPermission(new WildcardPermission("user1:*"));

        authorizationInfo.addStringPermission("+user2+10");
        authorizationInfo.addStringPermission("user2:*");

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        if(!"zhang".equals(userName)){
            throw new UnknownAccountException();
        }
        if(!"123".equals(password)){
            throw new IncorrectCredentialsException();
        }

        return new SimpleAuthenticationInfo(userName,password,getName());
    }
}
