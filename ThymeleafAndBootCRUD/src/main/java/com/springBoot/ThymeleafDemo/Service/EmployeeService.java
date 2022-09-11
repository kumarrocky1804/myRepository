package com.springBoot.ThymeleafDemo.Service;

import java.util.List;

import com.springBoot.ThymeleafDemo.Entity.Employee;

public interface EmployeeService {
	public List<Employee> getEmployeesList();

	public Employee getEmployee(int id);

	public void saveEmployee(Employee employee);

	public void deleteEmployee(int id);
}
