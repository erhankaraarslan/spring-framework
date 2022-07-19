package com.karaarslan.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	private FortuneService fortuneService;

//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}

	public TennisCoach() {
		System.out.println(">> TennisCoach : inside default constructor");
	}

//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		System.out.println(">> TennisCoach : inside setter injection");
//		this.fortuneService = fortuneService;
//	}
	
//	@Autowired
//	public void doSomeCrazyStuff(FortuneService fortuneService) {
//		System.out.println(">> TennisCoach : inside doSomeCrazyStuff() method");
//		this.fortuneService = fortuneService;
//	}

	@Override
	public String getDailyWourkout() {

		return "Practise your backhand volley";

	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
