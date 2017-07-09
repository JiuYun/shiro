package com.test.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/***
 *
 * Realm 安全数据源
 *
 *
 */
public class MyRealm implements Realm{


    public String getName() {

        return "MyRealm";
    }

    public boolean supports(AuthenticationToken authenticationToken) {

        return authenticationToken instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //得到凭证信息
        String userName = (String) authenticationToken.getPrincipal();
        String password = new String((char[])authenticationToken.getCredentials());

        if(!"zs".equals(userName)){
            throw new UnknownAccountException();
        }

        if(!"123456".equals(password)){
            throw new IncorrectCredentialsException();
        }

        //身份验证成功返回身份信息

        return new SimpleAuthenticationInfo(userName,password,getName());
    }
}
