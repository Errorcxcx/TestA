package com.example.myapplication.liandong.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.R;
import com.example.myapplication.liandong.adapter.ImageAdapter;
import com.example.myapplication.liandong.model.DataModel;
import com.youth.banner.Banner;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.transformer.DepthPageTransformer;
import com.youth.banner.util.BannerUtils;

import java.util.ArrayList;
import java.util.List;

public class ShouYeFragment extends Fragment {
    private ArrayList<DataModel> mList;
    private Banner<DataModel, ImageAdapter> banner;
    private SYLeftFragment syLeftFragment;
    private SYRightFragment syRightFragment;
    public static ShouYeFragment newInstance(String param) {
        ShouYeFragment shouYeFragment = new ShouYeFragment();
        Bundle args = new Bundle();
        args.putString("args", param);
        shouYeFragment.setArguments(args);

        return shouYeFragment;
    }

    public ShouYeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shou_ye, container, false);
        Bundle bundle = getArguments();
        String agrs1 = bundle.getString("agrs1");
        mList = new ArrayList();
        DataModel dataModelone = new DataModel(R.drawable.banner1);
        DataModel dataModeltwo = new DataModel(R.drawable.banner2);
        DataModel dataModelthree = new DataModel(R.drawable.banner3);
        DataModel dataModelfour = new DataModel(R.drawable.banner4);
        mList.add(dataModelone);
        mList.add(dataModeltwo);
        mList.add(dataModelthree);
        mList.add(dataModelfour);
        initView(view);
        bindViews(view);


        return view;
    }

    public void initView(View view) {

        banner = view.findViewById(R.id.banner);
        banner.setAdapter(new ImageAdapter(mList));
        banner.setIndicator(new CircleIndicator(getContext()));
        banner.setIndicatorSelectedColorRes(R.color.blue);
        banner.setIndicatorNormalColorRes(R.color.white);
        banner.setIndicatorGravity(IndicatorConfig.Direction.CENTER);
        banner.setIndicatorMargins(new IndicatorConfig.Margins((int) BannerUtils.dp2px(10)));
        banner.setIndicatorWidth(10, 20);
        banner.setIndicatorSpace((int) BannerUtils.dp2px(20));
        banner.setIndicatorWidth(10,20);
//        banner.addItemDecoration(new MarginItemDecoration((int) BannerUtils.dp2px(50)));
//        banner.setPageTransformer(new DepthPageTransformer());
//        banner.setOnBannerListener(this);
//        banner.addOnPageChangeListener(this);
        banner.start();
        syLeftFragment = new SYLeftFragment();
        syRightFragment = new SYRightFragment();
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.left_frag,syLeftFragment);
        transaction.replace(R.id.right_frag,syRightFragment);
        transaction.commit();

    }

    public void bindViews(View view) {
    }

}
