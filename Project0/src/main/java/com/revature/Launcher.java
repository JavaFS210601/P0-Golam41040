package com.revature;

import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;


import com.revature.models.*;


public class Launcher {
	
	
	
	
	public static void main(String[] args) {
		
		try(Connection conn= ConnectionUtil.getConnection()){
			System.out.println("Welcome to Hospital Management System\n\n");
	}catch(SQLException e) {
		e.printStackTrace();
	}
		Init obj= new Init();
		obj.initAll();
		
	
	}
}