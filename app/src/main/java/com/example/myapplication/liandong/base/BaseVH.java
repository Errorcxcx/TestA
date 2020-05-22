package com.example.myapplication.liandong.base;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public  class BaseVH extends RecyclerView.ViewHolder {
    public ViewDataBinding binding;
    public BaseVH(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public ViewDataBinding binding(){
        return binding;
    }
}
