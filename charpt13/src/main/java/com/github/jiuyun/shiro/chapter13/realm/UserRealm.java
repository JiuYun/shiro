package com.github.jiuyun.shiro.chapter13.realm;

import com.github.jiuyun.shiro.chapter13.entity.User;
import com.github.jiuyun.shiro.chapter13.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/***
 *
 * User Realm
 *
 *
 */
public class UserRealm extends AuthorizingRealm {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    /***
     *
     * 重写获取授权信息
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = (String) principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userService.findRoles(userName));
        authorizationInfo.setStringPermissions(userService.findPermissions(userName));

        return authorizationInfo;
    }

    /***
     *
     * 重写验证信息
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();

        User user = userService.findByUsername(userName);
        if(user == null){
            throw new UnknownAccountException();                //账户不存在
        }

        if(Boolean.TRUE.equals(user.getLocked())){
            throw new LockedAccountException();                 //账户处于锁定状态
        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(),
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()), //userName +slat
                getName()
        );
        return authenticationInfo;
    }
}
