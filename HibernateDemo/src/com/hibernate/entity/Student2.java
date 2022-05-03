package com.hibernate.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student2 
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

	public Student2()
	{
		// without this, we were getting some errors in hibernate operations
		// read operation was throwing error. Possible reason is that the operation
		// is creating an empty object and then using setters to build the object's 
		// properties
	}

	public Student2(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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

	@Override
	public String toString()
	{
		return "[ID=" + this.id + " NAME=" + this.firstName+this.lastName + " email=" +
				this.email + "]";

	}
	
	/***************************************
	 * for many to many with courses
	 */
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST
			,CascadeType.REFRESH},
			fetch = FetchType.LAZY)
	@JoinTable(name = "course_student",
			joinColumns = @JoinColumn(name="student_id"),
			inverseJoinColumns = @JoinColumn(name="course_id"))
	private List<Course> courses;

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
