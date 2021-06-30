package com.revature.models;

public class Admin {
	private int admin_id;
	private String admin_name;
	private String admin_username;
	private String admin_password;
	
	
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public Admin(String admin_name, String admin_username, String admin_password) {
		super();
		this.admin_name = admin_name;
		this.admin_username = admin_username;
		this.admin_password = admin_password;
	}
	



	public int getAdmin_id() {
		return admin_id;
	}



	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}



	public String getAdmin_name() {
		return admin_name;
	}



	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}



	public String getAdmin_username() {
		return admin_username;
	}



	public void setAdmin_username(String admin_username) {
		this.admin_username = admin_username;
	}



	public String getAdmin_password() {
		return admin_password;
	}



	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + admin_id;
		result = prime * result + ((admin_name == null) ? 0 : admin_name.hashCode());
		result = prime * result + ((admin_password == null) ? 0 : admin_password.hashCode());
		result = prime * result + ((admin_username == null) ? 0 : admin_username.hashCode());
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
		Admin other = (Admin) obj;
		if (admin_id != other.admin_id)
			return false;
		if (admin_name == null) {
			if (other.admin_name != null)
				return false;
		} else if (!admin_name.equals(other.admin_name))
			return false;
		if (admin_password == null) {
			if (other.admin_password != null)
				return false;
		} else if (!admin_password.equals(other.admin_password))
			return false;
		if (admin_username == null) {
			if (other.admin_username != null)
				return false;
		} else if (!admin_username.equals(other.admin_username))
			return false;
		return true;
	}

}
