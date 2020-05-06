package com.example.paotui.viewmodel;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.databinding.ObservableField;

import com.example.paotui.AtyManager;
import com.example.paotui.activity.CheckActivity;
import com.example.paotui.activity.LoginActivity;
import com.example.paotui.base.BaseModel;
import com.example.paotui.bmob.BBmanager;
import com.xuexiang.xui.widget.toast.XToast;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;

public class LoginViewModel extends BaseModel {
    private String  phoneNumber;
    private EditText etPhone;
    public ObservableField<String> etPhoneNumber = new ObservableField<>("");
    public LoginViewModel(Context mContext) {
        super(mContext);
    }
    public void onCloseLogin(View view){
        AtyManager.getInstance().finishAty(LoginActivity.class);
    }

    public void onRegisterAndLogin(View view){
        sendCode();
    }
    private void sendCode(){
        Log.d("paotui", "sendCode: "+etPhoneNumber.get().length()+"--------"+etPhoneNumber.get());
        if(etPhoneNumber.get().length()!=11){
            XToast.warning(mContext,"手机号错误").show();
            return;
        }
        BBmanager.getInstance().sendCode(etPhoneNumber.get(), new QueryListener<Integer>() {
            @Override
            public void done(Integer integer, BmobException e) {
                if(e == null){
                    CheckActivity.openAtyWithDataForResult(mContext,CheckActivity.class,"phone",etPhoneNumber.get(),1000);
                }else {
                    XToast.warning(mContext,"发送失败"+e.getErrorCode()+"--").show();
                    e.printStackTrace();
                }
            }
        });

    }
}
