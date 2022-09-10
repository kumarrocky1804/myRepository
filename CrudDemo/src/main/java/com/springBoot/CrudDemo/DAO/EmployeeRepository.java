package com.springBoot.CrudDemo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.CrudDemo.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// no need for impl class
}
