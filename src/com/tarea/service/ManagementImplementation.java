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
	public Book updateBook(String isbn) {
		Book content = null;
		
		for(Book element: inventory.getInventory()) {
			if(element.getISBN().equals(isbn)) {
				return element;
			}
		}
		
		System.out.println("Book doesn't exist");
		
		return content;
	}

	@Override
	public void listBooks() {
		
		inventory.listBooks(inventory.getInventory());
		
	}
	
	@Override
	public void search(String title, String author, String gender, String isbn) {
		List<Book> searchList = inventory.search(title, author, gender, isbn);
		
		inventory.listBooks(searchList);
		
	}

	@Override
	public void listPrice() {
		Map<String, Double> price = inventory.getMap();
		
		inventory.listMap(price);
	}
	
	
	
	
	

}
