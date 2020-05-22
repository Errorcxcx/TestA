package com.example.myapplication.liandong.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.liandong.model.Case;


import java.util.List;

public class MyViewModel extends ViewModel {
    private final MutableLiveData<Case> selected = new MutableLiveData<>();

    public void select(Case c){
        selected.setValue(c);
    }
    public LiveData<Case> getSelected(){
        return selected;
    }
}
