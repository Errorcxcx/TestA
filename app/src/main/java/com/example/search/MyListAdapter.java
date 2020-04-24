package com.example.search;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.ListAdapter;

import com.example.myapplication.R;

import java.util.List;

public class MyListAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> searchRecordsList;
    private LayoutInflater inflater;
    public MyListAdapter(Context context,List<String> list) {
        searchRecordsList = list;
        mContext = context;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return searchRecordsList ==null?0:searchRecordsList.size();
    }

    @Override
    public Object getItem(int position) {

        return searchRecordsList == null ?0:searchRecordsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    private class ViewHolder{
        TextView textView;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.searchitem,null);
            viewHolder.textView = convertView.findViewById(R.id.search_content_tv);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Log.d("MyAdapter", "getView: "+searchRecordsList.get(position));
        viewHolder.textView.setText(searchRecordsList.get(position));
        return convertView;
    }
}
