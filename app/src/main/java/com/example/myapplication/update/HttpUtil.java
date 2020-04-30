package com.example.myapplication.update;

import android.util.Log;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtil {
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("application/octet-stream");
    public static String getHttpReturn(String address){
        String responseData = null;
        for(int i = 0;i<6;i++){
            try {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(address)
                        .get()
                        .build();
                Response response = client.newCall(request).execute();
                responseData = response.body().string();
                Log.d("UpdateChecker", "getHttpReturn: "+responseData);
                Log.d("UpdateChecker", "getHttpReturn: pass ");
                break;
            }catch (Exception e){
                Log.d("UpdateChecker", "getHttpReturn: fail ");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return responseData;
    }
}
