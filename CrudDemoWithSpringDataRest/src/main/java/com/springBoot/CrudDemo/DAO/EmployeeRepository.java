package com.springBoot.CrudDemo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springBoot.CrudDemo.Entity.Employee;

// for custom URL 
@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// no need for impl class
}
