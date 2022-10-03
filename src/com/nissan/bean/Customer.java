package com.nissan.bean;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
	
	// Declaring the instance variables
	private int accountNo;
	private String customerName;
	private String accountType;
	private double accountBalance;
	private double minBalance;
	private int mobileNumber;
	private String emailId;
	private int atmPin;
	
	// Declaring the default constructor
	public Customer() {
		super();
	}
	
	
	// Declaring the parameterised constructor
	public Customer(int accountNo, String customerName, String accountType, double accountBalance, double minBalance,
			int mobileNumber, String emailId, int atmPin) {
		super();
		this.accountNo = accountNo;
		this.customerName = customerName;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.minBalance = minBalance;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.atmPin = atmPin;
	}
	
	
	// getters and setters
	public int getAccountNo() {
		return accountNo;
	}
	
	// account number validation
	public void setAccountNo(int accountNo) {
//		Pattern pattern = Pattern.compile("^[0-9]{0-6}");
//		
//		Matcher matcher = pattern.matcher(Integer.toString(accountNo));
//		
//		boolean finder = matcher.find();
//		
//		if (!finder) {
//			System.out.println("account number should not contain more than 6 numbers");
//		}
		this.accountNo = accountNo;
	}

	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
//		Pattern pattern = Pattern.compile("^{0-30}");
//		
//		Matcher matcher = pattern.matcher(customerName);
//		
//		boolean finder = matcher.find();
//		
//		if (!finder) {
//			System.out.println("Customer name should not be contain more than 30 characters!");
//		}
//		
		this.customerName = customerName;
	}

	
	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public double getAccountBalance() {
		return accountBalance;
	}
	
	// account balance validation
	public void setAccountBalance(double accountBalance) {
//		Pattern pattern = Pattern.compile("^[0-9]{0-6}");
//		
//		Matcher matcher = pattern.matcher(Double.toString(accountBalance));
//		
//		boolean finder = matcher.find();
//		
//		if (!finder) {
//			System.out.println("Invalid account balance!!");
//		}
		this.accountBalance = accountBalance;
	}


	public double getMinBalance() {
		return minBalance;
	}


	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}


	public int getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(int mobileNumber) {
//		Pattern pattern = Pattern.compile("^[0-9]{0-10}");
//		
//		Matcher matcher = pattern.matcher(Integer.toString(mobileNumber));
//		
//		boolean finder = matcher.find();
//		
//		if (!finder) {
//			System.out.println("Phone number should contain 10 digits!");
//		}
//		
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setAtmPin(int atmPin) {
		this.atmPin = atmPin;
	}
	public int getAtmPin() {
		return atmPin;
	}

	// methods declarations
	
	// method to generate account number
	public int generateAccountNumber() {
		Random randomAcc=new Random();
		return (100000000 + randomAcc.nextInt(900000000));
	}
	
	// method to generate atm pin
	public int generateAtmPin() {
		Random randomAtmPin=new Random();
		return (1000 + randomAtmPin.nextInt(9000));
	}
	
}
