package com.example.base;

import android.view.View;

import androidx.annotation.NonNull;
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
