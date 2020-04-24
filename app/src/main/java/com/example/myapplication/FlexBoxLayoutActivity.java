package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;

public class FlexBoxLayoutActivity extends AppCompatActivity {
    public FlexboxLayout flexboxLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flexbox);
        flexboxLayout = (FlexboxLayout)findViewById(R.id.flexbox_layout);
        //通过代码向flexboxlayut添加view
        TextView textView = new TextView(this);
        textView.setBackground(ContextCompat.getDrawable(this,R.drawable.edittext));
        textView.setText("会当零界定");
        textView.setGravity(Gravity.CENTER);
        textView.setPadding(30,0,30,0);
        textView.setTextColor(ContextCompat.getColor(this,R.color.blue));
        flexboxLayout.addView(textView);
        ViewGroup.LayoutParams params = textView.getLayoutParams();
        if(params instanceof FlexboxLayout.LayoutParams){
            FlexboxLayout.LayoutParams layoutParams = (FlexboxLayout.LayoutParams) params;
            layoutParams.setFlexBasisPercent(0.5f);
        }


    }
}
