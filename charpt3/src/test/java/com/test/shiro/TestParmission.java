package com.test.shiro;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/7/1 0001.
 */
public class TestParmission extends BaseTest {





    @Test
    public void testPermission(){

        login("classpath:shiro-permission.ini","zhang","123");

        //判断是否拥有权限create
        Assert.assertTrue(subject().isPermitted("user:create"));

        //判断是否拥有权限crate,update
        Assert.assertTrue(subject().isPermittedAll("user:update","user:delete"));

        //判断没有权限user:view
        Assert.assertFalse(subject().isPermitted("user:view"));

    }













}
