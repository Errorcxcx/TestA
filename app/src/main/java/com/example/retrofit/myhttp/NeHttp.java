package com.example.retrofit.myhttp;

public class NeHttp {
    public static<T,M> void setJsonRequest(String url,T requestData,Class<M> response,IJsonTrans listener){
        IHttpRequest httpRequest = new JsonHttpRequest();

        CallbackListener callbackListener = new JsonHttpCallbackListentr<>(response, listener);

        HttpTask<T> httptask = new HttpTask<>(url,requestData,httpRequest,callbackListener);

        ThreadPoolManager.getInstance().addTask(httptask);
    }
}
