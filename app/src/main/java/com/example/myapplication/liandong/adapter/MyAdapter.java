package com.example.myapplication.liandong.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.R;
import com.example.myapplication.liandong.model.Case;

import java.util.HashMap;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    public Context mContext;
    public List list;
    public OnClickItemListener listener;
    private HashMap<Case,Boolean> isClicks;
    public MyAdapter(Context context,OnClickItemListener listener) {
        this.listener = listener;
        mContext = context;

    }
    public void setDatas(List list,HashMap<Case,Boolean> isClicks){
        if(null !=list && null!=isClicks){
            this.list = list;
            this.isClicks = isClicks;
        }
        notifyDataSetChanged();
    }
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.leftfrag_item,parent,false);
        Log.d("hahaha", "onCreateViewHolder: ");
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d("hahaha", "onBindViewHolder: "+isClicks.values());;
        if(isClicks.get(list.get(position))){
            holder.tv.setBackgroundColor(Color.parseColor("#ff2121"));

        }else {
            holder.tv.setBackgroundColor(Color.parseColor("#259B24"));

            isClicks.put((Case)(list.get(position)),false);
        }
        holder.tv.setText(((Case)list.get(position)).getName());
        Log.d("hahaha", "onBindViewHolder: "+((Case)list.get(position)).getName());
        holder.tv.setOnClickListener(v->listener.onClickItem(((Case)list.get(position))));
    }

    @Override
    public int getItemCount() {
        return list == null ?0:list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = (TextView)itemView.findViewById(R.id.lf_tv);

        }

    }

    public interface OnClickItemListener{
        void onClickItem(Case c);
    }
}
