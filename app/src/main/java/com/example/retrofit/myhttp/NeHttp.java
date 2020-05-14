package com.example.retrofit.myhttp;

import java.util.concurrent.ThreadPoolExecutor;

public class NeHttp {
    public static<T,M> void setJsonRequest(String url,T requestData,Class<M> response,IJsonTrans listener){
        IHttpRequest httpRequest = new JsonHttpRequest();

        CallbackListener callbackListener = new JsonHttpCallbackListentr<>(response, listener);

        Httptask<T> httptask = new Httptask<>(url,requestData,httpRequest,callbackListener);

        ThreadPoolManager.getInstance().addTask(httptask);
    }
}
