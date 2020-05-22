package com.example.myapplication.liandong.model;

import java.util.List;

public class SortBean {
    public String Type;
    public List<ListBean> list;

    public class ListBean{
        public String color;
        public String name;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

}
