package com.karaarslan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach=context.getBean("tennisCoach",Coach.class);
		
		System.out.println(theCoach.getDailyWourkout());
		System.out.println(theCoach.getDailyFortune());
		
		context.close();
		
	}

}
