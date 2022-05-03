package com.hibernate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.hibernate.CRUD.DateUtils;

@Entity
@Table(name = "student")
public class Student 
{
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)// without this, we were not getting the 
								// new ID value back from SQL
	@Column(name = "id") // if column name is same, name is not required
	private int id; // needs to be integer to be made auto_increment
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name="date_of_birth")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	public Student()
	{
		// without this, we were getting some errors in hibernate operations
		// read operation was throwing error. Possible reason is that the operation
		// is creating an empty object and then using setters to build the object's 
		// properties
	}
	
	public Student(String firstName, String lastName, String email, Date dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString()
	{
		return "[ID=" + this.id + " NAME=" + this.firstName+this.lastName + " email=" +
					this.email + " DOB=" + DateUtils.dateToString(this.dateOfBirth) + "]";
		
	}
}
