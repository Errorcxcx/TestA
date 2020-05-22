package com.example.myapplication.liandong.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.base.BaseAdapter;
import com.example.base.BaseVH;
import com.example.myapplication.R;

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.RightViewHolder> {
    public Context mContext;
    public RightAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public RightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_right_fram,parent,false);
        return new RightViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RightViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class RightViewHolder extends RecyclerView.ViewHolder {

        public RightViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
