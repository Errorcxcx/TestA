package com.example.myapplication.util.fragment;

import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

public  class ImageAdapter extends BannerAdapter<DataModel,ImageAdapter.BannerViewHolder> {
    public ImageAdapter(List<DataModel> list) {
        super(list);

    }


    @Override
    public void onBindView(BannerViewHolder holder, DataModel data, int position, int size) {
        holder.imageView.setImageResource(data.imageRes);
//        holder.imageView.setImageResource(data.imageRes[1]);
//        holder.imageView.setImageResource(data.imageRes[2]);
//        holder.imageView.setImageResource(data.imageRes[3]);


    }

    /**
     * 创建ViewHolder
     *
     * @param parent
     * @param viewType
     * @return XViewHolder
     */
    @Override
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {

        ImageView imageView = new ImageView(parent.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new BannerViewHolder(imageView);
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public BannerViewHolder(@NonNull ImageView view) {
            super(view);
            this.imageView = view;
        }
    }
}