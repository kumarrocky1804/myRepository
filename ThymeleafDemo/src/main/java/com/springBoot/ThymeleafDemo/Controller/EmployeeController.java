package com.springBoot.ThymeleafDemo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springBoot.ThymeleafDemo.Model.Employee;

@Controller
public class EmployeeController {

	@GetMapping("/employees")
	public String getEmployees(Model model)
	{
		List<Employee> list = new ArrayList();
		
		list.add(new Employee(1, "Leslie", "winkle", "leslie.winkle@email.com"));
		list.add(new Employee(2,"Leonard","Hofstader","leo.donald@gmail.com"));
		
		model.addAttribute("employees", list);
		
		return "list-employees";
	}
	
}
