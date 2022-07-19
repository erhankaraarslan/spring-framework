package com.karaarslan.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}

	public TennisCoach() {
		System.out.println(">> TennisCoach : inside default constructor");
	}

	//define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach : inside doMyStartupStuff() method");
	}
	//define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach : inside doMyCleanupStuff() method");
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
