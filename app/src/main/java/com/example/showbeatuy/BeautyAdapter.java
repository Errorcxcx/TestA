package com.example.showbeatuy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.example.base.BaseAdapter;
import com.example.base.BaseVH;
import com.example.myapplication.R;
import com.example.myapplication.databinding.BeautyItemBinding;
import com.example.notificationbar.aty.AdapterOne;
import com.example.retrofit.InfoGson;

public class BeautyAdapter extends BaseAdapter<BeautyAdapter.BeautyViewHolder>{

    public Context context;

    public BeautyAdapter(Context context) {
        super(context);
        this.context = context;

    }

    @Override
    public BeautyViewHolder onCreateVH(ViewGroup parent, int viewType) {
        BeautyItemBinding beautyItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.beauty_item,parent,false);
        BeautyViewHolder holder = new BeautyViewHolder(beautyItemBinding);

        return holder;
    }

    @Override
    public void onBindVH(BeautyViewHolder holder, int position) {
        BeautyItemBinding beautyItemBinding = (BeautyItemBinding)holder.binding;
        beautyItemBinding.setBeatuygl((InfoGson) list.get(position));

    }

    @Override
    public long getItemId(int position) {
        return list == null?0:list.size();
    }


    public class BeautyViewHolder extends BaseVH{
        public BeautyViewHolder(ViewDataBinding binding) {
            super(binding);
        }
    }
}
