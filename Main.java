package BooksPackage;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library<Media> library = new Library<>();
        MediaNotification notification = new MediaNotification();
        library.addObserver(notification);

        Scanner scanner = new Scanner(System.in);

        // Read media information from file if it exists
        File inputFile = new File("media_input.txt");
        if (inputFile.exists()) {
            try (Scanner fileScanner = new Scanner(inputFile)) {
                while (fileScanner.hasNextLine()) {
                    String mediaType = fileScanner.nextLine();
                    switch (mediaType) {
                        case "Book":
                            String title = fileScanner.nextLine();
                            String author = fileScanner.nextLine();
                            double price = Double.parseDouble(fileScanner.nextLine());
                            String category = fileScanner.nextLine();
                            String isbn = fileScanner.nextLine();
                            library.addMedia(new Book(title, author, price, category, isbn));
                            break;
                        case "Movie":
                            String movieTitle = fileScanner.nextLine();
                            String director = fileScanner.nextLine();
                            double moviePrice = Double.parseDouble(fileScanner.nextLine());
                            String genre = fileScanner.nextLine();
                            int year = Integer.parseInt(fileScanner.nextLine());
                            String productionHouse = fileScanner.nextLine();
                            double duration = Double.parseDouble(fileScanner.nextLine()); // Parse as double
                            library.addMedia(new Movie(movieTitle, director, moviePrice, genre, year, productionHouse, duration));
                            break;

                        case "AudioBook":
                            String audioBookTitle = fileScanner.nextLine();
                            String audioAuthor = fileScanner.nextLine();
                            double audioPrice = Double.parseDouble(fileScanner.nextLine());
                            double durationHours = Double.parseDouble(fileScanner.nextLine());
                            String singerName = fileScanner.nextLine();
                            String audioProductionHouse = fileScanner.nextLine();
                            int audioYear = Integer.parseInt(fileScanner.nextLine());
                            library.addMedia(new AudioBook(audioBookTitle, audioAuthor, audioPrice, durationHours, singerName, audioProductionHouse, audioYear));
                            break;
                        case "Magazine":
                            String magazineTitle = fileScanner.nextLine();
                            String publisher = fileScanner.nextLine();
                            String writer = fileScanner.nextLine(); // Ensure correct variable name
                            double magazinePrice = Double.parseDouble(fileScanner.nextLine());
                            int issueNumber = Integer.parseInt(fileScanner.nextLine());
                            int numberOfPages = Integer.parseInt(fileScanner.nextLine());
                            String language = fileScanner.nextLine();
                            library.addMedia(new Magazine(magazineTitle, publisher, writer, magazinePrice, issueNumber, numberOfPages, language));
                            break;

                        default:
                            System.out.println("Unexpected media type in media_input.txt.");
                            break;
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error: Could not read from media_input.txt.");
            }
        }

        while (true) {
            System.out.println("Enter media type (Book, Movie, AudioBook, Magazine) or 'exit' to stop:");
            String mediaType = scanner.nextLine();

            if (mediaType.equalsIgnoreCase("exit")) {
                break;
            }

            Media media = null;
            switch (mediaType.toLowerCase()) {
                case "book":
                    media = createBook(scanner);
                    break;
                case "movie":
                    media = createMovie(scanner);
                    break;
                case "audiobook":
                    media = createAudioBook(scanner);
                    break;
                case "magazine":
                    media = createMagazine(scanner);
                    break;
                default:
                    System.out.println("");
                    continue;
            }

            if (media != null) {
                library.addMedia(media);
            }

            library.displayAllMedia();
        }

        while (true) {
            System.out.println("Do you want to update the price of a book? (yes/no)");
            String updateResponse = scanner.nextLine();

            if (updateResponse.equalsIgnoreCase("no")) {
                break;
            } else if (updateResponse.equalsIgnoreCase("yes")) {
                System.out.println("Enter book title:");
                String bookTitle = scanner.nextLine();
                System.out.println("Enter new price:");
                double newPrice = Double.parseDouble(scanner.nextLine());

                // Find the book in the library and update its price
                for (Media media : library.getAllMedia()) {
                    if (media instanceof Book && ((Book) media).getTitle().equalsIgnoreCase(bookTitle)) {
                        library.updateMediaPrice((Book) media, newPrice);
                        break; // Exit loop once updated
                    }
                }
            } else {
                System.out.println("Invalid response. Please enter 'yes' or 'no'.");
            }

            library.displayAllMedia();
        }

        scanner.close();
        saveMediaToFile(library);
    }

    private static Book createBook(Scanner scanner) {
        System.out.println("Enter book title:");
        String title = scanner.nextLine();
        System.out.println("Enter book author:");
        String author = scanner.nextLine();
        System.out.println("Enter book price:");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter book category:");
        String category = scanner.nextLine();
        System.out.println("Enter book ISBN:");
        String isbn = scanner.nextLine();
        return new Book(title, author, price, category, isbn);
    }

    private static Movie createMovie(Scanner scanner) {
        System.out.println("Enter movie title:");
        String title = scanner.nextLine();
        System.out.println("Enter movie director:");
        String director = scanner.nextLine();
        System.out.println("Enter movie price:");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter movie genre:");
        String genre = scanner.nextLine();
        System.out.println("Enter movie release year:");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter movie production house:");
        String productionHouse = scanner.nextLine();
        System.out.println("Enter movie duration (in minutes):");
        int duration = Integer.parseInt(scanner.nextLine());
        return new Movie(title, director, price, genre, year, productionHouse, duration);
    }

    private static AudioBook createAudioBook(Scanner scanner) {
        System.out.println("Enter audiobook title:");
        String title = scanner.nextLine();
        System.out.println("Enter audiobook author:");
        String author = scanner.nextLine();
        System.out.println("Enter audiobook price:");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter audiobook duration (in hours):");
        int durationHours = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter audiobook singer name:");
        String singerName = scanner.nextLine();
        System.out.println("Enter audiobook production house:");
        String productionHouse = scanner.nextLine();
        System.out.println("Enter audiobook release year:");
        int year = Integer.parseInt(scanner.nextLine());
        return new AudioBook(title, author, price, durationHours, singerName, productionHouse, year);
    }

    private static Magazine createMagazine(Scanner scanner) {
        System.out.println("Enter magazine title:");
        String title = scanner.nextLine();
        System.out.println("Enter magazine publisher:");
        String publisher = scanner.nextLine();
        System.out.println("Enter magazine writer:");
        String writer = scanner.nextLine();
        System.out.println("Enter magazine price:");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter magazine issue number:");
        int issueNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter magazine number of pages:");
        int numberOfPages = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter magazine language:");
        String language = scanner.nextLine();
        return new Magazine(title, publisher, writer, price, issueNumber, numberOfPages, language);
    }

    private static void saveMediaToFile(Library<Media> library) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("media_input.txt"))) {
            for (Media media : library.getAllMedia()) {
                if (media instanceof Book) {
                    writer.println("Book");
                    writer.println(((Book) media).getTitle());
                    writer.println(((Book) media).getAuthor());
                    writer.println(((Book) media).getPrice());
                    writer.println(((Book) media).getCategory());
                    writer.println(((Book) media).getIsbn());
                } else if (media instanceof Movie) {
                    writer.println("Movie");
                    writer.println(((Movie) media).getTitle());
                    writer.println(((Movie) media).getDirector());
                    writer.println(((Movie) media).getPrice());
                    writer.println(((Movie) media).getGenre());
                    writer.println(((Movie) media).getYearOfRelease());
                    writer.println(((Movie) media).getProductionHouse());
                    writer.println(((Movie) media).getDuration());
                } else if (media instanceof AudioBook) {
                    writer.println("AudioBook");
                    writer.println(((AudioBook) media).getTitle());
                    writer.println(((AudioBook) media).getAuthor());
                    writer.println(((AudioBook) media).getPrice());
                    writer.println(((AudioBook) media).getDuration());
                    writer.println(((AudioBook) media).getSingerName());
                    writer.println(((AudioBook) media).getProductionHouse());
                    writer.println(((AudioBook) media).getYearOfRelease());
                } else if (media instanceof Magazine) {
                    writer.println("Magazine");
                    writer.println(((Magazine) media).getTitle());
                    writer.println(((Magazine) media).getPublisher());
                    writer.println(((Magazine) media).getWriter());
                    writer.println(((Magazine) media).getPrice());
                    writer.println(((Magazine) media).getIssueNumber());
                    writer.println(((Magazine) media).getNumberOfPages());
                    writer.println(((Magazine) media).getLanguage());
                }
                writer.println("--------------------------------------------------");
            }
            System.out.println("Media information has been saved to media_input.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while saving media information to the file.");
            e.printStackTrace();
        }
    

      
    }
}
