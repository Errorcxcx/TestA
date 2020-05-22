package com.example.myapplication.liandong.model;

public class Case {
    public String name;
    public int nums;
    public String result;

    public Case(String name, int nums, String result) {
        this.name = name;
        this.nums = nums;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
