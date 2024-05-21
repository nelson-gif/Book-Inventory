package com.tarea.data;

import java.util.*;

import com.tarea.domain.Book;

public interface IBookInventory {
	
	boolean addBook(Book book);
	
	boolean removeBook(String isbn);
	
	
	<T> void listBooks(Collection<T> collection);
	
	List<Book> search(String title, String author, String genre, String isbn);
	
	Set<Book> classificationGenre();
	
	Set<Book> getInventory();

}
