package com.example.myapplication.liandong.model;

import java.util.List;

public class PhoneBrand {
    public String name;
    public List<Phone> phoneList;

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public PhoneBrand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
