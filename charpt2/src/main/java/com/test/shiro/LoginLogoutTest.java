package com.test.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
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
    public void testHelloWorld(){
        parent("classpath:shiro.ini");
    }


    public void testMultiRealm(){
        parent("classpath:shiro-multi-realm.ini");
    }



    public void parent(String ini){
        //1.获取SecurityManager工厂，此处使用ini文件初始化SecurityManager
//        Factory<org.apache.shiro.mgt.SecurityManager> SMF = new IniSecurityManagerFactory("classpath:shiro.ini");
        Factory<org.apache.shiro.mgt.SecurityManager> SMF = new IniSecurityManagerFactory(ini);
        //2.得到SecurityManager 实例并绑定到SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = SMF.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3.得到Subject，及创建用户名/密码身份证验证Token
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");

        try{

            //登录，验证身份
            subject.login(token);
        }catch(Exception e){

            //登录失败
        }

        Assert.assertEquals(true,subject.isAuthenticated());                //断言用户已经登录

        subject.logout();
    }












}
