package com.example.paotui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityCheckBinding;
import com.example.paotui.base.BaseAty;
import com.example.paotui.manager.UserManager;
import com.example.paotui.viewmodel.CheckCodeViewModel;

public class CheckActivity extends BaseAty<ActivityCheckBinding> {

    private CheckCodeViewModel model ;
    private String phoneNumber;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new CheckCodeViewModel(this,phoneNumber,binding);
        binding.setCheckmodel(model);

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_check;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        phoneNumber = getIntent().getStringExtra("phone");
    }

    @Override
    protected void initListener() {

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000 && resultCode == RESULT_OK){
            finish();
            Log.d("paotui", "userid "+ UserManager.getInstance().getUser().getObjectId());
        }
    }

}
