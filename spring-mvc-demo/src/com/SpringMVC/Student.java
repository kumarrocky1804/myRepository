package com.SpringMVC;

import java.util.LinkedHashMap;

public class Student 
{
	private String firstName;
	private String lastName;
	private String country;
	private String favouriteLang;
	private String[] OS;
	
	private LinkedHashMap<String, String> countryOptions;
	private LinkedHashMap<String, String> langOptions;
	private LinkedHashMap<String, String> OSOptions;
	
	public LinkedHashMap<String, String> getLangOptions() {
		return langOptions;
	}

	public Student()
	{
		countryOptions = new LinkedHashMap<>();
		
		countryOptions.put("INDIA", "India");
		countryOptions.put("FRANCE", "France");
		countryOptions.put("BRAZIL", "Brazil");
		countryOptions.put("ZAIRE", "Zaire");
		
		langOptions = new LinkedHashMap<>();
		
		langOptions.put("JAVA", "java");
		langOptions.put("RUBY", "ruby");
		langOptions.put("PERL", "perl");
		
		OSOptions = new LinkedHashMap<>();
		
		OSOptions.put("Windows", "MS-WIN");
		OSOptions.put("LINUX", "Linux");
		OSOptions.put("ANDROID", "Android");
	}
	
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getFavouriteLang() {
		return favouriteLang;
	}

	public void setFavouriteLang(String favouriteLang) {
		this.favouriteLang = favouriteLang;
	}

	public LinkedHashMap<String, String> getOSOptions() {
		return OSOptions;
	}

	public String[] getOS() {
		return OS;
	}

	public void setOS(String[] oS) {
		OS = oS;
	}
}
