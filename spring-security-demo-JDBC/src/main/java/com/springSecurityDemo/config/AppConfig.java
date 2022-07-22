package com.springSecurityDemo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * we will configure the project with all java code and no XML
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.springSecurityDemo")
//this file is loaded in classpath by Maven as it is in standard directory of Maven
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig 
{
	// this will read and hold data from properties file
	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// view resolver
	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	//Bean for data source
	@Bean
	public DataSource securityDataSource()
	{
		//create connection pool
		ComboPooledDataSource securityDataSource = 
				new ComboPooledDataSource();
		
		// set jdbc driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		//log
		logger.info(">>>JDBC URL - " + env.getProperty("jdbc.url"));
		logger.info(">>>JDBC User - " + env.getProperty("jdbc.user"));
		logger.info(">>>JDBC Password - " + env.getProperty("jdbc.password"));
		logger.info(">>>JDBC Initial pool size - " + getIntProperty("connection.pool.initialPoolSize"));
		logger.info(">>>JDBC Max pool size - " + getIntProperty("connection.pool.maxPoolSize"));
		logger.info(">>>JDBC Min Pool size - " + getIntProperty("connection.pool.minPoolSize"));
		logger.info(">>>JDBC Max Idle Time - " + getIntProperty("connection.pool.maxIdleTime"));
		
		//set DB connection props
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		//set connection pool props
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
			
		
		return securityDataSource;
	}
	
	private int getIntProperty(String prop)
	{
		return Integer.parseInt(env.getProperty(prop));
	}
}
