package com.example.myapplication.liandong.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * actvity基类
 *
 * @param <B>
 */
public abstract class BaseAty<B extends ViewDataBinding> extends AppCompatActivity {
    public B binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,getLayout());
        AtyManager.getInstance().addAty(this);
        initview();
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
        if(binding!=null){
            binding.unbind();
        }
    }

    protected abstract int getLayout();

    protected abstract void initview();

    protected abstract void initData();

    protected abstract void initListener();

    public static void openAty(Context context,Class c){
        context.startActivity(new Intent(context,c));
    }


}
