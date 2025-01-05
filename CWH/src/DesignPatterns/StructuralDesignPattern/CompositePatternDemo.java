package DesignPatterns.StructuralDesignPattern;

import java.util.ArrayList;

/* This is used If programmers find that they are using multiple objects in the same way, 
 * and often have nearly identical code to handle each of them
 * - Link - https://www.geeksforgeeks.org/composite-design-pattern/
 * 
 * Structural Design Pattern
 */

interface Employee
{
	public void showEmployeeDetails();
}

class Developer implements Employee
{
	private String name;
	private String post;
	
	public Developer(String name, String post)
	{
		this.name = name;
		this.post = post;
	}
	
	@Override
	public void showEmployeeDetails()
	{
		System.out.println("Post - " + post + " And Name - " + name);
	}
}

class Manager implements Employee
{
	private String name;
	private String post;
	
	public Manager(String name, String post)
	{
		this.name = name;
		this.post = post;
	}
	
	@Override
	public void showEmployeeDetails()
	{
		System.out.println("Post - " + post + " And Name - " + name);
	}
}

// common functionality at a place 
class CompanyDirectory implements Employee
{
	private ArrayList<Employee> list = new ArrayList<Employee>();

	@Override
	public void showEmployeeDetails() 
	{
		for(Employee e : list)
		{
			e.showEmployeeDetails();
		}
	}
	
	public void addEmployee(Employee e)
	{
		list.add(e);
	}
	
	public void removeEmployee(Employee e)
	{
		list.remove(e);
	}
	
	
}

public class CompositePatternDemo 
{
	public static void main(String[] args) {
		CompanyDirectory dir = new CompanyDirectory();
		
		dir.addEmployee(new Developer("XYZ", "JS developer"));
		dir.addEmployee(new Developer("ABC","Java developer"));
		dir.addEmployee(new Manager("Manager A", "Development Manager"));
		dir.addEmployee(new Manager("Manager B", "QA Manager"));
		
		dir.showEmployeeDetails();
	}
}
