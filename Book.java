package com.example.bookproject;

import java.util.List;

public class Book implements Media {
    private String title;
    private String author;
    private Metadata metadata;

    public Book(String title, String author, Metadata metadata) {
        this.title = title;
        this.author = author;
        this.metadata = metadata;
    }

    @Override
    public void updatePrice(double newPrice) {
        metadata.setPrice(newPrice);
    }

    @Override
    public double getPrice() {
        return metadata.getPrice();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void displayMediaInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + metadata.getPrice());
        System.out.println("Categories: " + metadata.getCategories());
        System.out.println("ISBN: " + metadata.getIsbn());
        System.out.println("Pages: " + metadata.getPages());
    }
}