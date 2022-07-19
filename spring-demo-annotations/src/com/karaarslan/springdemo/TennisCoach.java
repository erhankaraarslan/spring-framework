package com.karaarslan.springdemo;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Override
	public String getDailyWourkout() {

		return "Practise your backhand volley";

	}

}
