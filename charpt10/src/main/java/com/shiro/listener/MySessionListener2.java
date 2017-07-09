package com.shiro.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;


public class MySessionListener2 extends SessionListenerAdapter{

    @Override
    public void onStart(Session session) {
        System.out.println(String.format("监听器二：创建会话[sessionId=%s]",session.getId()));
    }
}
