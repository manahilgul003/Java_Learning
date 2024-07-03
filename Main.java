package com.example.bookproject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String jsonFilePath = "src/main/resources/books.json";
        BookWarehouse bookWarehouse = new BookWarehouse(jsonFilePath);
        Scanner scanner = new Scanner(System.in);

        System.out.println("*********WELCOME TO THE BOOK WAREHOUSE***************\n");

        boolean exit = false;
        while (!exit) {
            System.out.println("Please select an option:");
            System.out.println("1. View full list of books");
            System.out.println("2. Search books by author");
            System.out.println("3. Search books by category");
            System.out.println("4. View average price of books");
            System.out.println("5. View title of the book with the highest price");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\nList of all Books is as follows:\n");
                    bookWarehouse.display_All();
                    System.out.println("\n");
                    break;
                case 2:
                    System.out.print("Enter the author you want to search for: ");
                    String author = scanner.nextLine();
                    boolean foundAuthor = bookWarehouse.search_Book_by_Author(author);
                    if (foundAuthor) {
                        System.out.println("Books by " + author + " are as follows:\n");
                        bookWarehouse.search_Book_by_Author(author);
                    } else {
                        System.out.println("Author not found.");
                    }
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.print("Enter the category you want to search for: ");
                    String category = scanner.nextLine();
                    boolean foundCategory = bookWarehouse.search_book_by_category(category);
                    if (foundCategory) {
                        System.out.println("Books in the '" + category + "' category:\n");
                        bookWarehouse.search_book_by_category(category);
                    } else {
                        System.out.println("Category not found.");
                    }
                    System.out.println("\n");
                    break;
                case 4:
                    System.out.println("Average price of the books is as follows:");
                    bookWarehouse.show_average_price();
                    System.out.println("\n");
                    break;
                case 5:
                    System.out.println("Title of the book with the highest price is as follows:");
                    bookWarehouse.show_expensive_book();
                    System.out.println("\n");
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting the Book Warehouse. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }

        scanner.close();
    }
}
