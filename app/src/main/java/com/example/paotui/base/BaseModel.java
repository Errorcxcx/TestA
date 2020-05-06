package com.example.paotui.base;

import android.content.Context;
import android.content.Intent;

public class BaseModel {
    public Context mContext;

    public BaseModel(Context mContext) {
        this.mContext = mContext;
    }
    public static void openAty(Context context, Class<?> c) {
        context.startActivity(new Intent(context, c));
    }
}
