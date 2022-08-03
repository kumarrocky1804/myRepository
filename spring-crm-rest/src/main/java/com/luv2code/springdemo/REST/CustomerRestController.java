package com.luv2code.springdemo.REST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController 
{
	@Autowired
	private CustomerService service;
	
	/* REQUEST HANDLERS */
	@GetMapping("/customers")
	public List<Customer> getCustomers()
	{
		return service.getCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomers(@PathVariable int customerId)
	{
		Customer customer = service.getCustomer(customerId);
		
		if(customer == null)
			throw new CustomerNotFoundException("Customer not found for ID - " + customerId);
		
		return customer; 
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		//set the primary key to 0 so that the saveOrUpdate method in 
		// service layer treats it as save not update
		customer.setId(0);
		
		service.saveCustomer(customer);
		
		return customer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer)
	{		
		service.saveCustomer(customer);
		
		return customer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId)
	{
		Customer customer = service.getCustomer(customerId);
		
		if(customer == null)
			throw new CustomerNotFoundException("customer not found with ID - "+ customerId);
		
		service.deleteCustomer(customerId);
		
		return "Customer deleted with ID - " + customerId;
	}
}
