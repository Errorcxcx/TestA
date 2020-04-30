package com.example.myapplication.update;

import android.content.Context;
import android.util.Log;

public class UpdateChecker {

    public static void checkForDialog(Context context){
        if(context!=null){
            Log.d("UpdateChecker", "Start for Update Service");
            new CheckUpdateTask(context,1,true).execute();
        }else {
            Log.d("UpdateChecker", "The arg context is null");

        }
    }
}
