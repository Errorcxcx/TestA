package com.example.paotui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityStartBinding;
import com.example.paotui.base.BaseAty;
import com.example.paotui.bmob.BBmanager;
import com.example.paotui.bmob.MyUser;
import com.example.paotui.manager.UserManager;
import com.xuexiang.xui.widget.toast.XToast;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;

public class StartActivity extends BaseAty<ActivityStartBinding> {
    private Intent intent;
    private String id;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1000){
                intent.setClass(StartActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }else {
                intent.setClass(StartActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = new Intent();
        SharedPreferences sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        id = sharedPreferences.getString("id","");
        if(!TextUtils.isEmpty(id)){
            findUser();
        }else{
            handler.sendEmptyMessageDelayed(1001,3000);
        }


    }
    private void findUser(){
        BBmanager.getInstance().findUser(id, new QueryListener<MyUser>() {
            @Override
            public void done(MyUser user, BmobException e) {
                if(e == null){
                    UserManager.getInstance().saveUser(user);
                    handler.sendEmptyMessageDelayed(1000,3000);
                }else{
                    XToast.warning(StartActivity.this,"失败"+e.getErrorCode()).show();
                }
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_start;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
