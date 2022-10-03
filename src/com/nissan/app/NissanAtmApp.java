package com.nissan.app;

import java.util.Scanner;

import com.nissan.doe.CustomerDao;

public class NissanAtmApp {

	// Display the main menu for the user
	public static void main(String[] args) {
		mainMenu();
	}

	// Declaring the main menu
	public static void mainMenu() {

		Scanner scanner = new Scanner(System.in);

		try {

			System.out.println("Welcome to atm services :)");
			System.out.println("1. Customer services\n2. Banking services\n3. Exit\nPlease enter your selection");

			switch (Integer.parseInt(scanner.next())) {
			case 1:
//				if (CustomerDao.verifyCustomer()) {
//					CustomerDao.customerServicesMenu();
//				} else {
//					System.out.println("Sorry! your account has been locked for 24 hrs!");
//				}
				CustomerDao.customerServicesMenu();
				break;
			case 2:
				if (CustomerDao.verifyAdmin()) {
					CustomerDao.bankServicesMenu();
				} else {
					System.out.println("Sorry you can't access bank services");
				}
				CustomerDao.bankServicesMenu();
				break;
				
			case 3: 
				System.out.println("\nThank you for using our services!");
				break;
			default:
				System.out.println("Invalid selection!");
			}

		} catch (Exception ex) {
			System.out.println("Something error happened, PLEASE TRY AGAIN!");
		}
	}
}