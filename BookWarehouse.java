package com.example.bookproject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class BookWarehouse {
    private List<Book> books;

    public BookWarehouse(String jsonFilePath) {
        try (FileReader reader = new FileReader(jsonFilePath)) {
            Type bookListType = new TypeToken<List<Book>>() {}.getType();
            books = new Gson().fromJson(reader, bookListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Display details of all books
    public void display_All() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            books.forEach(Book::displayBookInfo);
        }
    }

    // Find and display books by a specific author
    // Returns true if books are found, false otherwise
    public boolean search_Book_by_Author(String authorName) {
        List<Book> booksByAuthor = books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(authorName))
                .collect(Collectors.toList());

        if (booksByAuthor.isEmpty()) {
            return false;
        } else {
            booksByAuthor.forEach(Book::displayBookInfo);
            return true;
        }
    }

    // Find and display books by a specific category
    // Returns true if books are found, false otherwise
    public boolean search_book_by_category(String category) {
        List<Book> booksByCategory = books.stream()
                .filter(book -> book.getMetadata().getCategories().contains(category))
                .collect(Collectors.toList());

        if (booksByCategory.isEmpty()) {
            return false;
        } else {
            booksByCategory.forEach(Book::displayBookInfo);
            return true;
        }
    }

    // Calculate and display the average price of all books
    public void show_average_price() {
        OptionalDouble average = books.stream()
                .mapToDouble(book -> book.getMetadata().getPrice())
                .average();
        System.out.println("Average Price: " + (average.isPresent() ? average.getAsDouble() : "No books available"));
    }

    // Display the title of the book with the highest price
    public void show_expensive_book() {
        books.stream()
                .max((book1, book2) -> Double.compare(book1.getMetadata().getPrice(), book2.getMetadata().getPrice()))
                .ifPresent(book -> System.out.println("Highest Priced Book Title: " + book.getTitle()));
    }
}
