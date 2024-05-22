package com.tarea.domain;

import java.util.Objects;

public class Book {
	
	private String title;
	private String author;
	private String ISBN;
	private String gender;
	private double price;
	private int quantity;
	private boolean stock;
	

	public Book() {}

	public Book(String title, String author, String iSBN, String gender, double price, int quantity, boolean stock) {
		super();
		this.title = title;
		this.author = author;
		ISBN = iSBN;
		this.gender = gender;
		this.price = price;
		this.quantity = quantity;
		this.stock = stock;
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

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getGenre() {
		return gender;
	}

	public void setGenre(String genre) {
		this.gender = genre;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isStock() {
		return stock;
	}
	
	public void setStock(boolean stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [title=");
		builder.append(title);
		builder.append(", author=");
		builder.append(author);
		builder.append(", ISBN=");
		builder.append(ISBN);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", price=");
		builder.append(price);
		builder.append(", quantity=");
		builder.append(quantity);
		
		if(stock) {
			builder.append(", stock=restocked +");
			builder.append(quantity);
		}else {
			builder.append(", stock=sold");
		}
		
		builder.append("]");
		
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(ISBN);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(ISBN, other.ISBN);
	}
	
	
	
	

}
