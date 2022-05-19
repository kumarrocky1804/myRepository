package com.AOPDemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//Spring AOP proxy support
@EnableAspectJAutoProxy
@ComponentScan("com.AOPDemo")
public class DemoConfig {

}
