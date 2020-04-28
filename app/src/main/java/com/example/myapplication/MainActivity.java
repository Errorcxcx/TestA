package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.myapplication.RuntimePermission.CallActivity;
import com.example.myapplication.util.ToastUtil;
import com.example.myapplication.util.fragment.ShouYeFragment;
import com.example.myapplication.util.fragment.ViewFragment;
import com.example.myapplication.util.fragment.ViewpagerAdapter;
import com.example.retrofit.retrofitTest;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener{
    private Toolbar mToolbar;
    private BottomNavigationBar mBottomNavigationBar;
    public ViewPager viewPager;
    public List<Fragment> lists;
    public retrofitTest retrofitTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }
    public void initView(){
        lists = new ArrayList<>();
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setLogo(R.mipmap.er);
        setSupportActionBar(mToolbar);
//            mToolbar.setNavigationIcon(R.drawable.loading_icon);

        getSupportActionBar();
        lists.add(ShouYeFragment.newInstance("首页"));
        lists.add(ViewFragment.newInstance("预览"));
        viewPager = findViewById(R.id.fram_container);
        viewPager.setAdapter(new ViewpagerAdapter(getSupportFragmentManager(),5,lists));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBottomNavigationBar.selectTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mBottomNavigationBar = findViewById(R.id.bottom_navigation_bar);
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar.setBarBackgroundColor(R.color.blue);
        mBottomNavigationBar.setInActiveColor(R.color.white);//unSelected icon color
        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.home, "首页").setActiveColorResource(R.color.black_3))
                .addItem(new BottomNavigationItem(R.mipmap.view, "预览").setActiveColorResource(R.color.black_3))
                .addItem(new BottomNavigationItem(R.mipmap.find, "发现").setActiveColorResource(R.color.black_3))
                .addItem(new BottomNavigationItem(R.mipmap.mine, "我的").setActiveColorResource(R.color.black_3))
                .setFirstSelectedPosition(0)
                .initialise();
        mBottomNavigationBar.setTabSelectedListener(this);
    }

    public Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case 1:
                    Log.d("retrofit", "handleMessage: ");
                    break;
            }
        }
    };



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        retrofitTest = new retrofitTest(this,handler);
        switch(item.getItemId()){
            case R.id.add_item:
                ToastUtil.showMsg(getApplicationContext(),"点击了Add");
                retrofitTest.main("Girl");
                break;
            case R.id.remove_item:
                ToastUtil.showMsg(getApplicationContext(),"点击了Remove");
                break;
            default:
        }
        return true;
    }
    @Override
    public void onTabSelected(int position) {
        viewPager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

}
