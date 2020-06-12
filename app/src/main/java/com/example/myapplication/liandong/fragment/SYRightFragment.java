package com.example.myapplication.liandong.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.liandong.adapter.RightAdapter;
import com.example.myapplication.liandong.model.PhoneBrand;
import com.example.myapplication.liandong.model.PhoneList;
import com.example.myapplication.liandong.viewmodel.MyViewModel;


public class SYRightFragment extends Fragment {

    private MyViewModel model;
    private TextView textView;
    private RecyclerView recyclerView;
    private RightAdapter rightAdapter;
    private LinearLayoutManager linearLayoutManager;
    private LinearLayout headerLayout;
    private PhoneBrand phoneBrand;
    private TextView headerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new ViewModelProvider(getActivity()).get(MyViewModel.class);
        model.getSelected().observe(this, aCase -> {
            linearLayoutManager.scrollToPositionWithOffset(aCase, 0);
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_right, container, false);
        View view1 = inflater.inflate(R.layout.right_menu_item, container, false);
        headerLayout = view1.findViewById(R.id.right_menu_item);
        headerView = view1.findViewById(R.id.right_menu_tv);
        bindViews(view);

        return view;
    }

    public void bindViews(View view) {
        recyclerView = view.findViewById(R.id.right_frag_rv);
        rightAdapter = new RightAdapter(getContext(), PhoneList.getInstance().list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Log.d("weizhi", "onBindViewHolder: " + PhoneList.getInstance().list.get(2));

        recyclerView.setAdapter(rightAdapter);

        linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (recyclerView.canScrollHorizontally(1) == false) {
                    Log.d("liandong", "onScrolled: 默认");
                    showHeadView();
                }
                View underView = null;
                if (dy > 0) {
                    underView = recyclerView.findChildViewUnder(headerLayout.getX(), headerLayout.getMeasuredHeight() + 1);
                } else {
                    underView = recyclerView.findChildViewUnder(headerLayout.getX(), 0);
                }
                if (underView != null && underView.getContentDescription() != null) {
                    Log.d("liandong", "onScrolled: ");
                    int position = Integer.parseInt(underView.getContentDescription().toString());
                    PhoneBrand brand = rightAdapter.getPhoneBrandByPosition(position);
                    if (dy > 0 && headerLayout.getTranslationY() <= 1 && headerLayout.getTranslationY() >= -1 * headerLayout.getMeasuredHeight() * 4 / 5) {// underView.getTop()>9
                        int dealtY = underView.getTop() - headerLayout.getMeasuredHeight();
                        headerLayout.setTranslationY(dealtY);
//                            Log.e(TAG, "onScrolled: "+headerLayout.getTranslationY()+"   "+headerLayout.getBottom()+"  -  "+headerLayout.getMeasuredHeight() );
                    } else if (dy < 0 && headerLayout.getTranslationY() <= 0) {
                        headerView.setText(brand.getName());
                        int dealtY = underView.getBottom() - headerLayout.getMeasuredHeight();
                        headerLayout.setTranslationY(dealtY);
//                            Log.e(TAG, "onScrolled: "+headerLayout.getTranslationY()+"   "+headerLayout.getBottom()+"  -  "+headerLayout.getMeasuredHeight() );
                    } else {
                        headerLayout.setTranslationY(0);
                        phoneBrand = brand;
                        headerView.setText(phoneBrand.getName());
                        for (int i = 0; i < PhoneList.getInstance().list.size(); i++) {
                            if (PhoneList.getInstance().list.get(i) == phoneBrand) {
                                model.select2(i);
                                break;
                            }
                        }

                    }
                }
            }
        });
        initHeadView();

    }

    private void initHeadView() {
        phoneBrand = rightAdapter.getMenuByPosition(0);
        headerLayout.setContentDescription("0");
        headerView.setText(phoneBrand.getName());
    }

    private void showHeadView() {
        headerLayout.setTranslationY(0);
        View underView = recyclerView.findChildViewUnder(headerView.getX(), 0);
        Log.d("liandong", "showHeadView: ");
        if (underView != null && underView.getContentDescription() != null) {
            int position = Integer.parseInt(underView.getContentDescription().toString());
            PhoneBrand phoneBrand1 = rightAdapter.getPhoneBrandByPosition(position + 1);
            phoneBrand = phoneBrand1;
            headerView.setText(phoneBrand.getName());
            for (int i = 0; i < PhoneList.getInstance().list.size(); i++) {
                if (PhoneList.getInstance().list.get(i) == phoneBrand) {
                    model.select2(i);
                }
            }
        }

    }
}
