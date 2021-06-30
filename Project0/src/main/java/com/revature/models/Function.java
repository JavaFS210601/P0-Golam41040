package com.revature.models;
import java.lang.NumberFormatException;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.AdminDao;
import com.revature.daos.DoctorDao;
import com.revature.daos.PatientDao;
public class Function {

	private static final Logger log = LogManager.getLogger(Function.class);
	
	
	public static void showType() {
		System.out.println("Type:1. Osteopath\n "
				+ "2. Otolaryngologist\n "
				+ "3. Pathologist\n "
				+ "4. Pediatrician\n "
				+ "5. Physiatrist\n "
				+ "6. Plastic Surgeon\n "
				+ "7. Cardiologist\n "
				+ "8. Dermatologist\n "
				+ "9. Urologist\n");
	}
	
	public static int parseInt(String input) {
		int n=-1;
		try {
			 n= Integer.parseInt(input);
			 return n;
			
		}catch(NumberFormatException e) {
			System.out.println("\nInvalid input given!!\n");
			return -1;
		}
	}
	
	public static String takeInput() {
		Scanner scan= new Scanner(System.in);
		String input= scan.nextLine();
		return input;
	}
	public static void display(Menu currentMenu) {
		System.out.println("      "+currentMenu.name);
		for(String i:currentMenu.messages) {
			System.out.println(i);
		}
	}
	
