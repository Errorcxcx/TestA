package com.example.utils.okhttp3;

import android.util.Log;

import java.io.IOError;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Connect {
    public static void syncGretCall(String url) throws Exception{
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        final Call call = client.newCall(request);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = call.execute();
                    Log.d("syncGretCall", "run: "+response.body().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
    public static void asyncGetCall(String url) throws Exception{
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                        System.out.println("成功了"+response.body().toString());
            }
        });
        Thread.currentThread().join(5000);
    }

    //
    public static void postSring(String url,String string){
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("text/x-markdown; charset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType,string);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }

    public static void main(String[] args) {
        try {
            asyncGetCall("https://www.baidu.com/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
