package com.shiro.test;

import junit.framework.Assert;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
public class Test extends BaseTest{





    @org.junit.Test
    public void testGetSession() throws Exception{
        login("classpath:shiro.ini", "zhang", "123");
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();

        System.out.println(session.getId());

        session.setAttribute("key","value");
        System.out.println(session.getAttribute("key"));


    }

















}
