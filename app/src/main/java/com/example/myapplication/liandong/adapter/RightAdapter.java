package com.example.myapplication.liandong.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.base.BaseAdapter;
import com.example.base.BaseVH;
import com.example.myapplication.R;
import com.example.myapplication.liandong.model.Phone;
import com.example.myapplication.liandong.model.PhoneBrand;

import java.util.ArrayList;
import java.util.List;

public class RightAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int MENU_TYPE = 0;
    private final int Phone_TYPE = 1;

    public Context mContext;
    public int mItemCount;

    public List<PhoneBrand> mMenuList;
    public RightAdapter(Context context, ArrayList<PhoneBrand> mMenuList) {
        mContext = context;
        this.mMenuList = mMenuList;
        this.mItemCount = mMenuList.size();
        for(PhoneBrand phoneBrand : mMenuList){
            mItemCount+=phoneBrand.getPhoneList().size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        int sum = 0;
        for(PhoneBrand phoneBrand:mMenuList){
            if(position ==sum){
                return MENU_TYPE;
            }
            sum+=phoneBrand.getPhoneList().size()+1;
        }
        return Phone_TYPE;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == MENU_TYPE){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.right_menu_item, parent, false);
            MenuViewHolder viewHolder = new MenuViewHolder(view);
            return viewHolder;
        }else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_right_fram,parent,false);
            RightViewHolder viewHolder = new RightViewHolder(view);
            return viewHolder;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == MENU_TYPE){
            MenuViewHolder menuViewHolder = (MenuViewHolder)holder;
            if(menuViewHolder!=null){
                menuViewHolder.right_menu_title.setText(getMenuByPosition(position).getName());
                menuViewHolder.right_menu_layout.setContentDescription(position+"");
            }
        }else {
            final RightViewHolder rightViewHolder = (RightViewHolder)holder;
            if(rightViewHolder!=null){
                final P
                rightViewHolder.right_phone_name_tv.setText();
            }
        }
    }

    public Phone getPhoneByPosition(int position){
        for(PhoneBrand phoneBrand : mMenuList){
            if(position>0 && position <= phoneBrand.getPhoneList().size()){
                return phoneBrand.getPhoneList().get(position-1);
            }else {
                position -=phoneBrand.getPhoneList().size()+1;
            }
        }
        return null;
    }

    public void setDatas(List list){
        mMenuList = list;
    }
    @Override
    public int getItemCount() {
        return mItemCount;
    }

    public PhoneBrand getMenuByPosition(int position){
        int sum = 0;
        for(PhoneBrand phoneBrand : mMenuList){
            if(sum == position){
                return phoneBrand;
            }
            sum = phoneBrand.getPhoneList().size()+1;
        }
        return null;
    }

    private class MenuViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout right_menu_layout;
        private TextView right_menu_title;

        public MenuViewHolder( View itemView) {
            super(itemView);
            right_menu_layout =(LinearLayout)itemView.findViewById(R.id.right_menu_item);
            right_menu_title = (TextView)itemView.findViewById(R.id.right_menu_tv);
        }
    }


    public class RightViewHolder extends RecyclerView.ViewHolder {
        private TextView right_phone_name_tv;
        private TextView right_phone_price_tv;

        public RightViewHolder(@NonNull View itemView) {
            super(itemView);
            right_phone_name_tv = (TextView)itemView.findViewById(R.id.rv_r_name);
            right_phone_price_tv = (TextView)itemView.findViewById(R.id.rv_v_price);
        }
    }
}
