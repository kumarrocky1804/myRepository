package com.springDemoWithJavaCode;

import org.springframework.stereotype.Component;

@Component
public class HardFortune implements FortuneService {

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "You need to work hard";
	}

}
