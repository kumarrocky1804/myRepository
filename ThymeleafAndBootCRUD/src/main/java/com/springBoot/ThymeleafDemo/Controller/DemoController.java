package com.springBoot.ThymeleafDemo.Controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController 
{
	@GetMapping("/hello")
	public String sayHello(Model model)
	{
		model.addAttribute("currDate",new Date());
		
		return "helloWorld";
	}
}
