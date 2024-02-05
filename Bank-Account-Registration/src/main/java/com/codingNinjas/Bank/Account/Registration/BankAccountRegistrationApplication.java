package com.codingNinjas.Bank.Account.Registration;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class BankAccountRegistrationApplication {

	public static void main(String[] args) {

		/*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.
		
		* 1. Fetch context from ApplicationContext.xml and initiate scanner.
		* 2. Get user details from console.
		* 3. Get account details from user and add them to the account list.
		* 4. Display the list of accounts with their reference ids.
		*/
		ApplicationContext context = new SpringApplication().run(BankAccountRegistrationApplication.class, args);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Account Registration Application !!");
		System.out.println("Please enter your name");
		String name = sc.nextLine();
		User user = context.getBean(User.class);
		user.setUserDetails(name);
		
		Integer choice = 1;
		System.out.println("Do you want to add account?");
		System.out.println("1)YES\n2)NO");
		choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1:
			System.out.println("Please select the account type");
			System.out.println("1)Current\n2)Savings");
			int choice2 = Integer.parseInt(sc.nextLine());
			Account account = null;
			switch (choice2) {
			case 1:
				account = context.getBean(currentAccount.class);
				break;

			case 2:
				account = context.getBean(savingsAccount.class);
				break;
			default:
				break;
			}
			System.out.println("Enter the opening balance");
			double balance = Double.parseDouble(sc.nextLine());
			account.addBalance(balance);
			user.addAccount(account);
			break;

		default:
			break;
		}
		while(choice == 1) {
			System.out.println("Do you want to add more account?");
			System.out.println("1)YES\n2)NO");
			choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				System.out.println("Please select the account type");
				System.out.println("1)Current\n2)Savings");
				int choice2 = Integer.parseInt(sc.nextLine());
				Account account = null;
				switch (choice2) {
				case 1:
					account = context.getBean(currentAccount.class);
					break;

				case 2:
					account = context.getBean(savingsAccount.class);
					break;
				default:
					break;
				}
				System.out.println("Enter the opening balance");
				double balance = Double.parseDouble(sc.nextLine());
				account.addBalance(balance);
				user.addAccount(account);
				break;

			case 2:
				System.out.println("Hi "+user.getName()+"! Here is your account details -");
				for(int i=0;i<user.getAllAccounts().size();i++) {
					System.out.println(user.getAllAccounts().get(i).getAccountType()+
					" : opening balance - "+user.getAllAccounts().get(i).getBalance()+
					" Ref Id "+user.getAllAccounts().get(i).toString());
				}
				break;
				
			default:
				break;
			}
		}
		sc.close();
		//context.close();
	}

}
