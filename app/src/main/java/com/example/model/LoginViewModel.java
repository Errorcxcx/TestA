package com.example.model;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import java.util.logging.Handler;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class LoginViewModel extends BaseViewModel {
    public ObservableField<String> userName = new ObservableField<>("");
    public String imgUrl = "http://img04.sogoucdn.com/app/a/100520024/388117fce2d37aa9a19656c7643e2a9c";
    public LoginViewModel(@NonNull Application application) {
        super(application);
    }
    public View.OnClickListener  loginOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }

    };
    public BindingCommand loginOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {

        }
    });

}
