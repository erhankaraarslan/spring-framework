package com.karaarslan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Coach theCoach=context.getBean("tennisCoach",Coach.class);
		
		Coach alphaCoach=context.getBean("tennisCoach",Coach.class);
		
		boolean result=theCoach==alphaCoach;
		
		System.out.println("result : "+result);
		System.out.println("theCoach memory location :" +theCoach);
		System.out.println("alphaCoach memory location :" +alphaCoach);
		
		context.close();
	}
}
