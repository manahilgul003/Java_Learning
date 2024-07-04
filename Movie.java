package BooksPackage;

import java.io.PrintWriter;

public class Movie implements Media {
    private String title;
    private String director;
    private double price;
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	public String getProductionHouse() {
		return productionHouse;
	}

	public void setProductionHouse(String productionHouse) {
		this.productionHouse = productionHouse;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	private String genre;
    private int yearOfRelease;
    private String productionHouse;
    private double duration;

    public Movie(String title, String director, double price, String genre, int yearOfRelease, String productionHouse, double duration) {
        this.title = title;
        this.director = director;
        this.price = price;
        this.genre = genre;
        this.yearOfRelease = yearOfRelease;
        this.productionHouse = productionHouse;
        this.duration = duration;
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
        System.out.println("Movie Title: " + title);
        System.out.println("Director: " + director);
        System.out.println("Price: $" + price);
        System.out.println("Genre: " + genre);
        System.out.println("Year of Release: " + yearOfRelease);
        System.out.println("Production House: " + productionHouse);
        System.out.println("Duration: " + duration + " hours");
    }

    @Override
    public void displayInfo(PrintWriter writer) {
        writer.println("Movie Title: " + title);
        writer.println("Director: " + director);
        writer.println("Price: $" + price);
        writer.println("Genre: " + genre);
        writer.println("Year of Release: " + yearOfRelease);
        writer.println("Production House: " + productionHouse);
        writer.println("Duration: " + duration + " hours");
    }
}
