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

public class DoctorDao implements DAOInterface{
	
	@Override
	public void add(Patient patient) {}
	@Override
	public List<Patient> viewPatient() {
		return null;
	}
	@Override
	public void add(Admin admin) {
		// TODO Auto-generated method stub
		
	}
	
	

	@Override
	public void add(Doctor doctor) {
		try(Connection conn = ConnectionUtil.getConnection()){
			final Logger log = LogManager.getLogger(DoctorDao.class);
			String sql = "INSERT INTO doctors(f_name, l_name, role_id_fk)"
					+ "VALUES(?,?,?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,doctor.getF_name());
			ps.setString(2,doctor.getL_name());
			ps.setInt(3,doctor.getRole_id() );
			
			try {
			ps.executeUpdate();
			System.out.println("Doctor "+doctor.getF_name()+" "+doctor.getL_name()+" Added!!");
			System.out.println("New Doctor Added!");
			log.info(UserStatus.currentAdmin+" has added Dr."+doctor.getF_name()+" "+doctor.getL_name()+" to the system.");

			}catch(PSQLException e) {
				System.out.println("Invalid Role ID provided.");
				System.out.println("Adding Doctor Failed!!");
				System.out.println("Returning to Doctor Menu");
			}
			
			
		}catch(SQLException e) {
			System.out.println("Adding Doctor Failed!!");
			System.out.println("Returning to Doctor Menu");
		}
		
	}

	

	@Override
	public List<Doctor> viewDoctor() {
		try (Connection conn = ConnectionUtil.getConnection()){
			ResultSet rs =null;
			String sql="SELECT d.doctor_id, d.f_name , d.l_name,d.role_id_fk, r.role_title\r\n"
					+ "FROM doctors d \r\n"
					+ "JOIN roles r \r\n"
					+ "ON d.role_id_fk =r.role_id ;";
			Statement s = conn.createStatement();
			rs = s.executeQuery(sql);
			List<Doctor> doctorList= new ArrayList<>();
			
			while(rs.next()) {
				
				Doctor doctor = new Doctor(
						rs.getInt("doctor_id"),
						rs.getString("f_name"),
						rs.getString("l_name"),
						rs.getInt("role_id_fk"),
						rs.getString("role_title")
						);
				doctorList.add(doctor);
			}
			
			return doctorList;
			
			
			
		}catch(SQLException e) {
			System.out.println("Viewing Doctor Failed!!");
			System.out.println("Returning to Doctor Menu");
		}
		
		return null;
	}


	@Override
	public void update(int Id,String column_name,String data_type) {
		try(Connection conn = ConnectionUtil.getConnection()){
			final Logger log = LogManager.getLogger(DoctorDao.class);
			if(data_type.equals("int")) {
				System.out.println("What is the new role for the Doctor? ");
				Function.showType();
				String input= Function.takeInput();
				int value = Function.parseInt(input);
				
				String sql = "UPDATE doctors SET "+column_name +"= ? WHERE doctor_id= ? ;" ;
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setInt(1,value);
				ps.setInt(2, Id);
				try {
				ps.execute();
				System.out.println("Record Updated.");
				log.info(UserStatus.currentAdmin+" has updated the "+column_name+" of Doctor with ID:"+Id+" in the system.");
				}catch(PSQLException e) {
					System.out.println("Update failed!");
					System.out.println("Returning to Doctor Menu");
				}
			}
			else if(data_type.equals("string")) {
				System.out.println("What is the new value of "+ column_name);
				String value= Function.takeInput();
				String sql = "UPDATE doctors SET "+column_name +"= ? WHERE doctor_id= ? ;" ;
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1,value);
				ps.setInt(2, Id);
				try {
				ps.execute();
				System.out.println("Record Updated.");
				log.info(UserStatus.currentAdmin+" has updated the "+column_name+" of Doctor with ID:"+Id+" in the system.");
				
				}catch(PSQLException e) {
					System.out.println("Update failed!");
					System.out.println("Returning to Doctor Menu");
				}

			}
		}catch(SQLException e) {
			System.out.println("Update Failed!!");
			System.out.println("Returning to Doctor Menu");
			
		}
		
	}

	@Override
	public void delete(int Id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			final Logger log = LogManager.getLogger(DoctorDao.class);
			String sql = "DELETE FROM doctors where doctor_id =? ;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Id);
			ps.executeUpdate();
			log.warn(UserStatus.currentAdmin+" has deleted A Doctor with ID: "+ Id+" from the system.");
			
		}catch(SQLException e) {
			System.out.println("Delete Failed!!");
			System.out.println("Returning to Doctor Menu");
		}
		
	}
	

}
