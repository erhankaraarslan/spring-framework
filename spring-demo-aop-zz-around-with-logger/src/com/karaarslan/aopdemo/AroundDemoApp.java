package com.karaarslan.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.karaarslan.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("\nMain program : AroundDemoApp");
		System.out.println("Calling getFortune()");

		String data = theFortuneService.getFortune();

		System.out.println("\nMy fortune is : " + data);
		System.out.println("Finished");

		context.close();
	}

}
