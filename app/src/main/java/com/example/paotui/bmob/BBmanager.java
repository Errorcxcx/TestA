package com.example.paotui.bmob;

import com.example.myapplication.update.UpdateChecker;

import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.UpdateListener;

public class BBmanager {
    private static class BBmanagerHolder{
        private BBmanager instance = new BBmanager();
    }
    public static BBmanager getInstance(){
        return new BBmanagerHolder().instance;
    }

    private BBmanager() {
    }

    public void sendCode(String phone, QueryListener<Integer> listener){

        BmobSMS.requestSMSCode(phone, "",listener);
    }
    /**
     *验证验证码
     *
     */

    public void checkCode(String phone,String code,UpdateListener listener){
        BmobSMS.verifySmsCode(phone, code,listener);
    }

}
