package com.springAppDemo.DAO;

import java.util.List;

import com.springAppDemo.entity.Customer;

public interface CustomerDAO 
{
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int customerId);

	public void delete(Customer customer);

	public List<Customer> searchCustomers(String searchName);
}
