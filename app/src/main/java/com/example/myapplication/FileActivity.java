package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.SQLite.MyDatabaseHelper;

public class FileActivity extends AppCompatActivity {
    private Button myBtn_fp;
    private Button myBtn_sp;
    private Button myBtn_cd;
    private MyDatabaseHelper dpHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        onClickListener ol = new onClickListener();
        myBtn_fp = findViewById(R.id.btn_file);
        myBtn_sp = findViewById(R.id.sharedpreferences);
        myBtn_cd = findViewById(R.id.createdatabase);
        myBtn_fp.setOnClickListener(ol);
        myBtn_sp.setOnClickListener(ol);
        myBtn_cd.setOnClickListener(ol);
    }

    class onClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()) {
                case R.id.btn_file:
                    intent = new Intent(FileActivity.this, FilePersistenceActivity.class);
                    startActivity(intent);
                    break;
                case R.id.sharedpreferences:
                    intent = new Intent(FileActivity.this, SharedPeferencesActivity.class);
                    startActivity(intent);
                    break;
                case R.id.createdatabase:
                    dpHelper = new MyDatabaseHelper(FileActivity.this, "BookStore.db", null, 1);
                    dpHelper.getWritableDatabase();
                    break;
                default:
            }
        }
    }
}
