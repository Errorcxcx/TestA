package com.example.myapplication.util.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class ViewpagerAdapter extends FragmentStatePagerAdapter {
    public List<Fragment> lists;
    public ViewpagerAdapter(@NonNull FragmentManager fm, int behavior, List<Fragment> lists) {
        super(fm, behavior);
        this.lists = lists;
    }
    @Override
    public int getCount() {
        return lists.size();
    }


    @Override
    public Fragment getItem(int position) {
        return lists.get(position);
    }

}
