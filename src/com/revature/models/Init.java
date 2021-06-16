package com.revature.models;

import java.util.ArrayList;

public class Init {
	ArrayList <Menu> menu= new ArrayList<>();
	//ArrayList <employee> menu= new ArrayList<>();
	//ArrayList <admin> menu= new ArrayList<>();
	public Menu startingMenu;
	public void menuInit() {
		String[] messages1= {"1.Log In","2.Sign Up"};
		Menu first= new Menu("Main Menu",messages1);	
		String[] messages2= {"1.Log In","2.Sign Up"};
		Menu loginMenu= new Menu("Log In",messages2);	
		String[] messages3= {"1.Log In","2.Sign Up"};
		Menu signupMenu= new Menu("SignUp",messages3);	
		this.startingMenu = first;
	}
	
	
}
