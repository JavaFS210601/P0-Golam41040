package com.revature;

import com.revature.models.Function;
import com.revature.models.Init;
import com.revature.models.Menu;
import com.revature.models.UserMenuStatus;

public class Launcher {

	public static void main(String[] args) {
		
		int menuSelection=0;
		Init obj= new Init();
		obj.menuInit();
		UserMenuStatus use= new UserMenuStatus();
		use.currentMenu = obj.startingMenu;
		Function function= new Function();
		function.display(use.currentMenu);
		int counter=0;
		while(counter!=2) {
			String input=function.takeInput();
			menuSelection=function.parseInt(input);
			System.out.println(menuSelection);
			counter++;
		}
		
	}

}
