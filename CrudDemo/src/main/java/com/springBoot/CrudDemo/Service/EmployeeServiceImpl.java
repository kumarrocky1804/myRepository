package com.springBoot.CrudDemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springBoot.CrudDemo.DAO.EmployeeDAO;
import com.springBoot.CrudDemo.Entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	@Qualifier("employeeDAOJpaImpl")
	private EmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public List<Employee> getEmployeesList() {
		return employeeDAO.getEmployeesList();
	}

	@Override
	@Transactional
	public Employee getEmployee(int id) {
		return employeeDAO.getEmployee(id);
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		employeeDAO.saveEmployee(employee);
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		employeeDAO.deleteEmployee(id);
	}

}
