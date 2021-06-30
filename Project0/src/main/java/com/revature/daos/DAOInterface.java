package com.revature.daos;

import java.util.List;

import com.revature.models.Admin;
import com.revature.models.Doctor;
import com.revature.models.Patient;

public interface DAOInterface {
	public void add(Doctor doctor);
	public void add(Patient patient);
	public void add(Admin admin);
	public List<Doctor> viewDoctor();
	public List<Patient> viewPatient();
	public void update(int Id,String column_name,String data_type);
	public void delete(int Id);
	
}
