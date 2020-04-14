package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class IntentActivity extends AppCompatActivity {
    private Button myBtnIntent1, myBtnIntent2, myBtnIntent3, myBtnIntent4,myBtnIntent5,myBtnIntent6;

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        myBtnIntent1 = findViewById(R.id.btn_intent_xian);
        myBtnIntent2 = findViewById(R.id.btn_intent_yin);
        myBtnIntent3 = findViewById(R.id.btn_intent_yin_1);
        myBtnIntent4 = findViewById(R.id.btn_intent_yin_2);
        myBtnIntent5 = findViewById(R.id.btn_intent_yin_3);
        myBtnIntent6 = findViewById(R.id.btn_intent_yin_4);
        myBtnIntent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntentActivity.this, EditTextActivity.class);
                startActivity(intent);
            }
        });
        myBtnIntent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com..example.activitytest.ACTION_START");
                intent.addCategory("com.examle.activitytest.MY_CATEGORY");
                startActivity(intent);
            }
        });
        myBtnIntent3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);//打开浏览器


            }
        });
        myBtnIntent4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);  //打开拨号输入10086

            }
        });
        myBtnIntent5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntentActivity.this,TestActivity.class);
                intent.putExtra("extra_data","跳转到TestActivity");
                startActivity(intent);//跳转到MainActivity并且携带数据 key = extra_data,value = "跳转到TestActivity"
            }
        });
        myBtnIntent6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntentActivity.this,Test2Activity.class);
                startActivityForResult(intent,1);
                //intent只用来跳转活动
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String resultData;
        switch (requestCode) {//根据requestCode判断返回数据的来源
            case 1:
                if (resultCode == RESULT_OK) {
                    //判断上一活动是否处理成功携带数据
                    resultData = data.getStringExtra("data_return");
                    Log.d("IntentActivity", resultData);
                }
                break;
            default:

        }
    }
}
