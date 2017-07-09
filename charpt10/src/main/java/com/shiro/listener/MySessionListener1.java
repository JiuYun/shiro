package com.shiro.listener;


import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

public class MySessionListener1 implements SessionListener{


    public void onStart(Session session) {
        System.out.println(String.format("创建会话[sessionId=%s]",session.getId()));
    }

    public void onStop(Session session) {
        System.out.println(String.format("会话过期[sessionId=%s]",session.getId()));
    }

    public void onExpiration(Session session) {
        System.out.println(String.format("会话停止[sessionId=%s]",session.getId()));
    }
}
