package com.example.myapplication.util;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.example.myapplication.R;

import java.util.List;
import java.util.zip.Inflater;

public class ButtonListAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<String> mList;
    private MyOnClickLietener myOnClickLietener;
    public int i = 0;
    private Context mContext;

    public ButtonListAdapter(Context context, List list, MyOnClickLietener listener) {
        mContext = context;
        mList = list;
        myOnClickLietener = listener;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList == null ? null : mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder {
        Button button;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        Log.d("listviewadapter", "getView:331111111111111"+convertView);

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.buttonlitm,null);
            holder.button = convertView.findViewById(R.id.btn_listview);
            convertView.setTag(holder);
            Log.d("listviewadapter", "getView: aaaa55555555555aaa");


        } else {
            Log.d("listviewadapter", "getView: aaaa5666666666665aaa");

            holder = (ViewHolder) convertView.getTag();
        }

        Log.d("listviewadapter", "getView: aaaaaaaaaaaaa"+position+"-----"+i++);
        holder.button.setTag(position);
        holder.button.setText(mList.get(position));
        holder.button.setOnClickListener(myOnClickLietener);
        return convertView;
    }

    public abstract static class MyOnClickLietener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            myOnclick((Integer) v.getTag(), v);
        }

        public abstract void myOnclick(int position, View view);
    }
}
