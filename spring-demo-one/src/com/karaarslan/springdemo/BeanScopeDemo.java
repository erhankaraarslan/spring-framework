package com.karaarslan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemo {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

		Coach theCoach=context.getBean("myCoach",Coach.class);
		
		Coach alphaCoach=context.getBean("myCoach",Coach.class);
		
		boolean result= theCoach==alphaCoach;
		
		System.out.println("\nresult :"+result);
		System.out.println("\nMemory location for theCoach :"+theCoach);
		System.out.println("\nMemory location for theCoach :"+alphaCoach);
		
		context.close();
	}

}
