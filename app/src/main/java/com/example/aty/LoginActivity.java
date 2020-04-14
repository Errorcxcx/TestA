package com.example.aty;

import android.os.Bundle;
import android.os.Handler;

import com.example.model.LoginViewModel;
import com.example.myapplication.BR;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivituLoginBinding;

import me.goldze.mvvmhabit.base.BaseActivity;

public class LoginActivity extends BaseActivity<ActivituLoginBinding, LoginViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activitu_login;
    }

    @Override
    public int initVariableId() {
        return BR.model;
    }

}
