package com.example.myapplication.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    public static Toast mToast;
    public static void showMsg(Context context, String msg){
        if(mToast == null){
            mToast = Toast.makeText(context,msg,Toast.LENGTH_LONG);
        }else{
        //mToast = Toast.makeText(context,msg,Toast.LENGTH_LONG);
           mToast.setText(msg);
        }
        mToast.show();
        //包装后的效果主要由if条件影响的
    }

}
