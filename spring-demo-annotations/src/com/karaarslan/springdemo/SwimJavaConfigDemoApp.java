package com.karaarslan.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SupportConfig.class);

		SwimCoach theCoach=context.getBean("swimCoach",SwimCoach.class);
		
		System.out.println(theCoach.getDailyWourkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println("email :"+theCoach.getEmail());
		System.out.println("team  :"+theCoach.getTeam());
		context.close();
	}
}
