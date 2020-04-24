package com.example.notificationbar.aty;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.example.base.BaseAdapter;
import com.example.base.BaseVH;
import com.example.databinding.model.User;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ItemRadioBinding;

import java.util.List;

public class AdapterOne extends BaseAdapter<AdapterOne.AdapterOneViewHolder> {
    private OnClickItemListener mListener;
    private List choosedList;
    public AdapterOne(Context context,List<String> choosedList, OnClickItemListener listener) {
        super(context);
        mListener = listener;
        this.choosedList = choosedList;
    }

    @Override
    public AdapterOneViewHolder onCreateVH(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_radio,parent,false);
        Log.d("daohang", "create: ");

        return new AdapterOneViewHolder(binding);
    }

    @Override
    public void onBindVH(AdapterOneViewHolder holder, int position) {
        ItemRadioBinding binding = (ItemRadioBinding)holder.binding;
        binding.setUsertwo((User) list.get(position));
        Log.d("daohang", "onBindVH: ");
        holder.itemView.setOnClickListener(v -> mListener.onClickItem(position));
    }

    public class AdapterOneViewHolder extends BaseVH{

        public AdapterOneViewHolder(ViewDataBinding binding) {
            super(binding);
        }
    }
    public interface OnClickItemListener {
        void onClickItem(int pos);
    }
}
