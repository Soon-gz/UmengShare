package com.abings.umengsharedemo;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;

/**
 * Created by HaomingXu on 2016/6/17.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        PlatformConfig.setWeixin("wx62eaa747fa4f9993", "b3a1440ddcd56a58f11baf2d0115f29f");
        //微信 appid appsecret
        PlatformConfig.setSinaWeibo("3136860142","ba40ec9c01bdbae106d20ab57b62fb0b");
        //新浪微博 appkey appsecret
        PlatformConfig.setQQZone("1105478388", "QFWLmfnkhqluXz1U");
    }
}
