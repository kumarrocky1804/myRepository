package com.springBoot.ThymeleafDemo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.ThymeleafDemo.DAO.EmployeeRepository;
import com.springBoot.ThymeleafDemo.Entity.Employee;

@Service
public class EmployeeServiceImplBySpringData implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public List<Employee> getEmployeesList() {
		return repository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee getEmployee(int id) {
		Optional<Employee> result = repository.findById(id);
		
		Employee employee = null;
		if(result.isPresent())
		{
			employee = result.get();
		}
		else
		{
			throw new RuntimeException("COuld not find employee with ID - " + id);
		}
		return employee;
	}

	@Override
	public void saveEmployee(Employee employee) {
		repository.save(employee);

	}

	@Override
	public void deleteEmployee(int id) {
		repository.deleteById(id);

	}

}
