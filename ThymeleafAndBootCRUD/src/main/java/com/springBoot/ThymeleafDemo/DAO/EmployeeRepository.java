package com.springBoot.ThymeleafDemo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.ThymeleafDemo.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// no need for impl class
	
	// add method to sort by last name
	// this method name will be converted to actual query by spring
	public List<Employee> findAllByOrderByLastNameAsc();
}
