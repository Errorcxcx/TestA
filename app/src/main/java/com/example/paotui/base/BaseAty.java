package com.example.paotui.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.example.myapplication.R;
import com.example.paotui.AtyManager;
import com.xuexiang.xui.XUI;
import com.xuexiang.xui.utils.StatusBarUtils;

public abstract  class BaseAty<B extends ViewDataBinding> extends AppCompatActivity {
    public B binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,getLayout());
        XUI.initTheme(this);
        StatusBarUtils.initStatusBarStyle(this,false, ActivityCompat.getColor(this, R.color.blue));

        AtyManager.getInstance().addAty(this);
        initView();
        initData();

    }

    @Override
    protected void onResume() {
        super.onResume();
        initListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (binding != null) {
            binding.unbind();
        }
    }
    /**
     * 绑定界面
     *
     * @return
     */
    protected abstract int getLayout();

    /**
     * 初始化
     */
    protected abstract void initView();

    /**
     * 处理数据
     */
    protected abstract void initData();

    /**
     * 监听事件
     */
    protected abstract void initListener();
    /**
     * 设置某个activity的跳转
     *
     * @param context 某个页面
     * @param c       下个页面
     */
    public static void openAty(Context context, Class c) {
        context.startActivity(new Intent(context, c));
    }

    public static void openAtyWithDataForResult(Context context, Class c,String name,String value,int resultCode) {
        Intent intent = new Intent(context,c);
        intent.putExtra(name,value);
        ((Activity)context).startActivityForResult(intent,resultCode);

    }
}
