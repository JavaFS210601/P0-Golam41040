package com.revature.models;

public class Init {

	public Menu startingMenu;
	public void initAll() {
		menuInit();
		int menuSelection=0;
		UserStatus.currentMenu = startingMenu;
		
		int counter=0;
		while(counter!=2) {
			if(UserStatus.currentMenu.next==null) {
				Function.display(UserStatus.currentMenu);
				String input=Function.takeInput();
				menuSelection=Function.parseInt(input);
				UserStatus.currentMenu= Function.getNextMenu(menuSelection,UserStatus.currentMenu);
				Function.action(UserStatus.currentMenu);
			}
			else if(UserStatus.currentMenu.next.getName().equals("Exit Menu")) {
				Function.action(UserStatus.currentMenu);
			}
			else {
				
				UserStatus.currentMenu=UserStatus.currentMenu.next;
				if(UserStatus.currentMenu.next==null) {
					continue;
				}
				else {
					Function.display(UserStatus.currentMenu);
					Function.action(UserStatus.currentMenu);
				}
			}
			
			
		}
	}
	
	
	public void menuInit() {
		String[] messages= {"1.Log In","2.Sign Up","3.Exit"};
		Menu first= new Menu("Main Menu",messages);
		UserStatus.initialMenu=first;
		
		
		String[] messages2= {"1.Main Menu","2.Exit"};
		Menu loginMenu= new Menu("Log In",messages2);
		
		
		
		String[] messages3= {"1.Main Menu","2.Exit"};
		Menu signupMenu= new Menu("Sign Up",messages3);
		
		
		String[] messages4= {"1.Doctor Menu","2.Patient Menu","3.Log Out","4.Exit"};
		Menu adminMenu= new Menu("Admin Menu",messages4);
		
		
		String[] messages13= {"1.Add A Doctor","2.View Doctors","3.Update a Doctor's Record","4.Delete a Doctor from the system","5.Back","6.Log Out","7.Exit"};
		Menu doctorMenu= new Menu("Doctor Menu",messages13);
		
		String[] messages14= {"1.Add A Patient","2.View Registered Patients","3.Update a patient's Record","4.Delete a Patient from the system","5.Back","6.Log Out","7.Exit"};
		Menu patientMenu= new Menu("Patient Menu",messages14);
		
		
		String[] messages5= {};
		Menu addDoctorMenu = new Menu("Add Doctor",messages5);
		
		String[] messages6= {};
		Menu viewDoctorMenu = new Menu("View Doctor",messages6);
		
		String[] messages7= {};
		Menu updateDoctorMenu = new Menu("Update Doctor",messages7);
		
		String[] messages8= {};
		Menu deleteDoctorMenu = new Menu("Delete Doctor",messages8);	
		
		String[] messages9= {};
		Menu addPatientMenu = new Menu("Add Patient",messages9);
		
		String[] messages10= {};
		Menu viewPatientMenu = new Menu("View Patient",messages10);
		
		String[] messages11= {};
		Menu updatePatientMenu = new Menu("Update Patient",messages11);
		
		String[] messages12= {};
		Menu deletePatientMenu = new Menu("Delete Patient",messages12);
		
		String[] messages15= {};
		Menu logOutMenu = new Menu("Log Out",messages15);
		
		String[] message16= {};
		Menu exitMenu= new Menu("Exit Menu",message16);
		
		
		
		
		this.startingMenu = first;
		first.exit.add(loginMenu);
		first.exit.add(signupMenu);
		first.exit.add(exitMenu);
		
		adminMenu.exit.add(doctorMenu);
		adminMenu.exit.add(patientMenu);
		adminMenu.exit.add(logOutMenu);
		adminMenu.exit.add(exitMenu);
		
		doctorMenu.exit.add(addDoctorMenu);
		doctorMenu.exit.add(viewDoctorMenu);
		doctorMenu.exit.add(updateDoctorMenu);
		doctorMenu.exit.add(deleteDoctorMenu);
		doctorMenu.exit.add(adminMenu);
		doctorMenu.exit.add(logOutMenu);
		doctorMenu.exit.add(exitMenu);
		
		patientMenu.exit.add(addPatientMenu);
		patientMenu.exit.add(viewPatientMenu);
		patientMenu.exit.add(updatePatientMenu);
		patientMenu.exit.add(deletePatientMenu);
		patientMenu.exit.add(adminMenu);
		patientMenu.exit.add(logOutMenu);
		patientMenu.exit.add(exitMenu);
		
		first.next= null;
		loginMenu.next=adminMenu;
		signupMenu.next= first;
		
		adminMenu.next= null;
		
		doctorMenu.next=null;
		addDoctorMenu.next= doctorMenu;
		viewDoctorMenu.next= doctorMenu;
		updateDoctorMenu.next= doctorMenu;
		deleteDoctorMenu.next= doctorMenu;
		
		patientMenu.next=null;
		addPatientMenu.next= patientMenu;
		viewPatientMenu.next= patientMenu;
		updatePatientMenu.next= patientMenu;
		deletePatientMenu.next= patientMenu;
		
		logOutMenu.next=first;
		exitMenu.next = null;
		
	}
	
	
}