	public static Menu getNextMenu(int i, Menu menu) {
		try {
		return menu.exit.get(i-1);
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("Cant select a menu.");
		}
		return menu;
	}
	public static void action(Menu menu) {
		
		String name= menu.name;
		switch(name) {
		
		case "Log In":{
			AdminDao ad= new AdminDao();
			System.out.println("      Login");
			System.out.println("Username: ");
			String userName= takeInput();
			System.out.println("Password: ");
			String password= takeInput();
			boolean check = ad.check(userName, password);
			if(check==true) {
				log.info(userName+" has logged in to the system");
				UserStatus.currentAdmin= userName;
				System.out.println("Successfully Logged in");
				
			}
			else {
				System.out.println("Cannot Log in.");
				System.out.println("Try Again?");
				String choice= takeInput();
				choice= choice.toLowerCase();
				if(choice.contains("yes")) {
					action(menu);
				}
				else if (choice.contains("no")) {
					UserStatus.currentMenu= UserStatus.initialMenu;
				}
				else {
					System.out.println("Wrong input given!!");
					UserStatus.currentMenu= UserStatus.initialMenu;
				}
				
			}
			break;
		}

		case "Log Out":{
				System.out.println("Logging Out!!");
				log.info(UserStatus.currentAdmin+" has logged out of the system");
				UserStatus.currentAdmin=null;
			break;
		}
		case "Sign Up":{
			AdminDao ad = new AdminDao();
			System.out.println("      Sign up");
			System.out.println("Name: ");
			String adminName= takeInput();
			System.out.println("Username: ");
			String userName= takeInput();
			
			System.out.println("Password: ");
			String password1= takeInput();
			System.out.println("Confirm Password:");
			String password2= takeInput();
			if(!password1.equals(password2)) {
				while(!password1.equals(password2)) {
					System.out.println("Passwords do not match. Try Again!!");
					System.out.println("Password: ");
					password1= takeInput();
					System.out.println("Confirm Password:");
					password2= takeInput();
				}
			}
			Admin admin = new Admin(adminName,userName,password1);
			ad.add(admin);
			System.out.println("Welcome "+userName+", to the Hospital Management System!!");
			break;
		}
		case "Add Doctor":{
			DoctorDao dd= new DoctorDao();
			
			System.out.println("Add New Doctor");
			System.out.println("First Name: ");
			String docFName= takeInput();
			System.out.println("Last Name: ");
			String docLName= takeInput();
			showType();
			String input= takeInput();
			int type=parseInt(input);
			Doctor doctor= new Doctor(docFName,docLName,type);
			dd.add(doctor);
			break;
			
		}
		case "View Doctor":{
			
			DoctorDao dd= new DoctorDao();
			System.out.println("      Current Doctors in the Roster");
			List<Doctor> doctors = dd.viewDoctor();
			for(Doctor d: doctors) {
				d.toString();
				System.out.println("\n");
			}
			break;
		}
		case "Delete Doctor":{
			DoctorDao dd= new DoctorDao();
			System.out.println("      Current Doctors in the Roster");
			List<Doctor> doctors = dd.viewDoctor();
			for(Doctor d: doctors) {
				d.toString();
				System.out.println("\n");
			}
			System.out.println("ID of the Doctor to delete: ");
			String input= takeInput();
			int ID = parseInt(input);
			int n= doctors.size()-1;
			int tempID;
			while(n>=0) {
				tempID= doctors.get(n).getDoctor_id();
				if(tempID==ID) {
					dd.delete(ID);
					
					
					break;
				}
				n--;
			}
			if(n<0) {
				System.out.println("ID does not match with an Existing Doctor.");
				System.out.println("Try Again?");
				String choice= takeInput();
				choice= choice.toLowerCase();
				if(choice.contains("yes")) {
					action(menu);
				}
				else if (choice.contains("no")) {
					UserStatus.currentMenu= UserStatus.currentMenu.next;
				}
				else {
					System.out.println("Wrong input given!!");
					UserStatus.currentMenu= UserStatus.currentMenu.next;
				}
				break;
			}
			break;
		}
		case "Update Doctor":{
			DoctorDao dd= new DoctorDao();
			System.out.println("     Doctor Update Menu\n\n  ");
			System.out.println("      Current Doctors in the Roster");
			List<Doctor> doctors = dd.viewDoctor();
			for(Doctor d: doctors) {
				d.toString();
				System.out.println("\n");
			}
			System.out.println("ID of the Doctor to UPDATE: ");
			String input= takeInput();
			int ID = parseInt(input);
			int n= doctors.size()-1;
			int tempID;
			while(n>=0) {
				tempID= doctors.get(n).getDoctor_id();
				if(tempID==ID) {
					break;
				}
				n--;
			}
			
			if(n<0)
			{
				System.out.println("ID does not match with an Existing Doctor.");
				System.out.println("Try Again?");
				String choice= takeInput();
				choice= choice.toLowerCase();
				if(choice.contains("yes")) {
					action(menu);
					break;
				}
				else if (choice.contains("no")) {
					UserStatus.currentMenu= UserStatus.currentMenu.next;
					break;
				}
				else {
					System.out.println("Wrong input given!!");
					UserStatus.currentMenu= UserStatus.currentMenu.next;
					break;
				}
			
			}
			try {
			System.out.println("What do you want to update?\n");
			System.out.println("1.First Name\n2.Last Name\n3.Role");
			String[] column_names = {"f_name","l_name","role_id_fk"};
			String input1= takeInput();
			int field = parseInt(input1);
			
			String column_name = column_names[field-1];
			
			String data_type;
			if(field==3) {
				data_type="int";
			}
			else {
				data_type= "string";
			}
			dd.update(ID, column_name, data_type);
			break;
			}catch(IndexOutOfBoundsException e) {
				System.out.println("Wrong Input!!");
				break;
			}
		}
		
		case "Add Patient":{
			PatientDao pd= new PatientDao();
			
			System.out.println("Add New Patient");
			System.out.println("First Name: ");
			String patFName= takeInput();
			System.out.println("Last Name: ");
			String patLName= takeInput();
			System.out.println("Age: ");
			String input1= takeInput();
			int patAge= parseInt(input1);
			System.out.println("Insurance: ");
			String patInsurance = takeInput();
			System.out.println("Emergency Contact: ");
			String patEmergency = takeInput();
			System.out.println("Doctor ID:");
			String input= takeInput();
			int docId=parseInt(input);
			Patient patient= new Patient(patFName,patLName,patAge,patInsurance,patEmergency,docId);
			pd.add(patient);
			break;
			
		}
		case "View Patient":{
			
			PatientDao pd= new PatientDao();
			System.out.println("      Currently Registered Patients are:\n");
			List<Patient> patients = pd.viewPatient();
			for(Patient p: patients) {
				
				p.toString();
				System.out.println("\n");
				System.out.println("===========================================");
				System.out.println("\n");
			}
			break;
		}
		case "Delete Patient":{
			PatientDao pd= new PatientDao();
			System.out.println("      Currently Registered Patients:\n  ");
			List<Patient> patients = pd.viewPatient();
			for(Patient p: patients) {
				p.toString();
				System.out.println("\n");
				System.out.println("===========================================");
				System.out.println("\n");
			}
			System.out.println("ID of the patient to delete: ");
			String input= takeInput();
			int ID = parseInt(input);
			int n= patients.size()-1;
			int tempID;
			while(n>=0) {
				tempID= patients.get(n).getPatient_id();
				if(tempID==ID) {
					pd.delete(ID);
					break;
				}
				n--;
			}
			if(n<0) {
				System.out.println("ID does not match with an Existing Patient.");
				System.out.println("Try Again?");
				String choice= takeInput();
				choice= choice.toLowerCase();
				if(choice.contains("yes")) {
					action(menu);
				}
				else if (choice.contains("no")) {
					UserStatus.currentMenu= UserStatus.currentMenu.next;
				}
				else {
					System.out.println("Wrong input given!!");
					UserStatus.currentMenu= UserStatus.currentMenu.next;
				}
				break;
			}
			break;
		}
		
		case "Update Patient":{
			try {
			PatientDao pd= new PatientDao();
			System.out.println("     Patient Update Menu\n\n  ");
			System.out.println("      Current Registered Patients :\n");
			List<Patient> patients = pd.viewPatient();
			for(Patient p: patients) {
				p.toString();
				System.out.println("\n");
			}
			
			System.out.println("ID of the patient to UPDATE: ");
			String input= takeInput();
			int ID = parseInt(input);
			int n= patients.size()-1;
			int tempID;
			while(n>=0) {
				tempID= patients.get(n).getPatient_id();
				if(tempID==ID) {
					break;
				}
				n--;
			}
			if(n<0) {
				System.out.println("ID does not match with an Existing Patient.");
				System.out.println("Try Again?");
				String choice= takeInput();
				choice= choice.toLowerCase();
				if(choice.contains("yes")) {
					action(menu);
				}
				else if (choice.contains("no")) {
					UserStatus.currentMenu= UserStatus.currentMenu.next;
				}
				else {
					System.out.println("Wrong input given!!");
					UserStatus.currentMenu= UserStatus.currentMenu.next;
				}
				break;
			}
			System.out.println("What do you want to update?\n");
			System.out.println("1.First Name\n2.Last Name\n3.Age\n"
					+ "4.Emergency Contact\n5.Insurance Name\n"
					+ "6.Doctor");
			String[] column_names = {"patient_f_name","patient_l_name","patient_age","emergency_contact",
									"patient_insurance","doctor_id_fk"};
			String input1= takeInput();
			int field = parseInt(input1);
			String column_name = column_names[field-1];
			String data_type;
			if(field==3||field==6) {
				data_type="int";
			}
			else {
				data_type= "string";
			}
			pd.update(ID, column_name, data_type);
			
			break;
			}catch(IndexOutOfBoundsException e) {
				System.out.println("Wrong input!!");
				break;
			}
		}
		
		case "Exit Menu":{
			System.out.println("System has exited.");
			System.exit(0);
		}
		
		
		}
	}
	
}
