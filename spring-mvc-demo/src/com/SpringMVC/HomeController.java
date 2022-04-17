package com.SpringMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController 
{
	@RequestMapping("/")
	public String showPage()
	{
		// It return the "prefix" + string + "suffix" file from view
		// prefix and suffix are defined in XML files
		return "main-menu";
	}
}
