package com.tarea.service;

import com.tarea.domain.Book;

public interface IInventoryManagement {
	
	boolean addNewBook(Book book);
	
	boolean removeBook(String isbn);
	
	Book updateBook(String isbn);
	
	void listBooks();
	
	void search(String title, String author, String gender, String isbn);
	
	void listPrice();

}
