package com.tarea.service;

import java.util.*;

import com.tarea.data.*;
import com.tarea.domain.Book;
import com.tarea.domain.Gender;

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
		
		try {
			for(Book element: inventory.getInventory()) {
				if(element.getISBN().equals(isbn)) {
					return element;
				}
				
			}
		}catch(NullPointerException e) {
			System.out.println("Book doesn't exist");
		}
		
		
		return content;
	}

	@Override
	public void listBooks() {
		
		inventory.listBooks(inventory.getInventory());
		
	}
	
	@Override
	public void search(String title, String author, Gender gender, String isbn) {
		List<Book> searchList = inventory.search(title, author, gender, isbn);
		
		inventory.listBooks(searchList);
		
	}

	@Override
	public void listPrice() {
		Map<String, Double> price = inventory.getMap();
		
		inventory.listMap(price);
	}

	@Override
	public void listByGender() {
		EnumMap<Gender, HashSet<Book>> myEnum = new EnumMap<>(Gender.class);
		
		for(Gender g: Gender.values()) {
			myEnum.put(g, new HashSet<>());
		}
		
		for(Book book: inventory.getInventory()) {
			myEnum.get(book.getGenre()).add(book);
		}
		
		for(Map.Entry<Gender, HashSet<Book>> entry: myEnum.entrySet()) {
			
			Gender gen = entry.getKey();
			HashSet<Book> book = entry.getValue();
			
			System.out.println("Gender: "+gen);
			for(Book b: book) {
				System.out.println("*** "+b);
			}
			
		}
		
	}
	
	
	
	
	

}
