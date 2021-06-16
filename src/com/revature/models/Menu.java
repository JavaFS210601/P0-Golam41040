package com.revature.models;
import java.util.ArrayList;


public class Menu {
	String name;
	ArrayList <String> messages= new ArrayList<String>();
	public Menu() {
		
	}
	public Menu(String menuName,String[] messages) {
		this.name= menuName;
		for(String i:messages) {
			this.messages.add(i);
		}
	}
}
