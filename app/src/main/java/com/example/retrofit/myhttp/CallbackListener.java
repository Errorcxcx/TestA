package com.example.retrofit.myhttp;

import java.io.InputStream;

public interface CallbackListener {

    void onSuccess(InputStream is);

    void onFailure();
}
