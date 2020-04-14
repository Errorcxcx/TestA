package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SharedPeferencesActivity extends AppCompatActivity {
    private Button myBtn_save;
    private Button myBtn_restore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_peferences);
        myBtn_save = findViewById(R.id.sp_save);
        myBtn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("name","Apple");
                editor.putInt("age",18);
                editor.putBoolean("true/false",true);
                editor.apply();

            }
        });
        myBtn_restore = findViewById(R.id.sp_restore);
        myBtn_restore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("data",MODE_PRIVATE);
                String name = sp.getString("name","");
                int age = sp.getInt("age",0);
                Boolean bol = sp.getBoolean("true/false",false);
                Toast.makeText(SharedPeferencesActivity.this, "name is "+name+"  age is "+age+"  true/false is"+bol, Toast.LENGTH_SHORT).show();

            }
        });
    }

}
