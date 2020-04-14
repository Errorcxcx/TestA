package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.util.ToastUtil;

public class ToastActivity extends AppCompatActivity {
    private Button mBtnToast1,mBtnToast2,mBtnToast3,mBtnToast4;
      @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_toast);
         mBtnToast1 = findViewById(R.id.btn_toast_1);
         mBtnToast2 = findViewById(R.id.btn_toast_2);
         mBtnToast3 = findViewById(R.id.btn_toast_3);
         mBtnToast4 = findViewById(R.id.btn_toast_4);
         setListeners();

      }

      public void setListeners(){
          OnClick onclick = new OnClick();
          mBtnToast1.setOnClickListener(onclick);
          mBtnToast2.setOnClickListener(onclick);
          mBtnToast3.setOnClickListener(onclick);
          mBtnToast4.setOnClickListener(onclick);

      }
      class OnClick implements View.OnClickListener {
          @Override
          public void onClick(View view) {
                switch(view.getId()){
                    case R.id.btn_toast_1:
                        Toast.makeText(getApplicationContext(),"Toast",Toast.LENGTH_SHORT).show();//每次都创建一个新的对象 所以会不停弹出 弹出次数=点击次数
                        break;
                    case R.id.btn_toast_2:
                        Toast toastCenter = Toast.makeText(getApplicationContext(),"居中Toast",Toast.LENGTH_SHORT);
                        toastCenter.setGravity(Gravity.CENTER,0,0);
                        toastCenter.show();
                        break;
                    case R.id.btn_toast_3:
                        Toast toastCustom = new Toast(getApplicationContext());
                        LayoutInflater inflater = LayoutInflater.from(ToastActivity.this);
                        View view_toast = inflater.inflate(R.layout.layout_toast,null);
                        ImageView imageview = (ImageView)view_toast.findViewById(R.id.iv_toast);
                        TextView textview = (TextView)view_toast.findViewById(R.id.tv_toast);
                        imageview.setImageResource(R.drawable.upset);
                        textview.setText("自定义Toast");
                        toastCustom.setView(view_toast);
                        toastCustom.show();
                        break;
                    case R.id.btn_toast_4:
                        ToastUtil.showMsg(getApplicationContext(),"包装过的Toast");//通过调用静态方法，只有一个Toast静态变量，不会重新创建 创建好之后只是修改传入位文本
                        break;



                }
          }
      }
}
