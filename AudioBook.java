package BooksPackage;

import java.io.PrintWriter;

public class AudioBook implements Media {
    private String title;
    private String author;
    private double price;
    private double duration;
    private String singerName;
    private String productionHouse;
    private int yearOfRelease;

    public AudioBook(String title, String author, double price, double duration, String singerName, String productionHouse, int yearOfRelease) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.duration = duration;
        this.singerName = singerName;
        this.productionHouse = productionHouse;
        this.yearOfRelease = yearOfRelease;
    }

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

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	public String getProductionHouse() {
		return productionHouse;
	}

	public void setProductionHouse(String productionHouse) {
		this.productionHouse = productionHouse;
	}

	public int getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
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
        System.out.println("AudioBook Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Duration: " + duration + " hours");
        System.out.println("Singer Name: " + singerName);
        System.out.println("Production House: " + productionHouse);
        System.out.println("Year of Release: " + yearOfRelease);
    }

    @Override
    public void displayInfo(PrintWriter writer) {
        writer.println("AudioBook Title: " + title);
        writer.println("Author: " + author);
        writer.println("Price: $" + price);
        writer.println("Duration: " + duration + " hours");
        writer.println("Singer Name: " + singerName);
        writer.println("Production House: " + productionHouse);
        writer.println("Year of Release: " + yearOfRelease);
    }
}
