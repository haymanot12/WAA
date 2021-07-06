package mvc.domain;

import com.sun.istack.NotNull;

import javax.validation.constraints.Size;

public class Book {
	@NotNull
	@Size(min=2, max=20)
	private String isbn;
	@NotNull
	@Size(min=2, max=20)
	private String title;
	private double price;
	@NotNull
	@Size(min=2, max=20)
	private String author;

	public Book() {

	}

	public Book(String isbn, String title, double price, String author) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
