package com.project.LibraryManagements;


import java.util.List;
import java.util.Scanner;

import project.com.exception.ResourceNotFoundException;
import project.com.model.Books;
import project.com.service.*;

public class AllOperation {
static BookService bookservice = new BookServiceImpl();
static GenerService generservice = new GenerServiceImpl();
static Scanner sc = new Scanner(System.in);
static Books books = new Books();

	public static void BookOperations() {
		while(true) {
			System.out.println("Press 1: For add Book\n Press 2: For Show all Books\n Press 3: For Update book\n Press 4: For Delete Book");
			int input = sc.nextInt();
			switch(input) {
			case 1:
				Books book=createBook();
				Books savedEntity=bookservice.addBook(book);
				System.out.println("Student Data has been saved successfully"+ savedEntity);
				break;
				
			case 2:
				List<Books> books=bookservice.getAllBooks();
				for(Books b:books)
				{
					System.out.println(b);
				}
				break;
				
			case 3:
				System.out.println("Enter Book Id to update the infromation");
			       long bId=sc.nextLong();
			       Books b=bookservice.getBook(bId);
			       if(b!=null) {
			       Books bk=updateBookData();
			     //service
			       Books updatedInfo=bookservice.updateBook(bId, bk);
			       System.out.println("Book Data has been updated Successfully"+ updatedInfo);
			       }
			       
			       else
			       {
			    	   throw new ResourceNotFoundException("Book Id not found");
			       }
			       
				break;
			case 4:
				System.out.println("Enter Book Id to delete the infromation");
			       long id=sc.nextLong();
			       String message=bookservice.deleteBook(id);
			       
			       if(message!=null) {
			    	   System.out.println(message);
				       }
				       
				       else
				       {
				    	   throw new ResourceNotFoundException("Book Id not found");
				       }
				break;
				
				
			}
		}
		
	}
	
	private static Books updateBookData() {
		sc.nextLine();
		
		System.out.println("Enter Book title");
		String btitle=sc.nextLine();
		
		System.out.println("Enter Auther Name");
		String autherName=sc.nextLine();
		
		System.out.println("Enter Publication Year(in YYYY Formate)");
		int publicationYear=sc.nextInt();
		
		sc.nextLine();
		System.out.println("Enter Book gener");
		String gener=sc.nextLine();
		
		return new Books(btitle,autherName,publicationYear,gener);
		
	}

	

	private static Books createBook() {
		
		sc.nextLine();
		System.out.println("Enter Book-ID");
		Long bookId=sc.nextLong();
		sc.nextLine();
		System.out.println("Enter Book Title");
		String title=sc.nextLine();

		sc.nextLine();
		System.out.println("Enter Auther Name");
		String auther=sc.nextLine();
		
		System.out.println("Enter Publication Year(in YYYY Formate)");
		int publicationYear=sc.nextInt();
		
		sc.nextLine();
		System.out.println("Enter Book gener");
		String gener=sc.nextLine();
		
		return new Books(bookId,title,auther,publicationYear,gener);
	}

}
