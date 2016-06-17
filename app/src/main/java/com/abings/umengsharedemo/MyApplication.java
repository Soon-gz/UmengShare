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
        PlatformConfig.setWeixin("wxe5d412509c6a0c30", "d6ac9a4f059f863bc1f532b50797e7f8");
        //微信 appid appsecret
        PlatformConfig.setSinaWeibo("3136860142","ba40ec9c01bdbae106d20ab57b62fb0b");
        //新浪微博 appkey appsecret
        PlatformConfig.setQQZone("1105478388", "QFWLmfnkhqluXz1U");
    }
}
