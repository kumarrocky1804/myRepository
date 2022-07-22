package com.springSecurityDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController 
{
	@GetMapping("/showLoginForm")
	public String loginForm()
	{
		return "bootstrap-login";
	}
	
	@GetMapping("/access-denied")
	public String accessDeniedPage()
	{
		return "accessDenied";
	}
}
