package com.karaarslan.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberShipDAO {
	public void addSillyMember() {
		System.out.println(getClass() + "DOING STUFF: ADDING A MEMBERSHIP ACCOUNT: ");
	}
}
