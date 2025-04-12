package com.SpringMVC;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.SpringMVC.Validation.CourseCode;

public class Customer 
{
	private String firstName;
	
	@NotNull
	@Size(min=3,message = "should be atleast 3")
	private String lastName;
	
	@Min(value = 1, message="should be atleast 1")
	@Max(value = 5, message="should be atmost 5")
	private int freePasses;
	
	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
	private String postalCode;
	
	// custom validator
	// if we dont pass anything default value and message will be used
	// Useful when you have the same kind of constraint but value is different
	// for different clients
	//@CourseCode("DD")
	@CourseCode
	private String courseCode;
		
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
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
	public int getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
