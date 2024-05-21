package com.tarea.service;

import java.util.*;

import com.tarea.data.*;
import com.tarea.domain.Book;

public class ManagementImplementation implements IInventoryManagement{
	
	private IBookInventory inventory;
	
	public ManagementImplementation() {
		inventory = new BookInventory();
	}

	@Override
	public boolean addNewBook(Book book) {
		boolean wasAdded = inventory.addBook(book);
		
		return wasAdded;
	}

	@Override
	public boolean removeBook(String isbn) {
		boolean wasDeleted = inventory.removeBook(isbn);
		
		return wasDeleted;
	}

	@Override
	public boolean updateBook(Book existentBook, Book newBook) {
		boolean delete = inventory.removeBook(existentBook.getISBN());
		
		if(delete) {
			inventory.addBook(newBook);
		}
		
		return delete;
	}

	@Override
	public void listBooks() {
		
		inventory.listBooks(inventory.getInventory());
		
	}
	
	@Override
	public void search(String title, String author, String genre, String isbn) {
		List<Book> searchList = inventory.search(title, author, genre, isbn);
		
		inventory.listBooks(searchList);
		
	}
	
	
	

}
