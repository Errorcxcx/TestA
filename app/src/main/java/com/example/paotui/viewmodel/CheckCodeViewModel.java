package com.example.paotui.viewmodel;

import android.content.Context;
import android.view.View;

import androidx.databinding.ObservableField;

import com.example.paotui.base.BaseModel;

public class CheckCodeViewModel extends BaseModel {
    public ObservableField<String> tvCheckPhoneNumber = new ObservableField<>("");

    public CheckCodeViewModel(Context mContext,String phoneNumber) {
        super(mContext);
        tvCheckPhoneNumber.set(phoneNumber);
    }
    public void onCloseCheck(View view){

    }

}
