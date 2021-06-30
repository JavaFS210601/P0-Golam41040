package com.revature.models;

public class Doctor {
	private int doctor_id;
	private String f_name;
	private String l_name;
	private int role_id;
	private String role_name;
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(int doctor_id, String f_name, String l_name, int role_id,String role_name ) {
		super();
		this.doctor_id = doctor_id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.role_id = role_id;
		this.role_name =role_name;
	}
	public Doctor(String f_name, String l_name, int role_id) {
		super();
		this.f_name = f_name;
		this.l_name = l_name;
		this.role_id = role_id;
	}
	
	@Override
	public String toString() {
		System.out.println("Dr. "+ f_name + " "+l_name + "      ID: " + doctor_id+ "       Role: " + role_name ); 
		return null;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + doctor_id;
		result = prime * result + ((f_name == null) ? 0 : f_name.hashCode());
		result = prime * result + ((l_name == null) ? 0 : l_name.hashCode());
		result = prime * result + role_id;
		result = prime * result + ((role_name == null) ? 0 : role_name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		if (doctor_id != other.doctor_id)
			return false;
		if (f_name == null) {
			if (other.f_name != null)
				return false;
		} else if (!f_name.equals(other.f_name))
			return false;
		if (l_name == null) {
			if (other.l_name != null)
				return false;
		} else if (!l_name.equals(other.l_name))
			return false;
		if (role_id != other.role_id)
			return false;
		if (role_name == null) {
			if (other.role_name != null)
				return false;
		} else if (!role_name.equals(other.role_name))
			return false;
		return true;
	}
	
}


