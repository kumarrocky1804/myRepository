package com.SpringMVC;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController 
{
	@RequestMapping("/showForm")
	public String showForm()
	{
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm()
	{
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersion2")
	public String letsShout(HttpServletRequest request, Model model)
	{
		String name = request.getParameter("studentName");
		
		model.addAttribute("message", "YO !" + name.toUpperCase());
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersion3")
	public String processForm3(@RequestParam("studentName") String name, Model model)
	{		
		model.addAttribute("message", "YO !" + name.toUpperCase());
		return "helloworld";
	}
}
