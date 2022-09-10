package com.springBoot.CrudDemo.REST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.CrudDemo.Entity.Employee;
import com.springBoot.CrudDemo.Service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	@Qualifier("employeeServiceImplBySpringData")
	private EmployeeService service;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return service.getEmployeesList();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId)
	{
		Employee employee = service.getEmployee(employeeId);
		
		if(employee == null)
		{
			throw new RuntimeException("Employee not found for ID - " + employeeId);
		}
		
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee newEmployee)
	{
		// force add
		newEmployee.setId(0);
		
		service.saveEmployee(newEmployee);
		
		return newEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee newEmployee)
	{
		service.saveEmployee(newEmployee);
		
		return newEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId)
	{
		Employee employee = service.getEmployee(employeeId);
		
		if(employee == null)
		{
			throw new RuntimeException("Employee not found for ID - " + employeeId);
		}
		
		service.deleteEmployee(employeeId);
		
		return "deleted employee with ID - " + employeeId;
	}
}
