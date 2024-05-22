package com.tarea.main;

import java.util.Scanner;

import com.tarea.domain.Book;
import com.tarea.domain.Gender;
import com.tarea.service.*;

public class main {

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		IInventoryManagement obj = new ManagementImplementation();
		
		boolean finishLoop = true;
		int option;
		
		while(finishLoop) {			
			System.out.println("Enter the option below: ");
			System.out.println("1. Add a new book");
			System.out.println("2. List inventory");
			System.out.println("3. Update a book");
			System.out.println("4. Remove a book");
			System.out.println("5. Search a book");
			System.out.println("6. See books by gender");
			System.out.println("7. See pricing by ISBN");
			System.out.println("8. Exit");
			
			
			try {
				option = Integer.parseInt(sc.nextLine());
				
				switch(option) {
					case 1:
						System.out.println("Enter the book's title:");
						String title = sc.nextLine();
						System.out.println("Enter the author's name:");
						String author = sc.nextLine();
						System.out.println("Enter the ISBN:");
						String isbn = sc.nextLine();
						System.out.println("Enter the gender:");
						
						boolean x = false;
						Gender gen = null;
						do {
							x= false;
							System.out.println("1. "+Gender.FICTION);
							System.out.println("2. "+Gender.NON_FICTION);
							System.out.println("3. " +Gender.MYSTERY);
							System.out.println("4. " + Gender.ROMANCE);
							
							try {
								
								int gender = Integer.parseInt(sc.nextLine());
								switch(gender) {
									case 1:
										gen = Gender.FICTION;
										break;
									case 2:
										gen = Gender.NON_FICTION;
										break;
									case 3:
										gen = Gender.MYSTERY;
										break;
									case 4:
										gen = Gender.ROMANCE;
										break;
									default:
										System.out.println("choose an option between 1 and 4");
										x = true;
								}
								
							}catch(NumberFormatException e) {
								System.out.println("Enter a number");
								x = true;
							}
							
						}while(x);
						
						boolean o;
						//handling exception if no number is entered
						Double price = 0D;
						do {
							o = false;
							System.out.println("Enter the price:");
							try {
								price = Double.parseDouble(sc.nextLine());
							}catch(NumberFormatException e){
								System.out.println("Enter a number");
								o =true;
							}
						}while(o);
						
						//handling exception if no number is entered
						int quantity = 0;
						boolean stock = false;
						do {
							o = false;
							System.out.println("Enter the quantity:");
							
							try {
								quantity = Integer.parseInt(sc.nextLine());
								if(quantity <= 0) {
									stock =false;
								}else {
									stock = true;
								}
							}catch(NumberFormatException e){
								System.out.println("Enter a number");
								o =true;
							}
						}while(o);
						
						Book book = new Book(title, author, isbn, gen, price, quantity, stock);
						boolean wasAdded = obj.addNewBook(book);
						
						if(wasAdded) {
							System.out.println("The book was added successfully");
						}else {
							System.out.println("The book wasn't added, because the book already exists");
						}
						
						break;
					
					case 2:
						obj.listBooks();
						break;
						
					case 3:
						
						System.out.println("Enter the ISBN of the book that you want to edit: ");
						String isbn3 = sc.nextLine();
						//handling exception if no number is entered
						try {
						if(!obj.updateBook(isbn3).equals(null)) {
							Book book3 = obj.updateBook(isbn3);
							System.out.println("Enter the new title or hit enter to not Edit the title");
							String title3 = sc.nextLine();
							if(!title3.equals("")) {
								book3.setTitle(title3);
							}
							System.out.println("Enter the new author or hit enter to not edit the author");
							String author3 = sc.nextLine();
							if(!author3.equals("")) {
								book3.setAuthor(author3);
							}
							System.out.println("Enter the number of the new gender, or enter 0 to not edit it");
							
							do {
								x= false;
								System.out.println("0. do not edit");
								System.out.println("1. "+Gender.FICTION);
								System.out.println("2. "+Gender.NON_FICTION);
								System.out.println("3. " +Gender.MYSTERY);
								System.out.println("4. " + Gender.ROMANCE);
								
								try {
									
									int gender = Integer.parseInt(sc.nextLine());
									switch(gender) {
										case 0:
											break;
										case 1:
											gen = Gender.FICTION;
											book3.setGenre(gen);
											break;
										case 2:
											gen = Gender.NON_FICTION;
											book3.setGenre(gen);
											break;
										case 3:
											gen = Gender.MYSTERY;
											book3.setGenre(gen);
											break;
										case 4:
											gen = Gender.ROMANCE;
											book3.setGenre(gen);
											break;
										default:
											System.out.println("choose an option between 1 and 4");
											x = true;
									}
									
								}catch(NumberFormatException e) {
									System.out.println("Enter a number");
									x = true;
								}
								
							}while(x);
							
							
							do {
								o = false;
								System.out.println("Enter the new price or enter -1 to not edit the price");
							try {
								double price3 = Double.parseDouble(sc.nextLine());
								if(price3 != -1) {
									book3.setPrice(price3);
								}
							}catch(NumberFormatException e) {
								System.out.println("Enter a number");
								o = true;
							}
							}while(o);
							
							do {
								o = false;
								System.out.println("Enter the new quantity or enter -1 to not edit the quantity");
							try {
								int quantity3= Integer.parseInt(sc.nextLine());
								if(quantity3 != -1) {
									book3.setQuantity(quantity3);
									
									if(quantity3 == 0) {
										stock =false;
									}else {
										stock = true;
									}
								}
								
							}catch(NumberFormatException e) {
								System.out.println("Enter a number");
								o = true;
							}
							}while(o);
							
						}
						}catch(NullPointerException e) {
							System.out.println("book doesn't exist");
						}
						System.out.println("Changes were completed!");
						break;
						
					case 4:
						System.out.println("Enter the book's isbn that you want to remove:");
						String nisbn = sc.nextLine();
						
						boolean wasRemoved = obj.removeBook(nisbn);
						
						if(wasRemoved) {
							System.out.println("The book was removed successfully");
						}else {
							System.out.println("The book wasn't removed, because it doesn't exist");
						}
						
						break;
					
					case 5:
						System.out.println("Enter the values that you know to search the book(push enter to leave values empty):");
						System.out.println("Enter the title:");
						String title1 = sc.nextLine();
						System.out.println("Enter the author:");
						String author2 = sc.nextLine();
						System.out.println("Enter the Gender");
						
						Gender gen2 = null;
						do {
							x= false;
							System.out.println("0. I don't know the gender");
							System.out.println("1. "+Gender.FICTION);
							System.out.println("2. "+Gender.NON_FICTION);
							System.out.println("3. " +Gender.MYSTERY);
							System.out.println("4. " + Gender.ROMANCE);
							
							try {
								
								int gender = Integer.parseInt(sc.nextLine());
								switch(gender) {
									case 0:
										break;
									case 1:
										gen2 = Gender.FICTION;
										break;
									case 2:
										gen2 = Gender.NON_FICTION;
										break;
									case 3:
										gen2= Gender.MYSTERY;
										break;
									case 4:
										gen2 = Gender.ROMANCE;
										break;
									default:
										System.out.println("choose an option between 0 and 4");
										x = true;
								}
								
							}catch(NumberFormatException e) {
								System.out.println("Enter a number");
								x = true;
							}
							
						}while(x);
						
						
						System.out.println("Enter the isbn");
						String isbn2 = sc.nextLine();
						
						System.out.println("See the results below: ");
						obj.search(title1, author2, gen2, isbn2);
						
						break;
						
					case 6:
						obj.listByGender();
						break;
						
					case 7:
						obj.listPrice();
						break;
						
					case 8:
						sc.close();
						System.exit(0);
						break;
					default:
						System.out.println("Enter a number between 1 and 8");
				}
				
			}catch(NumberFormatException e) {
				System.out.println("\n***********Enter a number between 1 and 8***********\n");
			}
			
		}
		
	}
	
	

}
