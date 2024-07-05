package com.example.bookproject;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String jsonFilePath = "src/main/resources/media.json"; // Make sure this path is correct
        Library<Media> library = new Library<>(jsonFilePath);
        Scanner scanner = new Scanner(System.in);

        // Adding an observer
        library.addObserver(event -> {
            System.out.println("Event: " + event.getEventType());
            event.getMedia().displayMediaInfo();
        });

        System.out.println("*********WELCOME TO THE MEDIA LIBRARY***************\n");

        boolean exit = false;
        while (!exit) {
            System.out.println("Please select an option:");
            System.out.println("1. View full list of media");
            System.out.println("2. Add a new book");
            System.out.println("3. Add a new movie");
            System.out.println("4. Add a new audiobook");
            System.out.println("5. Add a new magazine");
            System.out.println("6. Update media price");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\nList of all media is as follows:\n");
                    library.displayAllMedia();
                    System.out.println("\n");
                    break;
                case 2:
                    System.out.print("Enter the title of the book: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter the author of the book: ");
                    String bookAuthor = scanner.nextLine();
                    System.out.print("Enter the price of the book: ");
                    double bookPrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter the categories of the book (comma separated): ");
                    String bookCategories = scanner.nextLine();
                    System.out.print("Enter the ISBN of the book: ");
                    String bookIsbn = scanner.nextLine();
                    System.out.print("Enter the number of pages: ");
                    int bookPages = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Book newBook = new Book(bookTitle, bookAuthor, new Metadata(bookPrice, Arrays.asList(bookCategories.split(",")), bookIsbn, bookPages));
                    library.addMedia(newBook);
                    library.saveToJson(jsonFilePath);
                    break;
                case 3:
                    System.out.print("Enter the title of the movie: ");
                    String movieTitle = scanner.nextLine();
                    System.out.print("Enter the director of the movie: ");
                    String movieDirector = scanner.nextLine();
                    System.out.print("Enter the price of the movie: ");
                    double moviePrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    Movie newMovie = new Movie(movieTitle, movieDirector, moviePrice);
                    library.addMedia(newMovie);
                    library.saveToJson(jsonFilePath);
                    break;
                case 4:
                    System.out.print("Enter the title of the audiobook: ");
                    String audiobookTitle = scanner.nextLine();
                    System.out.print("Enter the Singer of the audiobook: ");
                    String audiobookSinger = scanner.nextLine();
                    System.out.print("Enter the price of the audiobook: ");
                    double audiobookPrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    AudioBook newAB = new AudioBook(audiobookTitle, audiobookSinger, audiobookPrice);
                    library.addMedia(newAB);
                    library.saveToJson(jsonFilePath);
                    break;
                case 5:
                    System.out.print("Enter the title of the magazine: ");
                    String magazineTitle = scanner.nextLine();
                    System.out.print("Enter the publisher of the magazine: ");
                    String magazinePublisher = scanner.nextLine();
                    System.out.print("Enter the price of the magazine: ");
                    double magazinePrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    Magazine newMagazine = new Magazine(magazineTitle, magazinePublisher, magazinePrice);
                    library.addMedia(newMagazine);
                    library.saveToJson(jsonFilePath);
                    break;
                case 6:
                    System.out.print("Enter the title of the media to update the price: ");
                    String mediaTitle = scanner.nextLine();
                    System.out.print("Enter the new price: ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    library.updateMediaPrice(mediaTitle, newPrice);
                    library.saveToJson(jsonFilePath);
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting the Media Library. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }

        scanner.close();
    }
}
