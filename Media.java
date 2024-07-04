package BooksPackage;

import java.io.PrintWriter;

public interface Media {
    void updatePrice(double newPrice);
    double getPrice();
    void displayInfo();
    void displayInfo(PrintWriter writer); // New method signature for writing to file
}
