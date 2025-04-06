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
	
	/*
	 * this annotation is most useful in cases of third party apps where you cannot edit code to add @Component
	 * You can create a wrapper function to return the instance of that third party app and use this @Bean
	 * to create bean for that app.
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
