package com.example.retrofit.myhttp;

public interface IJsonTrans<T> {

    void onSuccess(T m);

    void onFailure();
}
