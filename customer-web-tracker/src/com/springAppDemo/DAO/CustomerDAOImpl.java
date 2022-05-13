package com.springAppDemo.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springAppDemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO 
{
	@Autowired
	private SessionFactory factory;
	
	// the context for hibernate @transactional is provided by service layer
	@Override
	public List<Customer> getCustomers() 
	{
		Session session = factory.getCurrentSession();
		
		Query<Customer> query = session.createQuery("from Customer order by lastName",
				Customer.class);
		
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) 
	{
		Session session = factory.getCurrentSession();
		
		// save if primary key is empty/null, update if not
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int customerId) {
		Session session = factory.getCurrentSession();
		
		Customer customer = session.get(Customer.class, customerId);
		return customer;
	}

	@Override
	public void delete(Customer customer) {
		Session session = factory.getCurrentSession();
		
		session.delete(customer);
		
	}

	@Override
	public List<Customer> searchCustomers(String searchName) 
	{
		Session session = factory.getCurrentSession();
		
		Query<Customer> query = session.createQuery("from Customer where "
				+ "lower(firstName) like :theName or "
				+ "lower(lastName) like :theName order by lastName",
				Customer.class);
		
		query.setParameter("theName", "%" + searchName.toLowerCase() + "%");
		
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

}
