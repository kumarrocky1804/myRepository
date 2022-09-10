package com.springBoot.CrudDemo.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springBoot.CrudDemo.Entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager)
	{
		entityManager = theEntityManager;
	}
	
	@Override	
	public List<Employee> getEmployeesList() {
		Session session = entityManager.unwrap(Session.class);
		
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		
		List<Employee> list = query.getResultList();
		
		return list;
	}

	@Override
	public Employee getEmployee(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Employee employee = session.get(Employee.class, id);
		
		return employee;
	}

	@Override
	public void saveEmployee(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(employee);
		
	}

	@Override
	public void deleteEmployee(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Query query = session.createQuery("delete from Employee where id=:employeeId");
		
		query.setParameter("employeeId", id);
		
		query.executeUpdate();
	}

}
