package com.shiro.session;


import org.apache.shiro.session.mgt.SimpleSession;


public class MySession extends SimpleSession{


    public static enum OnlineStatus{
        on_line("在线"),hidden("隐身"),force_logout("强制退出");

        private final String info;

        private OnlineStatus(String info){
            this.info = info;
        }

        private String getInfo(){
            return info;
        }


    }

    private String userAgent;                               //用户浏览器
    private OnlineStatus status = OnlineStatus.on_line;     //在线状态
    private String systemHost;                              //用户登陆时Ip

    public OnlineStatus getStatus() {
        return status;
    }

    public void setStatus(OnlineStatus status) {
        this.status = status;
    }







}
