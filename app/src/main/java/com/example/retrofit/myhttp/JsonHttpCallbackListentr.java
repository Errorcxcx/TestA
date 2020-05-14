package com.example.retrofit.myhttp;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonHttpCallbackListentr<T> implements CallbackListener {

    private Class<T> responseClass;
    private Handler handler = new Handler(Looper.getMainLooper());
    private IJsonTrans iJsonTrans;

    public JsonHttpCallbackListentr(Class<T> responseClass,IJsonTrans iJsonTrans) {
        this.responseClass = responseClass;
        this.iJsonTrans = iJsonTrans;
    }

    @Override
    public void onSuccess(InputStream is) {
        String response = getContent(is);
        Log.d("NeHttp", "onSuccess: "+response);
        T clazz = JSON.parseObject(response,responseClass);
        handler.post(() -> iJsonTrans.onSuccess(clazz));
    }

    private String getContent(InputStream is){
        String content = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuffer sb = new StringBuffer();
            String line = null;
            try {
                while((line = reader.readLine())!=null){
                    sb.append(line+"\n");
                }
            }catch (Exception e){
                System.out.println("Error"+e.toString());
            }
            finally {
                try{
                    is.close();
                }catch (Exception e){
                    System.out.println("Error"+e.toString());
                }
            }
            content = sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return content;
    }

    @Override
    public void onFailure() {

    }
}
