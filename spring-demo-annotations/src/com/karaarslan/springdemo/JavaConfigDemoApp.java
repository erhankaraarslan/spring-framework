package com.karaarslan.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SupportConfig.class);

		Coach theCoach=context.getBean("tennisCoach",Coach.class);
		
		Coach alphaCoach=context.getBean("tennisCoach",Coach.class);
		
		boolean result=theCoach==alphaCoach;
		
		System.out.println("result : "+result);
		System.out.println("theCoach memory location :" +theCoach);
		System.out.println("alphaCoach memory location :" +alphaCoach);
		
		context.close();
	}
}
