package com.codingNinjas.Bank.Account.Registration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
  This class is an implementation of a User Interface based on the selection 
  done in the console for user information.You need to complete this class 
  based on the following tasks.

   a. Adding common attributes: 
       1. String name
       2. List<Account> accountList.
   b. Override the methods of User Interface.
   c. Build the logic for all the methods based on the description mentioned in the Account Interface.

**/
@Component("myUser")
public class myUser implements User{
	String name;
	List<Account> accountlist;
	
	public void init() {
		System.out.println("user has been instantiated and i'm the init() method");
	}
	public myUser() {
		this.accountlist = new ArrayList<Account>();
	}
	@Override
	public void setUserDetails(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}
	@Override
	public void addAccount(Account account) {
		// TODO Auto-generated method stub
		this.accountlist.add(account);
	}
	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return accountlist;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public void destroy() {
		System.out.println("User has been closed and i'm the destroy() method");
	}
}
