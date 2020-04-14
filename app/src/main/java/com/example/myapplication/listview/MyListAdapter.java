package com.example.myapplication.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

public class MyListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater mLayoutInflater;

    public MyListAdapter(Context context) {
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return 10;
    }//列表长度是多少

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    static class ViewHolder{
        public ImageView imageView;
        public TextView tvTitle,tvTime,tvContent;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view == null){
            view = mLayoutInflater.inflate(R.layout.layout_list_item,null);
            holder = new ViewHolder();
            holder.imageView = (ImageView)  view.findViewById(R.id.iv_listitem);
            holder.tvTitle = view.findViewById(R.id.tv_title);
            holder.tvTime = view.findViewById(R.id.tv_time);
            holder.tvContent = view.findViewById(R.id.tv_content);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        //给控件赋值
        holder.tvTitle.setText("这是标题");
        holder.tvTime.setText("2019-08-11");
        holder.tvContent.setText("这是内容");
        return view;
    }
}
