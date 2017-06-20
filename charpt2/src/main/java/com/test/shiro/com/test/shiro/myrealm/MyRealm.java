package com.test.shiro.com.test.shiro.myrealm;


import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

public class MyRealm implements Realm{


    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();      //得到用户名
        String password = new String((char[]) authenticationToken.getCredentials());    //得到密码

        if(!"zhang".equals(userName)){
            throw new UnknownAccountException();        //账户名错误
        }
        if(!"123".equals(password)){
            throw new IncorrectCredentialsException();  //密码错误
        }

        return new SimpleAuthenticationInfo(userName,password,getName());
    }

    @Override
    public String getName() {
        return "MyRealm";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {

        return authenticationToken instanceof UsernamePasswordToken;
    }
}
