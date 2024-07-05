package com.example.bookproject;

import java.util.List;

public class AudioBook implements Media {
    private String title;
    private String singer;
    private double price;

    public AudioBook(String title, String author, double price) {
        this.title = title;
        this.singer = author;
        this.price = price;
    }

   @Override
    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }

  @Override
    public double getPrice() {
        return price;
    }
  
@Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String author) {
        this.singer = author;
    }
@Override
    public void displayMediaInfo() {
        System.out.println("AudioBook Title: " + title);
        System.out.println("Singer: " + singer);
        System.out.println("Price: $" + price);
        System.out.println();
    }
}
