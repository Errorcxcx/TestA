package com.example.paotui.bmob;

import com.example.myapplication.update.UpdateChecker;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.exception.BmobException;
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

    /**
     * 通过id查询用户
     * @param id
     * @param queryListener 结果回调
     */
    public void findUser(String id,QueryListener<MyUser> queryListener){
        BmobQuery<MyUser> query = new BmobQuery<>();
        query.getObject(id,queryListener);

    }

    /**
     * 发送验证码
     * @param phone
     * @param listener
     */

    public void sendCode(String phone, QueryListener<Integer> listener){

        BmobSMS.requestSMSCode(phone, "",listener);
    }

    /**
     * 验证验证码
     * @param phone
     * @param code
     * @param listener
     */

    public void checkCode(String phone,String code,UpdateListener listener){
        BmobSMS.verifySmsCode(phone, code,listener);
    }

}
