package com.example.retrofit.myhttp;

import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class HttpTask<T> implements Runnable, Delayed {

    private IHttpRequest iHttpRequest;
    public HttpTask(String url, T requestData, IHttpRequest httpRequest, CallbackListener listener){
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

    private long delayTime;
    private int retryCount;

    public IHttpRequest getiHttpRequest() {
        return iHttpRequest;
    }

    public void setiHttpRequest(IHttpRequest iHttpRequest) {
        this.iHttpRequest = iHttpRequest;
    }

    public long getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(long delayTime) {
        this.delayTime = System.currentTimeMillis()+delayTime;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.delayTime-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}