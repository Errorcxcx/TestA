package com.example.base;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<VH extends BaseVH> extends RecyclerView.Adapter<VH> {
    public Context context;
    public List<Object> list;

    public BaseAdapter(Context context) {
        this.context = context;
        list = new ArrayList();
    }

    public void setList(List list){
        this.list = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("daohang", "onCreateViewHolder: 222222222222222222");
        return onCreateVH(parent,viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        onBindVH(holder,position);
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    public abstract  VH onCreateVH(ViewGroup parent, int viewType);

    public abstract void onBindVH(VH holder, int position);
}
