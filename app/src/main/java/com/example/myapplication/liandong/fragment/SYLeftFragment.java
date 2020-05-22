package com.example.myapplication.liandong.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.R;
import com.example.myapplication.liandong.adapter.MyAdapter;
import com.example.myapplication.liandong.model.Case;
import com.example.myapplication.liandong.viewmodel.MyViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SYLeftFragment extends Fragment {

    private MyViewModel model;
    private RecyclerView recyclerView;
    private List list;
    private HashMap<Case,Boolean> isClicks;
    private MyAdapter adapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model  = new ViewModelProvider(getActivity()).get(MyViewModel.class);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, container, false);

        list = new ArrayList();
        Case c1 = new Case("小米",1,"sss");
        Case c2 = new Case("苹果",1,"sss");
        Case c3 = new Case("oppo",1,"sss");

        Case c4 = new Case("华为",1,"sss");

        Case c5 = new Case("三星",1,"sss");
        Case c6 = new Case("诺基亚",1,"sss");

        Case c7 = new Case("VIVO",1,"sss");

        Case c8 = new Case("MOTO",1,"sss");
        Case c9 = new Case("SONY",1,"sss");
        Case c10 = new Case("佳能",1,"sss");
        Case c11 = new Case("格力",1,"sss");

        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        list.add(c5);
        list.add(c6);
        list.add(c7);
        list.add(c8);
        list.add(c9);
        list.add(c10);
        list.add(c11);



        isClicks = new HashMap<>();
        isClicks.put(c1,false);
        isClicks.put(c2,false);
        isClicks.put(c3,false);
        isClicks.put(c4,false);
        isClicks.put(c5,false);
        isClicks.put(c6,false);
        isClicks.put(c7,false);
        isClicks.put(c8,false);
        isClicks.put(c9,false);
        isClicks.put(c10,false);
        isClicks.put(c11,false);


        bindViews(view);
        return view;
    }

    public void bindViews(View view){
        recyclerView = view.findViewById(R.id.lf_rv);
        adapter = new MyAdapter(getContext(), c -> {
            model.select(c);
            huiFu();
            isClicks.put(c,true);
            adapter.notifyDataSetChanged();
            Log.d("hahaha", "onClickItem: "+c.getName());
        });
        adapter.setDatas(list,isClicks);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }
    public void huiFu(){
        Set<Case> set =isClicks.keySet();
        for (Case c:set
             ) {
            isClicks.put(c,false);
        }

    }

}
