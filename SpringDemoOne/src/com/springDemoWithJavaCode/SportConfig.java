package com.springDemoWithJavaCode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.springDemoWithJavaCode")
@PropertySource("classpath:sport.properties")
public class SportConfig 
{
	/*
	 * If we are not using configuration scan annotation, we have define beans as 
	 * following
	 */
	
	@Bean
	public FortuneService goodFortune()
	{
		return new GoodFortune();
	}
	
	@Bean
	public Coach swimCoach()
	{
		return new SwimCoach(goodFortune());
	}
}
