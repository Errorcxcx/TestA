package com.example.notificationbar.aty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.databinding.model.User;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class DaoHangActivity extends AppCompatActivity implements AdapterOne.OnClickItemListener {
    public  List list;
    @Override
    public void onClickItem(int pos) {
        Log.d("daohang", "onClickItem: "+list.get(pos));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dao_hang);
        Log.d("daohang", "onCreate: ");
        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        User u1 = new User("阿里巴巴","保安部");
        User u2 = new User("阿里九九","保洁部");
        User u3 = new User("阿里六六","保密部");
        User u4 = new User("阿里三三","销售部");

        User u5 = new User("阿里大大","研发部");
        User u6 = new User("阿里旺旺","研发部");
        User u7 = new User("阿里米米","研发部");

        User u8 = new User("阿里小小","研发部");

        User u9 = new User("阿里花花","研发部");


        list = new ArrayList();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        list.add(u5);
        list.add(u9);
        list.add(u6);
        list.add(u7);
        list.add(u8);

        List choosedList = new ArrayList();


        AdapterOne adapterOne = new AdapterOne(DaoHangActivity.this,choosedList,this);
        adapterOne.setList(list);
        recyclerView.setAdapter(adapterOne);
        Log.d("daohang", "onCreate: dddddddddddd");



    }
}
