package com.springBoot.ThymeleafDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springBoot.ThymeleafDemo.Entity.Employee;
import com.springBoot.ThymeleafDemo.Service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;

	@GetMapping("/list")
	public String getEmployees(Model model)
	{
		List<Employee> list = service.getEmployeesList();
		
		model.addAttribute("employees", list);
		
		return "list-employees";
	}
	
	@GetMapping("/showAddForm")
	public String showAddFormEmployee(Model model)
	{
		Employee employee = new Employee();
		
		model.addAttribute("newEmployee", employee);
		
		return "addEmployeeForm";
	}
	
	@GetMapping("/showUpdateForm")
	public String showUpdateFormEmployee(@RequestParam("employeeId") int id, Model model)
	{
		Employee employee = service.getEmployee(id);
		
		model.addAttribute("newEmployee", employee);
		
		return "addEmployeeForm";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("newEmployee") Employee newEmployee)
	{
		service.saveEmployee(newEmployee);
		
		//redirect. to save duplicate submit
		return "redirect:/employees/list";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int id)
	{
		service.deleteEmployee(id);
		
		//redirect. to save duplicate submit
		return "redirect:/employees/list";
	}
	
}
