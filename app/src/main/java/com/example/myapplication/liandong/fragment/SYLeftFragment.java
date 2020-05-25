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
import com.example.myapplication.liandong.model.Phone;
import com.example.myapplication.liandong.model.PhoneBrand;
import com.example.myapplication.liandong.viewmodel.MyViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SYLeftFragment extends Fragment {

    private MyViewModel model;
    private RecyclerView recyclerView;
    private List list;
    private HashMap<PhoneBrand,Boolean> isClicks;
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
        PhoneBrand c1 = new PhoneBrand("小米");
        PhoneBrand c2 = new PhoneBrand("苹果");
        PhoneBrand c3 = new PhoneBrand("oppo");

        PhoneBrand c4 = new PhoneBrand("华为");

        PhoneBrand c5 = new PhoneBrand("三星");
        PhoneBrand c6 = new PhoneBrand("诺基亚");

        PhoneBrand c7 = new PhoneBrand("VIVO");

        PhoneBrand c8 = new PhoneBrand("MOTO");
        PhoneBrand c9 = new PhoneBrand("SONY");
        PhoneBrand c10 = new PhoneBrand("佳能");
        PhoneBrand c11 = new PhoneBrand("格力");

        Phone p1 = new Phone("Mi 10 Pro","5999");
        Phone p2 = new Phone("Mi 10 Pro","5999");
        Phone p3 = new Phone("Mi 10 Pro","5999");
        Phone p4 = new Phone("Mi 10 Pro","5999");
        Phone p5 = new Phone("Mi 10 Pro","5999");
        List<Phone> phones = new ArrayList<>();
        phones.add(p1);
        phones.add(p2);
        phones.add(p3);
        phones.add(p4);
        phones.add(p5);
        c1.setPhoneList(phones);
        c2.setPhoneList(phones);
        c3.setPhoneList(phones);
        c4.setPhoneList(phones);
        c5.setPhoneList(phones);
        c6.setPhoneList(phones);
        c7.setPhoneList(phones);
        c8.setPhoneList(phones);
        c9.setPhoneList(phones);
        c10.setPhoneList(phones);
        c11.setPhoneList(phones);


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
        Set<PhoneBrand> set =isClicks.keySet();
        for (PhoneBrand c:set
             ) {
            isClicks.put(c,false);
        }

    }

}
