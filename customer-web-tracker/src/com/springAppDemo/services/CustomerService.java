package com.springAppDemo.services;

import java.util.List;

import com.springAppDemo.entity.Customer;

public interface CustomerService 
{
	public List<Customer> getCustomers();

	public void save(Customer customer);

	public Customer getCustomer(int customerId);

	public void delete(Customer customer);

	public List<Customer> searchCustomers(String searchName);
}
