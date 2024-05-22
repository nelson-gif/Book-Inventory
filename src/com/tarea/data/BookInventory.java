package com.tarea.data;

import java.util.*;

import com.tarea.domain.Book;

public class BookInventory implements IBookInventory{
	
	private Set<Book> inventory;
	private Map<String, Double> pricing;
	
	public BookInventory() {
		inventory = new HashSet<>();
		pricing = new HashMap<>();
	}

	@Override
	public boolean addBook(Book book) {
		
		boolean added = inventory.add(book);
		
		if(added) {
			pricing.put(book.getISBN(), book.getPrice());
		}
		
		return added;
	}

	@Override
	public boolean removeBook(String isbn) {
		return inventory.removeIf( element -> element.getISBN().equals(isbn) );
	}


	@Override
	public <T> void  listBooks(Collection<T> collection) {
		collection.forEach(element -> {
			System.out.println(element);
		});
	}
	

	@Override
	public List<Book> search(String title, String author, String gender, String isbn) {
		List<Book> books = new ArrayList<>();

		inventory.forEach( element -> {
			if(element.getTitle().equalsIgnoreCase(title) || element.getAuthor().equalsIgnoreCase(author)
					|| element.getGenre().equalsIgnoreCase(gender) || element.getISBN().equalsIgnoreCase(isbn)) {
				books.add(element);
			}
		});
		
		return books;
	}

	@Override
	public Set<Book> classificationGenre() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Set<Book> getInventory(){
		return this.inventory;
	}

	@Override
	public <K, V> void listMap(Map<K, V> myMap) {
		myMap.forEach( (key, value) -> {
			System.out.println("ISBN: "+key+", price: "+value);
		});
		
	}

	@Override
	public Map<String, Double> getMap() {
		return this.pricing;
	}

	
	

}
