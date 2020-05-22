package com.example.paotui.app;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.xuexiang.xui.XUI;

import cn.bmob.v3.Bmob;

public class App extends Application {
    public String APP_KEY = "99df34869b85a089ec2db52cf6bfd6b7";
    public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this.getApplicationContext();
        Bmob.initialize(this,APP_KEY);

        XUI.init(this);

        XUI.debug(true);

        SDKInitializer.initialize(this);
        SDKInitializer.setCoordType(CoordType.BD09LL);
    }
    public static Context getContext(){
        return mContext;
    }
}
