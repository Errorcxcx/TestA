package com.example.myapplication;

import android.content.Intent;
import android.media.ExifInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.RequiresApi;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;

import com.example.databinding.viewmodel.ViewModeOne;
import com.example.exief.GetExiefMessage;
import com.example.myapplication.gridview.GridViewActivity;
import com.example.myapplication.listview.ListViewActivity;
import com.example.myapplication.util.ButtonListAdapter;
import com.example.notificationbar.aty.DaoHangActivity;
import com.example.retrofit.retrofitTest;
import com.example.seaechflowlayout.CustomizeActivity;
import com.example.search.SearchActivity;
import com.example.showbeatuy.ShowBeatuyActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UIActivity extends AppCompatActivity {
    private static final String TAG = "UIActivity";
    private ListView listView;

    private List<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        listView = findViewById(R.id.listview);
        list = new ArrayList<>();
        list.add("登录界面");
        list.add("RadioButton");
        list.add("CheckedBox");
        list.add("ImageView");
        list.add("ListView");
        list.add("GridView");
        list.add("WebView");
        list.add("Toast");
        list.add("什么都没有");
        list.add("webimage");
        list.add("获取图片exif信息");
        list.add("databinding");
        list.add("daohang");
        list.add("搜索界面");
        list.add("自动义View");
        list.add("flexboxlayout");
        list.add("Beauty");
        list.add("请求");
        ButtonListAdapter buttonListAdapter = new ButtonListAdapter(this, list, myOnclicker);
        listView.setAdapter(buttonListAdapter);
        buttonListAdapter.notifyDataSetChanged();

    }

    public ButtonListAdapter.MyOnClickLietener myOnclicker = new ButtonListAdapter.MyOnClickLietener() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public void myOnclick(int position, View view) {
            Intent intent = null;
            switch (position) {
                case 0:
                    intent = new Intent(UIActivity.this, EditTextActivity.class);
                    Log.d("data", "editactivity: ");
                    break;
                case 1:
                    intent = new Intent(UIActivity.this, RadioButtonActivity.class);
                    Log.d("data", "radiobuttonactivity: ");
                    break;
                case 2:
                    intent = new Intent(UIActivity.this, CheckBoxActivity.class);
                    break;
                case 3:
                    intent = new Intent(UIActivity.this, ImageviewActivity.class);
                    break;
                case 4:
                    intent = new Intent(UIActivity.this, ListViewActivity.class);
                    break;
                case 5:
                    intent = new Intent(UIActivity.this, GridViewActivity.class);
                    break;
                case 6:
                    intent = new Intent(UIActivity.this, WebViewActivity.class);
                    break;
                case 7:
                    intent = new Intent(UIActivity.this, ToastActivity.class);
                    break;
                case 8:
                    break;
                case 9:
                    intent = new Intent(UIActivity.this, BitmapActivity.class);
                    break;
                case 10:
                    try {
                        ExifInterface exifInterface = new ExifInterface(new File("/storage/emulated/0/DCIM/Camera/1.jpg"));
                        GetExiefMessage.getInstance().judgeImageAperture(exifInterface, "1111");
                        GetExiefMessage.getInstance().judgePhotoOtherInfo(exifInterface);
                        GetExiefMessage.getInstance().judgeImageISO(exifInterface, 50000, 0);
                        GetExiefMessage.getInstance().isFlashMode("/storage/emulated/0/DCIM/Camera/1.jpg");
                        Set<String> entrySet = GetExiefMessage.exifMap.keySet();
                        for (String key :
                                entrySet) {
                            Log.d("getMessage", key + "----" + GetExiefMessage.exifMap.get(key));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                case 11:
                    intent = new Intent(UIActivity.this, ViewModeOne.class);
                    break;
                case 12:
                    intent = new Intent(UIActivity.this, DaoHangActivity.class);
                    break;
                case 13:
                    intent = new Intent(UIActivity.this, SearchActivity.class);
                    break;
                case 14:
                    intent = new Intent(UIActivity.this, CustomizeActivity.class);
                    break;
                case 15:
                    intent = new Intent(UIActivity.this,FlexBoxLayoutActivity.class);
                    break;
                case 16:
                    intent = new Intent(UIActivity.this, ShowBeatuyActivity.class);
                    break;
                case 17:
                    return;
            }
            startActivity(intent);
        }


    };
}
