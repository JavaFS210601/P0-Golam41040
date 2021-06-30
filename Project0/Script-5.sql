CREATE TABLE roles (
	role_id serial PRIMARY KEY,	
	role_title TEXT, 
	role_salary INT
);

CREATE TABLE doctors (
	doctor_id serial PRIMARY KEY,	
	f_name TEXT,	
	l_name TEXT,		
	role_id_fk INT REFERENCES roles (role_id) 
	);
	
INSERT INTO roles (role_title, role_salary)		
			VALUES ('Osteopath', 80000),			   
					('Otolaryngologist', 50000),			   
					('Pathologist', 70000),			   
					('Pediatrician', 70000),			   
					('Physiatrist', 60000),
					('Plastic Surgeon',80000),
					('Cardiologist',100000),
					('Dermatologist',70000),
					('Urologist',80000);
					
INSERT INTO doctors (f_name, l_name, role_id_fk)		
			VALUES ('Edie', 'Hayward',1),			   
					('Dinah','Lovell',1),
					('Caelie','Alvey',2),
					('Mikhaila','Albert',2),
					('Madilyn','Clemens',3),
					('Vern','Mathers',3),
					('Aleta','Sands',4),
					('Cree','Abramson',4),
					('Isiah','Morris',5),
					('Berniece','Jewel',5),
					('Wilfred','Derricks',6),
					('Tahnee','Tasker',6),
					('Winifred','Allsopp',7),
					('Sabella','Steed',7),
					('Rudolph','Fitzroy',8),
					('Bishop','Hightower',8),
					('Cayson','Bowman',9),
					('Samson','Varley',9);
					
CREATE TABLE admins(
	admin_id serial PRIMARY KEY,
	admin_name TEXT,
	admin_username TEXT,
	admin_password text
);
SELECT * FROM admins ;

SELECT admin_password FROM admins where admin_username ='Jack123';
CREATE TABLE patients(
	patient_id serial PRIMARY KEY,
	patient_f_name TEXT,
	patient_l_name TEXT,
	patient_age int,
	patient_insurance TEXT,
	emergency_contact TEXT,
	doctor_id_fk int REFERENCES doctors (doctor_id) ON DELETE CASCADE
);

DROP TABLE patients;

SELECT d.doctor_id, d.f_name , d.l_name, r.role_title
FROM doctors d 
JOIN roles r 
ON d.role_id_fk =r.role_id ;

SELECT * FROM patients ;

SELECT patient_Id, patient_f_name, patient_l_name, patient_age, 
		patient_insurance,emergency_contact, 
		concat(f_name,' ',l_name,' (',doctor_id_fk,')') AS Doctor
		FROM patients 
		JOIN doctors 
		ON doctor_id_fk = doctor_id;
		
		
		
UPDATE doctors SET role_id_fk = 8 WHERE doctor_id =7;
		
		
