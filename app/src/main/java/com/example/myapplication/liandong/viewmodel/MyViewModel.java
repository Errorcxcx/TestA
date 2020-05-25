package com.example.myapplication.liandong.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.liandong.model.PhoneBrand;

public class MyViewModel extends ViewModel {
    private final MutableLiveData<PhoneBrand> selected = new MutableLiveData<>();

    public void select(PhoneBrand c){
        selected.setValue(c);
    }
    public LiveData<PhoneBrand> getSelected(){
        return selected;
    }
}
