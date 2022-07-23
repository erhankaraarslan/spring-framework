package com.karaarslan.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.karaarslan.aopdemo.dao.AccountDAO;
import com.karaarslan.aopdemo.dao.MemberShipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		MemberShipDAO theMemberShipDAO = context.getBean("memberShipDAO", MemberShipDAO.class);

		// call the business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount);

		// call the theMemberShipDAO.addAccount
		theMemberShipDAO.addSillyMember();

		// close the context
		context.close();
	}

}
