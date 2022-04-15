package com.springDemoAnnotations;

import org.springframework.stereotype.Component;

@Component
public class GoodFortune implements FortuneService {

	@Override
	public String getDailyFortune() {
		return "This is your lucky day!!";
	}

}
