package com.zhaoqiang.xutils.model;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.Table;

@Table(name = "books")
public class Book {
    @Id   //_id integer primary key autoincrement
    private long _id;
    @Column
    private String title;
    @Column
    private float price;
    @Column
    private String author;

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        this._id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "_id=" + _id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
}
