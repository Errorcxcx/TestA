package com.example.myapplication.liandong.base;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<M,VH extends BaseVH> extends RecyclerView.Adapter<VH> {
    public Context mContext;
    public List<M> mList;

    public BaseAdapter(Context context) {
        mContext = context;
        mList = new ArrayList();
    }

    public void setList(List list){
        mList = list;
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
        return mList==null?0:mList.size();
    }

    public abstract  VH onCreateVH(ViewGroup parent, int viewType);

    public abstract void onBindVH(VH holder, int position);
}
