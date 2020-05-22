package com.example.myapplication.liandong.aty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.example.myapplication.R;
import com.example.myapplication.liandong.fragment.ShouYeFragment;


public class LianDongActivity extends AppCompatActivity {
    private BottomNavigationBar mBottomNavigationBar;

    private Toolbar mToolbar;
    private static LianDongActivity instance;
    private ShouYeFragment shouYeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liandong);
        initview();

    }

    protected void initview() {
        setDefaultFragment();

    }






    private void setDefaultFragment(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(shouYeFragment == null){
            shouYeFragment = ShouYeFragment.newInstance("首页");

        }
        transaction.replace(R.id.frame_container,shouYeFragment);
        transaction.commit();
    }
}
