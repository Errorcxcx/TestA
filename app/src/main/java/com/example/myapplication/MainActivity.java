package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.RuntimePermission.CallActivity;
import com.example.myapplication.util.ToastUtil;

public class MainActivity extends AppCompatActivity {
    public Button myBtn_UI;
    public Button myBtn_test;
    public Button myBtn_file;
    public Button myBtn_permission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBtn_UI = findViewById(R.id.btn_ui);
        myBtn_test = findViewById(R.id.btn_test);
        myBtn_file = findViewById(R.id.file);
        myBtn_permission = findViewById(R.id.runtime_permission);

        OnClickListener ol = new OnClickListener();
        myBtn_UI.setOnClickListener(ol);
        myBtn_test.setOnClickListener(ol);
        myBtn_file.setOnClickListener(ol);
        myBtn_permission.setOnClickListener(ol);

    }

    class OnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()) {
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this, UIActivity.class);
                    break;
                case R.id.btn_test:
                    intent = new Intent(MainActivity.this, IntentActivity.class);
                    break;
                case R.id.file:
                    intent = new Intent(MainActivity.this,FileActivity.class);
                    break;
                case R.id.runtime_permission:
                    intent = new Intent(MainActivity.this, CallActivity.class);
                    break;
                default:
            }
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.add_item:
                ToastUtil.showMsg(getApplicationContext(),"点击了Add");
                break;
            case R.id.remove_item:
                ToastUtil.showMsg(getApplicationContext(),"点击了Remove");
                break;
            default:
        }
        return true;
    }
}
