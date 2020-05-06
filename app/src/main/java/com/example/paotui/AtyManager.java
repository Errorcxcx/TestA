package com.example.paotui;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Instrumentation;
import android.content.Context;
import android.view.KeyEvent;

import java.util.Stack;

import static android.os.Process.killProcess;

public class AtyManager {
    private static AtyManager mInstance;
    private Stack<Activity> atyStack = new Stack<>();


    /**
     * 采用懒汉式获取堆栈管理类的实例
     *
     * @return
     */
    public static AtyManager getInstance() {
        if (mInstance == null) {
            synchronized (Object.class) {
                if (mInstance == null) {
                    mInstance = new AtyManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * 将activity添加到堆栈里
     *
     * @param activity
     */
    public void addAty(Activity activity) {

        if (atyStack == null) {
            atyStack = new Stack<>();
        }
        atyStack.add(activity);
    }


    /**
     * 停止指定的activity
     *
     * @param c
     */
    public void finishAty(Class<?> c) {

        for (Activity activity : atyStack) {
            Class<? extends Activity> activityClass = activity.getClass();
            if (c.equals(activityClass)) {
                finishAty(activity);
                break;
            }
        }
    }

    /**
     * 停止activity
     *
     * @param activity
     */
    public void finishAty(Activity activity) {

        if (activity != null && !activity.isFinishing()) {
            activity.finish();
            atyStack.remove(activity);
        }
    }

    /**
     * 停止当前的activity
     */
    public void finishAty() {
        Activity activity = atyStack.lastElement();
        finishAty(activity);
    }

    /**
     * 获取当前的activity
     *
     * @return
     */
    public Activity getCurrentAty() {
        if (atyStack.size() == 0) {
            return null;
        }
        Activity activity = atyStack.lastElement();

        return activity;
    }

    /**
     * 获取指定的activity
     */
    public Activity getAcivity(Class<?> c) {
        if (atyStack != null) {
            for (Activity activity : atyStack) {
                if (activity.getClass().equals(c)) {
                    return activity;
                } else {
                    return getCurrentAty();
                }
            }
        }
        return null;
    }

    /**
     * 关掉所有的activity
     * 清空堆栈
     */
    public void finishAllAty() {

        for (int i = 0; i < atyStack.size(); i++) {
            Activity activity = atyStack.get(i);
            activity.finish();
        }
        atyStack.clear();
    }

    /**
     * 关掉除当前activity之外的界面
     *
     * @param c
     */
    public void finishOtherAty(Class c) {
        for (int i = 0; i < atyStack.size(); i++) {
            Activity activity = atyStack.get(i);
            if (c.equals(activity.getClass())) {
                continue;
            }
            activity.finish();
        }
    }

    /**
     * 退出程序
     */
    public void exitSystem() {
        try {
            killProcess(android.os.Process.myPid());
            System.exit(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回键
     */
    public void executBack() {
        new Thread() {
            public void run() {
                try {
                    Instrumentation inst = new Instrumentation();
                    inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
                } catch (Exception e) {
                }
            }
        }.start();
    }

    /**
     * 退出应用程序
     */
//    public void AppExit() {
//        try {
//            finishAllAty();
//            killProcess(Process.myPid());
//            System.exit(0);
//        } catch (Exception e) {
//
//        }
//
//    }
    public boolean judgeCurrentAtyIsOpen(Context context, String atyName) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        String name = activityManager.getRunningTasks(1).get(0).topActivity.getClassName();

        if (atyName.equals(name)) {
            return true;
        }
        return false;
    }

}
