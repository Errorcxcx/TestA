package com.example.showbeatuy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import com.example.myapplication.R;
import com.example.retrofit.InfoGson;
import com.example.retrofit.retrofitTest;

import java.util.ArrayList;
import java.util.List;

public class ShowBeatuyActivity extends AppCompatActivity {
    public List<InfoGson> list ;
    public GetBitmap getBitmap;
    public List<Bitmap> bitmaps;
    public retrofitTest retrofitTest ;
    public RecyclerView recyclerView;
    public BeautyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_beatuy);
        recyclerView = findViewById(R.id.beauty_recycler);
//        list = new ArrayList<>();
//        getBitmap = new GetBitmap();
        adapter = new BeautyAdapter(this);
//        bitmaps = getBitmap.getBitmaps();
//        for(int i = 0;i<bitmaps.size();i++){
//            Beauty beauty = new Beauty("小猪",bitmaps.get(i),"25"+i);
//            list.add(beauty);
//
//        }
        retrofitTest= new retrofitTest(this,handler);
        recyclerView.setOnScrollChangeListener(new RecyclerView.OnScrollChangeListener(){

            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

            }
        });
        list = retrofitTest.main("Girl",3);


    }
    public Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case 1:
                    Log.d("retrofit", "handleMessage: 加载完成");
                    recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
                    adapter.setList(list);
                    recyclerView.setAdapter(adapter);
            }
        }
    };


}
