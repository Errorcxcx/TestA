package com.example.retrofit.myhttp;

import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;

public class Httptask<T> implements Runnable {

    private IHttpRequest iHttpRequest;
    public Httptask(String url,T requestData,IHttpRequest httpRequest,CallbackListener listener){
        iHttpRequest = httpRequest;
        httpRequest.setUrl(url);
        httpRequest.setListener(listener);
        String content = JSON.toJSONString(requestData);
        try {
            httpRequest.setData(content.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        iHttpRequest.execute();
    }
}
