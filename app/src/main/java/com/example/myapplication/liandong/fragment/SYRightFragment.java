package com.example.myapplication.liandong.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.liandong.viewmodel.MyViewModel;


public class SYRightFragment extends Fragment {

    private MyViewModel model;
    private TextView textView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model  = new ViewModelProvider(getActivity()).get(MyViewModel.class);
        model.getSelected().observe(this, aCase -> {
            Log.d("hahaha", "llllllll"+aCase.getName());
            textView.setText(aCase.getName());
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_right, container, false);
        bindViews(view);
        return view;
    }

    public void  bindViews(View view){
        textView = view.findViewById(R.id.rightfrag_tv);
    }
}
