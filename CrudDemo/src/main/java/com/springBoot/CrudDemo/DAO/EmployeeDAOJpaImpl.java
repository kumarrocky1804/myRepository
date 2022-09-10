package com.springBoot.CrudDemo.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springBoot.CrudDemo.Entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> getEmployeesList() {
		TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
		
		List<Employee> list = query.getResultList();
		
		return list;
	}

	@Override
	public Employee getEmployee(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		
		return employee;
	}

	@Override
	public void saveEmployee(Employee employee) {
		Employee newEmployee  = entityManager.merge(employee);
		
		// update this id with DB returned ID for further save or insert
		employee.setId(newEmployee.getId());
	}

	@Override
	public void deleteEmployee(int id) {
		Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
		
		query.setParameter("employeeId", id);
		
		query.executeUpdate();
	}

}
