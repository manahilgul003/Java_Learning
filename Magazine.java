package com.example.bookproject;

import java.util.List;

public class Magazine implements Media {
    private String title;
    private String publisher;
    private double price;

    public Magazine(String title, String publisher, double price) {
        this.title = title;
        this.publisher = publisher;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void displayMediaInfo() {
        System.out.println("Magazine Title: " + title);
        System.out.println("Publisher: " + publisher);
        System.out.println("Price: $" + price);
        System.out.println();
    }
}
