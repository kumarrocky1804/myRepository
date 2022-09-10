package com.springBoot.CrudDemo.DAO;

import java.util.List;

import com.springBoot.CrudDemo.Entity.Employee;

public interface EmployeeDAO {
	public List<Employee> getEmployeesList();
	
	public Employee getEmployee(int id);
	
	public void saveEmployee(Employee employee);
	
	public void deleteEmployee(int id);
}
