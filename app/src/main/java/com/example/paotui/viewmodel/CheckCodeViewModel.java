package com.example.paotui.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityCheckBinding;
import com.example.paotui.AtyManager;
import com.example.paotui.activity.CheckActivity;
import com.example.paotui.activity.HomeActivity;
import com.example.paotui.app.App;
import com.example.paotui.base.BaseModel;
import com.example.paotui.bmob.BBmanager;
import com.example.paotui.login.Check;
import com.xuexiang.xui.utils.WidgetUtils;
import com.xuexiang.xui.widget.dialog.MiniLoadingDialog;
import com.xuexiang.xui.widget.edittext.verify.VerifyCodeEditText;
import com.xuexiang.xui.widget.toast.XToast;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.UpdateListener;


public class CheckCodeViewModel extends BaseModel {
    public ActivityCheckBinding mBinding;
    public ObservableField<String> tvCheckPhoneNumber = new ObservableField<>("");
    public ObservableField<String> timer = new ObservableField<>("");
    public View view;
    private String phone;
    public int count = 6;
    private MiniLoadingDialog miniLoadingDialog;
    public Handler mHandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1001){
                miniLoadingDialog.dismiss();
                ((Activity)mContext).setResult(Activity.RESULT_OK);
                openAty(mContext,HomeActivity.class);
                return;
            }
            if(msg.what == 1){
                timer.set("重新发送");
                mBinding.btnTime.setEnabled(true);
                count = 6;
            }else {

                    count--;
                    timer.set(String.valueOf(count));
                    mHandler.sendEmptyMessageDelayed(count,1000);

            }

        }
    };
    public CheckCodeViewModel(Context mContext, String phoneNumber, ViewDataBinding binding) {
        super(mContext);
        mBinding = (ActivityCheckBinding)binding;
        phone = phoneNumber;
        tvCheckPhoneNumber.set(phoneNumber);
        mHandler.sendEmptyMessage(count);
        miniLoadingDialog = WidgetUtils.getMiniLoadingDialog(mContext);
        miniLoadingDialog.setDialogSize(200,200);
        mBinding.btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCode(phoneNumber);
                mBinding.btnTime.setEnabled(false);
            }
        });
        mBinding.etCodeCheck.setOnInputListener(new VerifyCodeEditText.OnInputListener() {
            @Override
            public void onComplete(String input) {
                checkPhoneCode(input);
            }

            @Override
            public void onChange(String input) {

            }

            @Override
            public void onClear() {
            }
        });

    }

    private void checkPhoneCode(String code) {
        miniLoadingDialog.show();
        Check check = new Check();
        check.checkPhoneCode(phone, code, new Check.LoginCallback() {
            @Override
            public void done(String id) {
                putUserId(id);
            }

            @Override
            public void error(String msg, int errorCode) {
                miniLoadingDialog.dismiss();
                XToast.warning(mContext,msg+errorCode);
                Log.d("paotui", "错误信息："+msg+"  错误码："+errorCode);
            }
        });
    }

    private void putUserId(String id) {
        SharedPreferences s = App.getContext().getSharedPreferences("user",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = s.edit();
        edit.putString("id",id);
        edit.commit();
        mHandler.sendEmptyMessageDelayed(1001,500);
    }

    public void onCloseCheck(View view){
        AtyManager.getInstance().finishAty(CheckActivity.class);
    }

    public void onIVClose(View view){
        AtyManager.getInstance().finishAty(CheckActivity.class);
    }

    private void  sendCode(String phoneNumber){
        BBmanager.getInstance().sendCode(phoneNumber, new QueryListener<Integer>() {
            @Override
            public void done(Integer integer, BmobException e) {
                if(e == null){
                    XToast.success(mContext,"发送成功").show();
                }else{
                    XToast.warning(mContext,"发送失败").show();
                }
            }
        });
    }

}
