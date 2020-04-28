package com.example.retrofit;

import java.util.List;

public class InfoGson {
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


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List getImages() {
        return images;
    }

    public void setImages(List images) {
        this.images = images;
    }

    public String getLikeCounts() {
        return likeCounts;
    }

    public void setLikeCounts(String likeCounts) {
        this.likeCounts = likeCounts;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }
}
