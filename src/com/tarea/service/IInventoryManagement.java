package com.tarea.service;

import com.tarea.domain.Book;

public interface IInventoryManagement {
	
	boolean addNewBook(Book book);
	
	boolean removeBook(String isbn);
	
	boolean updateBook(Book existentBook, Book newBook);
	
	void listBooks();
	
	void search(String title, String author, String genre, String isbn);

}
