package com.example.myapplication.liandong.base;

import android.content.Context;
import android.content.Intent;

public class BaseViewModel {
    public Context mContext ;

    public BaseViewModel(Context mContext) {
        this.mContext = mContext;
    }
    public static void openAty(Context context, Class<?> c) {
        context.startActivity(new Intent(context, c));
    }
}
