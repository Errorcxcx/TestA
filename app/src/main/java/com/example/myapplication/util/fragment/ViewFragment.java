package com.example.myapplication.util.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class ViewFragment extends Fragment {
    public static ViewFragment newInstance(String param) {
        ViewFragment viewFragment = new ViewFragment();
        Bundle args = new Bundle();
        args.putString("args", param);
        viewFragment.setArguments(args);

        return viewFragment;
    }
    public ViewFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_view,container,false);
        Bundle bundle = getArguments();

        return view;
    }
}
