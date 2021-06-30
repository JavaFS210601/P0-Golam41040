package com.revature.models;

public class Patient {
	private int patient_id;
	private String f_name;
	private String l_name;
	private int patient_age;
	private String emergency_contact ;
	private String patient_insurance;
	private int doctor_id;
	private	String doctor_f_name;
	private	String doctor_l_name;
	
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(String f_name, String l_name, int patient_age,String patient_insurance, String emergency_contact, int doctor_id) {
		super();
		this.f_name = f_name;
		this.l_name = l_name;
		this.patient_age = patient_age;
		this.emergency_contact = emergency_contact;
		this.doctor_id = doctor_id;
		this.patient_insurance=  patient_insurance;
	}
	public Patient(int patient_id,String f_name, String l_name, int patient_age,String patient_insurance, String emergency_contact, String doctor_f_name,String doctor_l_name, int doctor_id) {
		super();
		this.patient_id= patient_id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.patient_age = patient_age;
		this.emergency_contact = emergency_contact;
		this.doctor_f_name = doctor_f_name;
		this.doctor_l_name = doctor_l_name;
		this.doctor_id = doctor_id;
		
		this.patient_insurance=  patient_insurance;
	}
	@Override
	public String toString() {
		System.out.println(f_name + " "+l_name + "      Age: " + patient_age+ "   Patient ID: "+ patient_id+" \nEmergency Contact: " + emergency_contact
				+ " \nInsurance Name: "+patient_insurance+"\nDoctor(ID): "+doctor_f_name+" "+doctor_l_name+" ("+doctor_id+")" ); 
		return null;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
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
	public int getPatient_age() {
		return patient_age;
	}
	public String getPatient_insurance() {
		return patient_insurance;
	}
	public void setPatient_insurance(String patient_insurance) {
		this.patient_insurance = patient_insurance;
	}
	public void setPatient_age(int patient_age) {
		this.patient_age = patient_age;
	}
	public String getEmergency_contact() {
		return emergency_contact;
	}
	public void setEmergency_contact(String emergency_contact) {
		this.emergency_contact = emergency_contact;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getDoctor_f_name() {
		return doctor_f_name;
	}
	public void setDoctor_f_name(String doctor_f_name) {
		this.doctor_f_name = doctor_f_name;
	}
	public String getDoctor_l_name() {
		return doctor_l_name;
	}
	public void setDoctor_l_name(String doctor_l_name) {
		this.doctor_l_name = doctor_l_name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((doctor_f_name == null) ? 0 : doctor_f_name.hashCode());
		result = prime * result + doctor_id;
		result = prime * result + ((doctor_l_name == null) ? 0 : doctor_l_name.hashCode());
		result = prime * result + ((emergency_contact == null) ? 0 : emergency_contact.hashCode());
		result = prime * result + ((f_name == null) ? 0 : f_name.hashCode());
		result = prime * result + ((l_name == null) ? 0 : l_name.hashCode());
		result = prime * result + patient_age;
		result = prime * result + patient_id;
		result = prime * result + ((patient_insurance == null) ? 0 : patient_insurance.hashCode());
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
		Patient other = (Patient) obj;
		if (doctor_f_name == null) {
			if (other.doctor_f_name != null)
				return false;
		} else if (!doctor_f_name.equals(other.doctor_f_name))
			return false;
		if (doctor_id != other.doctor_id)
			return false;
		if (doctor_l_name == null) {
			if (other.doctor_l_name != null)
				return false;
		} else if (!doctor_l_name.equals(other.doctor_l_name))
			return false;
		if (emergency_contact == null) {
			if (other.emergency_contact != null)
				return false;
		} else if (!emergency_contact.equals(other.emergency_contact))
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
		if (patient_age != other.patient_age)
			return false;
		if (patient_id != other.patient_id)
			return false;
		if (patient_insurance == null) {
			if (other.patient_insurance != null)
				return false;
		} else if (!patient_insurance.equals(other.patient_insurance))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
}
