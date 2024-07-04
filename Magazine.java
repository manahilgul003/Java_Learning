package BooksPackage;

import java.io.PrintWriter;

public class Magazine implements Media {
    private String title;
    private String publisher;
    private String writer;
    private double price;
    private int issueNumber;
    private int numberOfPages;
    private String language;

    public Magazine(String title, String publisher, String writer, double price, int issueNumber, int numberOfPages, String language) {
        this.title = title;
        this.publisher = publisher;
        this.writer = writer;
        this.price = price;
        this.issueNumber = issueNumber;
        this.numberOfPages = numberOfPages;
        this.language = language;
    }

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(int issueNumber) {
		this.issueNumber = issueNumber;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
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
        System.out.println("Magazine Title: " + title);
        System.out.println("Publisher: " + publisher);
        System.out.println("Writer: " + writer);
        System.out.println("Price: $" + price);
        System.out.println("Issue Number: " + issueNumber);
        System.out.println("Number of Pages: " + numberOfPages);
        System.out.println("Language: " + language);
    }

    @Override
    public void displayInfo(PrintWriter writer) {
        writer.println("Magazine Title: " + title);
        writer.println("Publisher: " + publisher);
        writer.println("Writer: " + writer);
        writer.println("Price: $" + price);
        writer.println("Issue Number: " + issueNumber);
        writer.println("Number of Pages: " + numberOfPages);
        writer.println("Language: " + language);
    }
}
