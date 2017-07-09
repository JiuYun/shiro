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

import java.util.Arrays;

/***
 *
 * 你只看到了表面
 *
 *
 */
public class AuthorizationTest {






    @Test
    public void testHasRole(){

        Subject subject = login("classpath:shiro.ini");

        //判断用户是否拥有角色1
        Assert.assertTrue(subject.hasRole("role1"));

        Assert.assertTrue(subject.hasAllRoles(Arrays.asList("role1","role2")));

        boolean[] result = subject.hasRoles(Arrays.asList("role1","role2","role3"));

        Assert.assertTrue(result[0]);
        Assert.assertTrue(result[1]);
        Assert.assertFalse(result[2]);



    }







    public Subject login(String iniPath){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(iniPath);
        SecurityManager manager = factory.getInstance();
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
        try{
            subject.login(token);
        }catch (AuthenticationException e){
            System.out.println("登录失败");
        }
        return subject;
    }


}
