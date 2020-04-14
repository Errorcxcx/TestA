package com.example.myapplication;


import android.content.Context;
import android.content.Intent;

import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;
import androidx.test.uiautomator.UiDevice;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(AndroidJUnit4.class)
public class ExampleTest {
    UiDevice myDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    private static String appName = "com.android.camera";

    @Test
    public void openCamera() {
        String heughtAndWidth;
        try {
            if (!myDevice.isScreenOn()) {
                myDevice.wakeUp();
                myDevice.pressHome();
            }
            Context context = InstrumentationRegistry.getTargetContext();
            startApp(context, appName);
            myDevice.waitForWindowUpdate(appName, 5 * 2000);
            Thread.sleep(500);
            closeApp(appName);
            //heughtAndWidth = getHeightAndWidth(myDevice);
            //System.out.print(heughtAndWidth);
            //System.out.print(8888);
            //getHeightAndWidth(myDevice);
            myDevice.openNotification();
            sleep();
            myDevice.pressHome();
            sleep();
            myDevice.openQuickSettings();
            sleep();
            myPresshome(2);
            //myDevice.sleep();
            /*Boolean bol =  myDevice.takeScreenshot(new File("sdcard/test1.png"));
            System.out.println(bol);*/


        } catch (Exception expection) {
            expection.printStackTrace();
        }

    }

    public void startApp(Context mContext, String appPackageName) {
        //打开App
        Intent intent = mContext.getPackageManager().getLaunchIntentForPackage(appPackageName);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        mContext.startActivity(intent);
    }

    public void closeApp(String appPackageName) {
        //关闭App
        try {
            myDevice.executeShellCommand("am force-stop " + appPackageName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getHeightAndWidth(UiDevice device) {
        //获取手机屏幕宽和高
        double height = device.getDisplayHeight();
        double width = device.getDisplayWidth();
        return "高" + height + "---" + "宽" + width;
    }

    public void sleep() throws Exception {
        //当前线程休眠1s
        Thread.sleep(1000);
    }

    public void myPresshome(int times) throws Exception {
        //点击times次 home键
        for (int i = 0; i < times; i++) {
            myDevice.pressHome();
            sleep();

        }
    }

}
