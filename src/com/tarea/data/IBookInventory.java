package com.tarea.data;

import java.util.*;

import com.tarea.domain.Book;

public interface IBookInventory {
	
	boolean addBook(Book book);
	
	boolean removeBook(String isbn);
	
	
	<T> void listBooks(Collection<T> collection);
	
	<K, V> void listMap(Map<K,V> myMap); 
	
	List<Book> search(String title, String author, String gender, String isbn);
	
	Set<Book> classificationGenre();
	
	Set<Book> getInventory();
	
	Map<String, Double> getMap();
	
	

}
