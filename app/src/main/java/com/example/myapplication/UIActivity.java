package com.example.myapplication;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aty.LoginActivity;
import com.example.myapplication.gridview.GridViewActivity;
import com.example.myapplication.listview.ListViewActivity;

public class UIActivity extends AppCompatActivity {
    private static final String TAG = "UIActivity";
    private Button mBtnTextView ;
    private Button mBtnRadioButton;
    private Button mBtnCheckBox;
    private Button mBtnImageview;
    private Button mBtnListView;
    private Button mBtnGridView;
    private Button mBtnWebView;
    private Button mBtnToast;
    private Button mBtnMvvm;
    private Button mBtnWebImage;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        mBtnTextView = (Button)findViewById(R.id.et_btn_1);
        mBtnRadioButton = (Button)findViewById(R.id.rb_btn_2);
        mBtnCheckBox = (Button)findViewById(R.id.cb_btn_3);
        mBtnImageview = (Button)findViewById(R.id.iv_btn_4);
        mBtnListView = (Button)findViewById(R.id.lv_btn_5);
        mBtnGridView = (Button)findViewById(R.id.gv_btn_6);
        mBtnWebView = (Button)findViewById(R.id.wv_btn_7);
        mBtnToast = (Button)findViewById(R.id.toast_btn_8);
        mBtnMvvm = (Button)findViewById(R.id.mvvm_btn_9);
        mBtnWebImage = (Button)findViewById(R.id.webimage_btn_10);
        setlisteners();

    }
    public void setlisteners(){
        OnClick ol = new OnClick();
        mBtnTextView.setOnClickListener(ol);
        mBtnRadioButton.setOnClickListener(ol);
        mBtnCheckBox.setOnClickListener(ol);
        mBtnImageview.setOnClickListener(ol);
        mBtnListView.setOnClickListener(ol);
        mBtnGridView.setOnClickListener(ol);
        mBtnWebView.setOnClickListener(ol);
        mBtnToast.setOnClickListener(ol);
        mBtnMvvm.setOnClickListener(ol);
        mBtnWebImage.setOnClickListener(ol);

    }
    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch(view.getId()){
                case  R.id.et_btn_1:
                    intent = new Intent(UIActivity.this,EditTextActivity.class);
                    Log.d("data", "editactivity: ");
                    break;
                case  R.id.rb_btn_2:
                    intent = new Intent(UIActivity.this,RadioButtonActivity.class);
                    Log.d("data", "radiobuttonactivity: ");
                    break;
                case  R.id.cb_btn_3:
                    intent = new Intent(UIActivity.this, CheckBoxActivity.class);
                    break;
                case  R.id.iv_btn_4:
                    intent = new Intent(UIActivity.this, ImageviewActivity.class);
                    break;
                case R.id.lv_btn_5:
                    intent = new Intent(UIActivity.this, ListViewActivity.class);
                    break;
                case R.id.gv_btn_6:
                    intent = new Intent(UIActivity.this, GridViewActivity.class);
                    break;
                case R.id.wv_btn_7:
                    intent = new Intent(UIActivity.this,WebViewActivity.class);
                    break;
                case R.id.toast_btn_8:
                    intent = new Intent(UIActivity.this, ToastActivity.class);
                    break;
                case R.id.mvvm_btn_9:
                    intent = new Intent(UIActivity.this, LoginActivity.class);
                    break;
                case R.id.webimage_btn_10:
                    intent = new Intent(UIActivity.this, BitmapActivity.class);
                    break;

            }
            startActivity(intent);
        }
    }
}
