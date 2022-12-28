package com.utility.app.threads;

public class SecurityContext {

    private static ThreadLocal<TheUserInfo> threadLocal = new ThreadLocal<TheUserInfo>();
    public static void setUserInfo(TheUserInfo theUserInfo) {
        clearUserInfo();
        threadLocal.set(theUserInfo);
    }

    public static TheUserInfo getUserInfo() {
        return threadLocal.get();
    }

    public static void clearUserInfo() {
        threadLocal.remove();
    }
}
