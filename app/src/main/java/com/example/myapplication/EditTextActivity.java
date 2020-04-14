package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class EditTextActivity extends AppCompatActivity {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Button login;
    private EditText et_username;
    private EditText et_password;
    private CheckBox rememberPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        pref = getSharedPreferences("data", MODE_PRIVATE);
        et_username = findViewById(R.id.username);
        et_password = findViewById(R.id.password);
        rememberPass = findViewById(R.id.remeber_pass);
        login = findViewById(R.id.login);
        Boolean is_remember = pref.getBoolean("remember_password", false);
        if (is_remember) {
            et_username.setText(pref.getString("username", ""));
            et_password.setText(pref.getString("password", ""));
            rememberPass.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                if (username.equals("xiaomi") && password.equals("123456")) {
                    editor = pref.edit();
                    if (rememberPass.isChecked()) {
                        editor.putBoolean("remember_password", true);
                        editor.putString("username", username);
                        editor.putString("password", password);
                    } else {
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent = new Intent(EditTextActivity.this, SuccessActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(EditTextActivity.this, "密码或账号输入错误", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
