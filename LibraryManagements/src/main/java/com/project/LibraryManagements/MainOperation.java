package com.project.LibraryManagements;

import java.util.Scanner;
import static com.project.LibraryManagements.AllOperation.*;

public class MainOperation {
	static Scanner sc=new Scanner(System.in);
	
	public static void mainOps() {
		while(true) {
			System.out.println("Press 1: For Book Details");
			int input=sc.nextInt();
			switch(input) {
			case 1:
				BookOperations();
		          break;
			}
		}
	}




}
