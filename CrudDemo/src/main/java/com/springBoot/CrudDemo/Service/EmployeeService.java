package com.springBoot.CrudDemo.Service;

import java.util.List;

import com.springBoot.CrudDemo.Entity.Employee;

public interface EmployeeService {
	public List<Employee> getEmployeesList();

	public Employee getEmployee(int id);

	public void saveEmployee(Employee employee);

	public void deleteEmployee(int id);
}
