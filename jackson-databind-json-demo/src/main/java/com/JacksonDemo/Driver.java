package com.JacksonDemo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args)
	{
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			
			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			System.out.println("First Name - " + student.getFirstName());
			System.out.println("LastName - " + student.getLastName());
			
			System.out.println("ID - " + student.getId());
			System.out.println("active - " + student.isActive());
			
			System.out.println("Country- " + student.getAddress().getCountry());
			
			System.out.print("Languages - ");
			
			for(String lang: student.getLanguages())
			{
				System.out.print(lang + ", ");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
