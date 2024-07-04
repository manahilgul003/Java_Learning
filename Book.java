package BooksPackage;

import java.io.PrintWriter;

public class Book implements Media {
    private String title;
    private String author;
    private double price;
    private String category;
    private String isbn;

    public Book(String title, String author, double price, String category, String isbn) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.category = category;
        this.isbn = isbn;
    }
public String getTitle() {
	return this.title;
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
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
	@Override
    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Category: " + category);
        System.out.println("ISBN: " + isbn);
    }

    @Override
    public void displayInfo(PrintWriter writer) {
        writer.println("Book Title: " + title);
        writer.println("Author: " + author);
        writer.println("Price: $" + price);
        writer.println("Category: " + category);
        writer.println("ISBN: " + isbn);
    }
}
