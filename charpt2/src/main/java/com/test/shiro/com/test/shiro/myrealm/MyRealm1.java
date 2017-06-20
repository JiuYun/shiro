package com.test.shiro.com.test.shiro.myrealm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/***
 *
 * 多Realm1
 *
 */
public class MyRealm1 implements Realm{


    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
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

    @Override
    public String getName() {
        return "MyRealm1";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {

        return authenticationToken instanceof UsernamePasswordToken;
    }
}
