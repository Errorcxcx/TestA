package com.example.myapplication.update;

import android.content.Context;
import android.content.pm.PackageManager;

public class AppUtils {
    public static String getVersionName(Context mContext) {
        if (mContext != null) {
            try {
                return mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException ignored) {
            }
        }

        return "";
    }
}
