package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.postgresql.util.PSQLException;

import com.revature.models.Admin;
import com.revature.models.Doctor;
import com.revature.models.Function;
import com.revature.models.Patient;
import com.revature.models.UserStatus;
import com.revature.utils.ConnectionUtil;

public class PatientDao implements DAOInterface {

	@Override
	public void add(Doctor doctor) {}
	@Override
	public List<Doctor> viewDoctor() {
		return null;
	}
	@Override
	public void add(Admin admin) {}
	
	@Override
	
	
	public void add(Patient patient) {
		final Logger log = LogManager.getLogger(DoctorDao.class);
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO patients( patient_f_name, patient_l_name, patient_age, "
					+ "patient_insurance,emergency_contact,doctor_id_fk)"
					+ "VALUES(?,?,?,?,?,?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,patient.getF_name());
			ps.setString(2,patient.getL_name());
			ps.setInt(3,patient.getPatient_age() );
			ps.setString(4,patient.getPatient_insurance());
			ps.setString(5,patient.getEmergency_contact());
			ps.setInt(6, patient.getDoctor_id());
			
			try {
			ps.executeUpdate();
			System.out.println("Patient "+patient.getF_name()+" "+patient.getL_name()+" Added.");
			System.out.println("New Patient Added.");
			log.info(UserStatus.currentAdmin+" has added Dr."+patient.getF_name()+" "+patient.getL_name()+" to the system.");
			}catch(PSQLException e) {
				System.out.println("No doctor with ID: "+patient.getDoctor_id()+" exist in the system!");
				System.out.println("Adding Patient Failed!!");
				System.out.println("Returning to Patient Menu.");
				
			}
			
			
		}catch(SQLException e) {
			System.out.println("Adding Patient Failed!!");
			System.out.println("Returning to Patient Menu.");
			
		}
	}

	

	

	@Override
	public List<Patient> viewPatient() {
		try (Connection conn = ConnectionUtil.getConnection()){
			ResultSet rs =null;
			
			String sql="SELECT patient_Id, patient_f_name, patient_l_name, patient_age, \r\n"
					+ "		patient_insurance,emergency_contact, \r\n"
					+ "		f_name,l_name,doctor_id_fk \r\n"
					+ "		FROM patients \r\n"
					+ "		JOIN doctors \r\n"
					+ "		ON doctor_id_fk = doctor_id;";
			Statement s = conn.createStatement();
			rs = s.executeQuery(sql);
			List<Patient> patientList= new ArrayList<>();
			
			
			while(rs.next()) {
				
				Patient patient = new Patient(
						rs.getInt("patient_id"),
						rs.getString("patient_f_name"),
						rs.getString("patient_l_name"),
						rs.getInt("patient_age"),
						rs.getString("patient_insurance"),
						rs.getString("emergency_contact"),
						rs.getString("f_name"),
						rs.getString("l_name"),
						rs.getInt("doctor_id_fk")
						);
				patientList.add(patient);
				
			}
			return patientList;
		}catch(SQLException e) {
			System.out.println("Viewing Patient Failed!!");
			System.out.println("Returning to Patient Menu.");
		}
		return null;
	}

	@Override
	public void update(int Id,String column_name,String data_type) {
		try(Connection conn = ConnectionUtil.getConnection()){
			final Logger log = LogManager.getLogger(DoctorDao.class);
			if(data_type.equals("int")) {
				
				if(column_name.equals("doctor_id_fk")) {
					System.out.println("What is the new doctor's ID?" );
				}
				else {
					System.out.println("What is the new value of "+ column_name);
				}
				String input= Function.takeInput();
				int value = Function.parseInt(input);
				
				String sql = "UPDATE patients SET "+column_name +"= ? WHERE patient_id= ? ;" ;
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setInt(1,value );
				ps.setInt(2, Id);
				
				try {
				ps.execute();
				System.out.println("Record Updated.");
				log.info(UserStatus.currentAdmin+" has updated the "+column_name+" of Patient with ID:"+Id+" in the system.");
				}catch(PSQLException e) {
					System.out.println("No doctor with ID: "+value+" exist in the system!");
					System.out.println("Updating Patient Failed!!");
					System.out.println("Returning to Patient Menu.");
				}
			}
			else if(data_type.equals("string")) {
				System.out.println("What is the new value of "+ column_name+" ?");
				String value= Function.takeInput();
				String sql = "UPDATE patients SET "+column_name +"= ? WHERE patient_id= ? ;" ;
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1,value);
				ps.setInt(2, Id);
				ps.execute();
				System.out.println("Record Updated.");
				log.info(UserStatus.currentAdmin+" has updated the "+column_name+" of Patient with ID:"+Id+" in the system.");

				

			}
		}catch(SQLException e) {
			System.out.println("Update Failed!!");
			System.out.println("Returning to Patient Menu.");
			
		}
	}

	@Override
	public void delete(int Id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			final Logger log = LogManager.getLogger(PatientDao.class);
			
			String sql = "DELETE FROM patients where patient_id =? ;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Id);
			ps.executeUpdate();
			
			log.warn(UserStatus.currentAdmin+" has deleted Patient ID no."+ Id+" from the system.");
			
		}catch(SQLException e) {
			System.out.println("Delete Failed!!");
			System.out.println("Returning to Patient Menu.");
		}
		
	}
	
}

