package org.zpf.domain;

import sun.dc.pr.PRError;

import java.io.Serializable;

public class Book implements Serializable {
    private String bookImage;
    private String bookName;
    private String author;
    private double bookPrice;

    public Book(String bookImage, String bookName, String author, double bookPrice) {
        this.bookImage = bookImage;
        this.bookName = bookName;
        this.author = author;
        this.bookPrice = bookPrice;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }
}
