package com.example.search;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.notificationbar.aty.AdapterOne;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.internal.operators.single.SingleZipIterable;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView recordsListLv;
    private TextView clearAllRecordsTv;
    private LinearLayout searchRecordsLl;
    private List<String> searchRecordsList;
    private List<String> tempList;
    private EditText searchContentEt;
    private View recordsHistoryView;
    private MyListAdapter adapterOne;
    private MyDao myDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        initView();
        initData();
        bindAdapter();
        initListener();
    }

    private void initView(){

        initRecordsView();
        searchRecordsLl = (LinearLayout)findViewById(R.id.search_content_show_ll);
        searchContentEt = (EditText)findViewById(R.id.input_search_content_et);
        searchRecordsLl.addView(recordsHistoryView);

    }
    private void bindAdapter() {
        adapterOne = new MyListAdapter(this, searchRecordsList);
        recordsListLv.setAdapter(adapterOne);
    }
    private void initRecordsView(){
        recordsHistoryView = LayoutInflater.from(this).inflate(R.layout.recordslayout,null);
        recordsListLv = recordsHistoryView.findViewById(R.id.search_records_lv);
        clearAllRecordsTv = recordsHistoryView.findViewById(R.id.clear_all_records_tv);
    }


    private void initData(){
        myDao = new MyDao(this);
        searchRecordsList = new ArrayList<>();
        tempList = new ArrayList<>();
        resersedList();

        checkRecordsSize();

    }
    private void initListener(){
        clearAllRecordsTv.setOnClickListener(this);
        searchContentEt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH){
                    if(searchContentEt.getText().toString().length()>0){
                        String record = searchContentEt.getText().toString();
                        if(!myDao.isHasRecord(record)){
                            tempList.add(record);
                        }
                        myDao.addRecords(record);
                        Log.d("MyAdapter", "onEditorAction: ");
                        resersedList();
                        checkRecordsSize();
                        adapterOne.notifyDataSetChanged();
                    }else {
                    }
                }
                return false;
            }
        });
        searchContentEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String tempName = searchContentEt.getText().toString();
                tempList.clear();
                tempList.addAll(myDao.querySimlarRecord(tempName));
                resersedList();
                checkRecordsSize();
                Log.d("MyAdapter", "afterTextChanged: "+searchRecordsList.size());

                adapterOne.notifyDataSetChanged();
            }
        });
        //历史记录点击事件
        recordsListLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //将获取到的字符串传到搜索结果界面

            }
        });

    }
    private void checkRecordsSize(){
        if(searchRecordsList.size() == 0){
            Log.d("MyAdapter", "checkRecordsSize: "+searchRecordsList.size());
            searchRecordsLl.setVisibility(View.GONE);
        }else {
            searchRecordsLl.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.clear_all_records_tv:
                tempList.clear();
                resersedList();
                myDao.deleteAllRecords();
                adapterOne.notifyDataSetChanged();
                searchRecordsLl.setVisibility(View.GONE);
                break;
        }
    }

    private void resersedList(){
        searchRecordsList.clear();
        for(int i = tempList.size()-1;i>=0;i--){
            Log.d("MyAdapter", "resersedList:"+tempList.get(i));
            searchRecordsList.add(tempList.get(i));
            if (searchRecordsList.size()>6){
                break;
            }
        }
    }
}
