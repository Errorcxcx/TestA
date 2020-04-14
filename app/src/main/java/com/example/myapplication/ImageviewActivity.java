package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.myapplication.R;


public class ImageviewActivity extends AppCompatActivity {
    private ImageView mImv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview);
        mImv3 = (ImageView)findViewById(R.id.iv_3);

    }
}
