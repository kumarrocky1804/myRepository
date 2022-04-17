package com.SpringMVC;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController 
{
	@RequestMapping("/showForm")
	public String showForm(Model model)
	{		
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	// The binding result will catch the errors
	// if error, return to form page which has tags to display the errors
	// else confirmation page
	// very important to have binding result object right after model attribute
	public String processForm(@Valid @ModelAttribute("customer") Customer customer, 
			BindingResult result)
	{
		System.out.println("The student - " + customer.getFirstName() +
			" " + customer.getLastName());
		System.out.println("Errors in vallidation " + result);
		System.out.println("\n\n\n");
		if(result.hasErrors())
		{
			return "customer-form";
		}
		
		return "customer-confirmation";
	}
	
	// will process before any requests
	// trimming whitespaces
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		//creating string trim editor
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		//applying editor for string class objects
		binder.registerCustomEditor(String.class, editor);
	}
}
