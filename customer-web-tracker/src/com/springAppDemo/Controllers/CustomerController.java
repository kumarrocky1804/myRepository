package com.springAppDemo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springAppDemo.entity.Customer;
import com.springAppDemo.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController 
{
	/*
	 * controller talks to service layer and service layer gathers data from 
	 * DAOs
	 */
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model model)
	{
		List<Customer> customers = customerService.getCustomers();
		
		model.addAttribute("customers", customers);
		
		return "list-customer";
	}
	
	@GetMapping("/addCustomerForm")
	public String addCustomerForm(Model model)
	{
		//adding empty object in the attribute to bind the form with object
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		return "add-customer";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer)
	{
		System.out.println("BEFORE SAVE - " + customer);
		customerService.save(customer);
		System.out.println("AFTER SAVE - " + customer);
		// we cannot do this because the list-customer will not have the model attributes
		//return "list-customer";
		// instead redirect to the request
		return "redirect:/customer/list";
	}
	
	@GetMapping("/updateCustomerForm")
	public String updateCustomerForm(@RequestParam("customerId") int customerId,Model model)
	{
		Customer customer = customerService.getCustomer(customerId);
		
		model.addAttribute("customer", customer);
		return "add-customer";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int customerId, Model model)
	{
		customerService.delete(customerService.getCustomer(customerId));
		
		return "redirect:/customer/list";
	}
	
	/*
	 * SEARCHING FUnctionality
	 */
	@GetMapping("/search")
	public String searchCustomers(@RequestParam("searchName") String searchName,
			Model model)
	{
		List<Customer> customers = customerService.searchCustomers(searchName);
		
		model.addAttribute("customers", customers);
		
		return "list-customer";
	}
}
