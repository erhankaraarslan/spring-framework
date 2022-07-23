package com.karaarslan.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.karaarslan.aopdemo.Account;

@Component
public class AccountDAO {
	public void addAccount(Account theAccount) {
		System.out.println(getClass() + "DOING MY DB WORK: ADDING AN ACCOUNT: ");
	}
}
