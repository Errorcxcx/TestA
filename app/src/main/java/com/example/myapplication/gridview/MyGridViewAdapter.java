package com.example.myapplication.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

public class MyGridViewAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater mlayoutinflater;
    public MyGridViewAdapter(Context context){
        this.context = context;
        mlayoutinflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    static class ViewHolder{
        public ImageView imageview;
        public TextView textView;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       ViewHolder holder = null;
       if(view == null){
           view = mlayoutinflater.inflate(R.layout.layout_grid_item,null);
           holder = new ViewHolder();
           holder.imageview = view.findViewById(R.id.iv_grid);
           holder.textView = view.findViewById(R.id.tv_title);
           view.setTag(holder);
       }
       else{
           holder = (ViewHolder) view.getTag();
       }
       holder.textView.setText("吉林省松原市");
        return view;
    }
}
