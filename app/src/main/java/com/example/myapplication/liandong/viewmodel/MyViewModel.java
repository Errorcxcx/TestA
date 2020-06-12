package com.example.myapplication.liandong.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.liandong.model.PhoneBrand;

public class MyViewModel extends ViewModel {
    private final MutableLiveData<Integer> selected = new MutableLiveData<>();
    private final MutableLiveData<Integer> selected2 = new MutableLiveData<>();


    public void select(Integer i){
        selected.setValue(i);
    }
    public LiveData<Integer> getSelected(){
        return selected;
    }

    public void select2(Integer i){
        selected2.setValue(i);
    }
    public LiveData<Integer> getSelected2(){
        return selected2;
    }

}
