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
import com.example.myapplication.liandong.model.PhoneList;
import com.example.myapplication.liandong.viewmodel.MyViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SYLeftFragment extends Fragment {

    private MyViewModel model;
    private RecyclerView recyclerView;
    private List<PhoneBrand> list;
    private HashMap<PhoneBrand, Boolean> isClicks;
    private MyAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new ViewModelProvider(getActivity()).get(MyViewModel.class);
        model.getSelected2().observe(this, aCase -> adapter.setSelected(aCase,false));
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, container, false);

        list = PhoneList.getInstance().list;


        isClicks = new HashMap<>();
        isClicks.put((PhoneBrand) list.get(0), false);
        isClicks.put((PhoneBrand) list.get(1), false);
        isClicks.put((PhoneBrand) list.get(2), false);
        isClicks.put((PhoneBrand) list.get(3), false);
        isClicks.put((PhoneBrand) list.get(4), false);
        isClicks.put((PhoneBrand) list.get(5), false);
        isClicks.put((PhoneBrand) list.get(6), false);
        isClicks.put((PhoneBrand) list.get(7), false);
        isClicks.put((PhoneBrand) list.get(8), false);
        isClicks.put((PhoneBrand) list.get(9), false);
        isClicks.put((PhoneBrand) list.get(10), false);


        bindViews(view);
        return view;
    }

    public void bindViews(View view) {
        recyclerView = view.findViewById(R.id.lf_rv);
        adapter = new MyAdapter(getContext(), (position, bol) -> {

            huiFu();
            isClicks.put((PhoneBrand) list.get(position), true);
            adapter.notifyDataSetChanged();
            int sum = 0;
            for (int i = 0; i < position; i++) {
                sum += list.get(i).getPhoneList().size() + 1;
            }
            Log.d("liandong", "bindViews: " + sum);
            if (bol) {
                model.select(sum);
            }

        });
        adapter.setDatas(list, isClicks);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    public void huiFu() {
        Set<PhoneBrand> set = isClicks.keySet();
        for (PhoneBrand c : set
        ) {
            isClicks.put(c, false);
        }

    }

}
