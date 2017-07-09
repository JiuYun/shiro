package com.test.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/7/1 0001.
 */
public class RoleTest extends BaseTest {





    @Test
    public void hashRole(){
        login("classpath:shiro.ini","zhang","123");

        Assert.assertTrue(subject().hasRole("role1"));

        Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role1","role2")));

        boolean[] result = subject().hasRoles(Arrays.asList("role1","role2","relo3"));

        Assert.assertTrue(result[0]);
        Assert.assertTrue(result[1]);
        Assert.assertFalse(result[2]);

    }












}
