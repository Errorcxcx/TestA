package com.example.paotui.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityLoginBinding;
import com.example.paotui.base.BaseAty;
import com.example.paotui.viewmodel.LoginViewModel;

public class LoginActivity extends BaseAty<ActivityLoginBinding> {
    private LoginViewModel model = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new LoginViewModel(this);
        binding.setLoginmodel(model);

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
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
