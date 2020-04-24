package com.example.databinding.viewmodel;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.databinding.model.User;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityViewModeOneBinding;

public class ViewModeOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityViewModeOneBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_view_mode_one);
        binding.setUserone(new User("字节跳动","123456"));
    }
}
