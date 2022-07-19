package com.karaarslan.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SupportConfig.class);

		Coach theCoach=context.getBean("swimCoach",Coach.class);
		
		System.out.println(theCoach.getDailyWourkout());
		System.out.println(theCoach.getDailyFortune());
		
		context.close();
	}
}
