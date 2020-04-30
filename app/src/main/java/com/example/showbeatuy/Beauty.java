package com.example.showbeatuy;

import android.graphics.Bitmap;
import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.example.myapplication.BR;

public class Beauty extends BaseObservable {
    public String name;
    public Bitmap bitmap;
    public String age;


    public Beauty(String name, Bitmap bitmap, String age) {
        this.name = name;
        this.bitmap = bitmap;
        this.age = age;
    }

    @Bindable
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);

    }

    @Bindable
    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        notifyPropertyChanged(BR.bitmap);

    }

    @Bindable
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
        notifyPropertyChanged(BR.age);


    }
    @BindingAdapter("android:src")
    public static void setSrc(ImageView view, Bitmap bitmap) {
        view.setImageBitmap(bitmap);
    }
    @BindingAdapter("android:src")
    public static void setImage(ImageView view, String url) {
    }
}
