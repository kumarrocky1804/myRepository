package com.springSecurityDemo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

/*
 * Config class for spring security
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{
	@Autowired
	private DataSource securityDataSource;
	
	// if using custom login form
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http.authorizeRequests()
		// any request should be authorized
		//.anyRequest().authenticated()
		/* ROle specific pages */
		.antMatchers("/").hasRole("EMPLOYEE")
		.antMatchers("/leaders/**").hasRole("MANAGER")
		.antMatchers("/system/**").hasRole("ADMIN")
		.and()
		.formLogin()
		// login form page, have to create get mapping for this
		.loginPage("/showLoginForm")
		// login processor, no need to create mapping, spring security will do it
		// just need to pass username and password to this controller with POST method
		.loginProcessingUrl("/authUser")
		.permitAll()
		//logout support
		.and().logout().permitAll()
		// custom access denied page
		.and().exceptionHandling()
		.accessDeniedPage("/access-denied");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		//pass the data source here
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}
	
}
