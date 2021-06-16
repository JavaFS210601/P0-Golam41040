package com.revature.models;
import java.lang.NumberFormatException;
import java.util.Scanner;
public class Function {
	
	public int parseInt(String input) {
		int n=-1;
		System.out.println("I am here");
		try {
			 n= Integer.parseInt(input);
			
		}catch(NumberFormatException e) {
			System.out.println("\nInvalid input given\n");
			return -1;
		}
		return n;
	}
	
	public String takeInput() {
		Scanner scan= new Scanner(System.in);
		String input= scan.nextLine();
		return input;
	}
	public void display(Menu currentMenu) {
		System.out.println("      "+currentMenu.name);
		for(String i:currentMenu.messages) {
			System.out.println(i);
		}
	}
}
