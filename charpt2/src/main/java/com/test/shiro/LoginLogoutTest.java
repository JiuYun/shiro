package com.test.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;


/***
 *
 * Shiro登录登出案例
 * @author  LiJie
 *
 */
public class LoginLogoutTest {












    @Test
    public void oneRealm(){
        this.parent("classpath:shiro-realm.ini");
    }


    @Test
    public void first(){
        this.parent("classpath:shiro.ini");
    }







    public void parent(String iniPath){
        //1.得到SecurityManagerFactory
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(iniPath);

        //2.得到SecurityManager 并绑定到SecurityUtil,这个是全局设置整个应用绑定一次就够了
        SecurityManager manager = factory.getInstance();
        SecurityUtils.setSecurityManager(manager);

        //3.取得Subject及创建用户token
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zs","123456");

        //4.登陆
        try{
            subject.login(token);
        }catch(AuthenticationException e){
            //身份验证失败
        }

        //5.断言用户是否已经登陆
        Assert.assertEquals(true,subject.isAuthenticated());


        //6.退出
        subject.logout();


    }



}
