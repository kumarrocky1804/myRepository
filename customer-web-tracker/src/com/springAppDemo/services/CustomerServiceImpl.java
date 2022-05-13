package com.springAppDemo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springAppDemo.DAO.CustomerDAO;
import com.springAppDemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService 
{
	@Autowired
	private CustomerDAO customerDAO;
	
	@Transactional
	@Override
	public List<Customer> getCustomers() 
	{		
		return customerDAO.getCustomers();
	}

	@Transactional
	@Override
	public void save(Customer customer) {
		customerDAO.saveCustomer(customer);
	}
	
	@Transactional
	@Override
	public Customer getCustomer(int customerId) {
		return customerDAO.getCustomer(customerId);
	}
	
	@Transactional
	@Override
	public void delete(Customer customer) 
	{
		customerDAO.delete(customer);
	}
	
	@Transactional
	@Override
	public List<Customer> searchCustomers(String searchName) 
	{
		// if no search string then return all customers
		if(searchName=="" || searchName==null)
			return customerDAO.getCustomers();
		
		return customerDAO.searchCustomers(searchName);
	}

}
