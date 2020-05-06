package com.example.paotui.bmob;

import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.listener.QueryListener;

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
}
