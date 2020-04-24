package com.example.showbeatuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ShowBeatuyActivity extends AppCompatActivity {
    public List<Beauty> list ;
    public GetBitmap getBitmap;
    public List<Bitmap> bitmaps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_beatuy);
        RecyclerView recyclerView = findViewById(R.id.beauty_recycler);
        list = new ArrayList<>();
        getBitmap = new GetBitmap();
        BeautyAdapter adapter = new BeautyAdapter(this);
        bitmaps = getBitmap.getBitmaps();
        for(int i = 0;i<bitmaps.size();i++){
            Beauty beauty = new Beauty("小猪",bitmaps.get(i),"25"+i);
            list.add(beauty);

        }
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        adapter.setList(list);
        recyclerView.setAdapter(adapter);

    }


}
