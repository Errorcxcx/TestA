package com.example.paotui.login;

import com.example.paotui.bmob.BBmanager;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class Check {

    public void checkPhoneCode(String phone,String code){
        BBmanager.getInstance().checkCode(phone, code, new UpdateListener() {
            @Override
            public void done(BmobException e) {

            }
        });
    }
}
