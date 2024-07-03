package com.example.bookproject;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private Metadata metadata;

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public void displayBookInfo() {
        System.out.println("Title of the Book: " + title);
        System.out.println("Author of the Book: " + author);
        System.out.println("Price of "+title+" :" + metadata.getPrice());
        System.out.println("Categories: " + metadata.getCategories());
        System.out.println("International Standard Book Number: " + metadata.getIsbn());
        System.out.println("No.of Pages: " + metadata.getPages());
        System.out.println();
    }
}
