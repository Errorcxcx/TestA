package com.example.retrofit;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.example.myapplication.BR;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.List;

public class InfoGson extends BaseObservable {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public InfoGson(String _id, String author, String category, String createdAt, String desc, List images, String likeCounts, String publishedAt, String stars, String type, String url, String views, String title) {
        this._id = _id;
        this.author = author;
        this.category = category;
        this.createdAt = createdAt;
        this.desc = desc;
        this.images = images;
        this.likeCounts = likeCounts;
        this.publishedAt = publishedAt;
        this.stars = stars;
        this.type = type;
        this.url = url;
        this.views = views;
        this.title = title;
    }

    private String _id;
    private String author;
    private String category;
    private String createdAt;
    private String desc;
    private List images;
    private String likeCounts;
    private String publishedAt;
    private String stars;
    private String type;
    private String url;
    private String views;
    private String title;

    @Bindable
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
        notifyPropertyChanged(BR._id);
    }

    @Override
    public String toString() {
        return "Info{" +
                "_id='" + _id + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", desc='" + desc + '\'' +
                ", images='" + images + '\'' +
                ", likeCounts='" + likeCounts + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", stars='" + stars + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", views='" + views + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    @Bindable
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
        notifyPropertyChanged(BR.author);

    }

    @Bindable
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
        notifyPropertyChanged(BR.category);

    }

    @Bindable
    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        notifyPropertyChanged(BR.createdAt);

    }

    @Bindable
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
        notifyPropertyChanged(BR.desc);

    }

    @Bindable
    public List getImages() {
        return images;
    }

    public void setImages(List images) {
        this.images = images;
        notifyPropertyChanged(BR.images);

    }
    @Bindable
    public String getLikeCounts() {
        return likeCounts;
    }

    public void setLikeCounts(String likeCounts) {
        this.likeCounts = likeCounts;
        notifyPropertyChanged(BR.likeCounts);

    }

    @Bindable
    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
        notifyPropertyChanged(BR.publishedAt);

    }


    @Bindable
    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
        notifyPropertyChanged(BR.stars);

    }

    @Bindable
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        notifyPropertyChanged(BR.type);

    }

    @Bindable
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        notifyPropertyChanged(BR.url);

    }

    @Bindable
    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
        notifyPropertyChanged(BR.views);

    }

    @BindingAdapter({"app:imageUrl"})
    public static  void loadImage(ImageView view,String url){
        Glide.with(view.getContext())
                .load(url)
                .transform(new FillSpace())
                .into(view);
    }
//    public static class TransformationUtils extends ImageViewTarget<Bitmap> {
//        private ImageView target;
//        public TransformationUtils(ImageView target) {
//            super(target);
//            this.target = target;
//        }
//        @Override
//        protected void setResource(Bitmap resource) {
//            view.setImageBitmap(resource);
//            //获取原图的宽高
//            int width = resource.getWidth();
//            int height = resource.getHeight();
//            //获取imageView的宽
//            int imageViewWidth = target.getWidth();
//            //计算缩放比例
//            float sy = (float) (imageViewWidth * 0.1) / (float) (width * 0.1);
//            //计算图片等比例放大后的高
//            int imageViewHeight = (int) (height * sy);
//            ViewGroup.LayoutParams params = target.getLayoutParams();
//            params.height = imageViewHeight;
//            target.setLayoutParams(params);
//        }
//    }
static class FillSpace extends BitmapTransformation {
    @Override
    public Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        Canvas canvas = new Canvas(toTransform);
        BitmapShader bitmapShader = new BitmapShader(toTransform, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        int min = Math.min(toTransform.getWidth(), toTransform.getHeight());
        int radius = min / 2;
        RadialGradient radialGradient = new RadialGradient(toTransform.getWidth() / 2 , toTransform.getHeight() / 2, radius, Color.TRANSPARENT, Color.WHITE, Shader.TileMode.CLAMP);
        ComposeShader composeShader = new ComposeShader(bitmapShader, radialGradient, PorterDuff.Mode.SRC_OVER);
        Paint paint = new Paint();
        paint.setShader(composeShader);
        canvas.drawRect(0, 0, toTransform.getWidth()/10, toTransform.getHeight()/10, paint);
        return toTransform;
    }

    @Override
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {

    }

    @Override
    public boolean equals(Object o) {
        return o instanceof FillSpace;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
}
