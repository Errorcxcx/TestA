package com.example.paotui.login;

import com.example.paotui.bmob.BBmanager;
import com.example.paotui.bmob.MyUser;
import com.example.paotui.manager.UserManager;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class Check {

    private LoginCallback mLoginCallback;
    private String phone;

    public void checkPhoneCode(String phone, String code, LoginCallback callback) {
        this.mLoginCallback = callback;
        this.phone = phone;
        BBmanager.getInstance().checkCode(phone, code, new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    findUserByPhone();
                } else {
                    mLoginCallback.error(e.getMessage(), e.getErrorCode());
                }
            }
        });
    }

    private void findUserByPhone() {
        BmobQuery<MyUser> query = new BmobQuery<>();
        query.addWhereEqualTo("phone", phone);
        query.findObjects(new FindListener<MyUser>() {
            @Override
            public void done(List<MyUser> list, BmobException e) {
                if (e == null) {
                    if (list.size() > 0) {
                        MyUser myUser = list.get(0);
                        UserManager.getInstance().saveUser(myUser);
                        mLoginCallback.done(UserManager.getInstance().getUser().getObjectId());
                    } else {
                        createUser();
                    }
                } else {
                    mLoginCallback.error(e.getMessage(), e.getErrorCode());
                }
            }
        });
    }

    private void createUser() {
        MyUser user = new MyUser.Builder()
                .setName("小米")
                .setPhone(phone)
                .setPhotoUrl("null")
                .setPayPwd("0000")
                .setMoney(0.0)
                .setUpMoney(0.0)
                .build();
        user.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {
                    UserManager.getInstance().saveUser(user);
                    mLoginCallback.done(UserManager.getInstance().getUser().getObjectId());
                } else {
                    mLoginCallback.error(e.getMessage(), e.getErrorCode());
                }
            }
        });
    }

    public interface LoginCallback {
        void done(String id);

        void error(String msg, int errorCode);
    }
}
