package com.example.paotui.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.databinding.AcyivityHomeBinding;
import com.example.paotui.base.BaseAty;
import com.example.paotui.viewmodel.CheckCodeViewModel;

public class HomeActivity extends BaseAty<AcyivityHomeBinding> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    protected int getLayout() {
        return R.layout.acyivity_home;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
