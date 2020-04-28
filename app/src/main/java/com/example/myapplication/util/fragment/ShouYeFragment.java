package com.example.myapplication.util.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.myapplication.FileActivity;
import com.example.myapplication.IntentActivity;
import com.example.myapplication.R;
import com.example.myapplication.RuntimePermission.CallActivity;
import com.example.myapplication.UIActivity;
import com.youth.banner.Banner;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.util.BannerUtils;

import java.util.ArrayList;

public class ShouYeFragment extends Fragment {
    private ArrayList<DataModel> mList;
    private Banner<DataModel, ImageAdapter> banner;
    public Button myBtn_UI;
    public Button myBtn_test;
    public Button myBtn_file;
    public Button myBtn_permission;
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
        View view = inflater.inflate(R.layout.shouye, container, false);
        Bundle bundle = getArguments();
        String agrs1 = bundle.getString("args");
        Log.d("fragment", "onCreateView: "+agrs1);
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
        return view;
    }

    public void initView(View view) {
        myBtn_UI = view.findViewById(R.id.btn_ui);
        myBtn_test = view.findViewById(R.id.btn_test);
        myBtn_file = view.findViewById(R.id.file);
        myBtn_permission = view.findViewById(R.id.runtime_permission);

        OnClickListener ol = new OnClickListener();
        myBtn_UI.setOnClickListener(ol);
        myBtn_test.setOnClickListener(ol);
        myBtn_file.setOnClickListener(ol);
        myBtn_permission.setOnClickListener(ol);
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


    }
    class OnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()) {
                case R.id.btn_ui:
                    intent = new Intent(getContext(), UIActivity.class);
                    break;
                case R.id.btn_test:
                    intent = new Intent(getContext(), IntentActivity.class);
                    break;
                case R.id.file:
                    intent = new Intent(getContext(), FileActivity.class);
                    break;
                case R.id.runtime_permission:
                    intent = new Intent(getContext(), CallActivity.class);
                    break;
                default:
            }
            startActivity(intent);
        }
    }


}
