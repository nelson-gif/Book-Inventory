package com.tarea.service;

import com.tarea.domain.Book;
import com.tarea.domain.Gender;

public interface IInventoryManagement {
	
	boolean addNewBook(Book book);
	
	boolean removeBook(String isbn);
	
	Book updateBook(String isbn);
	
	void listBooks();
	
	void search(String title, String author, Gender gender, String isbn);
	
	void listPrice();
	
	void listByGender();

}
