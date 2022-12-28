package com.utility.app.threads;

public class ThreadFactory {
    public void testAuthFactory(){
        String token = "";
        TheUserInfo theUserInfo = new TheUserInfo();
        SecurityContext.setUserInfo(theUserInfo);
        SecurityContext.getUserInfo();
        SecurityContext.clearUserInfo();
    }
}
