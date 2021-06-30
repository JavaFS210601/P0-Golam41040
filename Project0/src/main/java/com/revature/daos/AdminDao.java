package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Admin;
import com.revature.models.Doctor;
import com.revature.models.Patient;
import com.revature.utils.ConnectionUtil;

public class AdminDao implements DAOInterface {
	@Override
	public void add(Doctor doctor) {}

	@Override
	public void add(Patient patient) {}
	@Override
	public List<Doctor> viewDoctor() {
		return null;
	}
	@Override
	public List<Patient> viewPatient() {	
		return null;
	}
	@Override
	public void update(int Id, String column_name, String data_type) {}
	@Override
	public void delete(int Id) {}
	
	
	
	
	
	
	@Override
	public void add(Admin admin) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO admins( admin_name, admin_username, admin_password )"
					+ "VALUES(?,?,?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,admin.getAdmin_name());
			ps.setString(2,admin.getAdmin_username());
			ps.setString(3,admin.getAdmin_password() );
			
			ps.executeUpdate();
			
			
			
		}catch(SQLException e) {
			System.out.println("Adding Doctor Failed!!");
			e.printStackTrace();
		}
		
	
	}
	public boolean check(String userName,String password) {
		String dbPassword=null;
		try(Connection conn = ConnectionUtil.getConnection()){
			ResultSet rs =null;
			String sql ="SELECT admin_password FROM admins where admin_username = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1,userName);
			rs = ps.executeQuery();
			while(rs.next()) {
				dbPassword=rs.getString("admin_password");
			}
			if(dbPassword==null) {
				System.out.println("Wrong Username given!!");
				return false;
			}
			
			if (dbPassword.equals(password)) {
				return true;
			}
			else {
				System.out.println("The password does not match for this Username.");
				return false;
			}
		}catch(SQLException e) {
			System.out.println("Log in Failled!!");
		}
		return false;
	}

}
