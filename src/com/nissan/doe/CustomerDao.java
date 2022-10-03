package com.nissan.doe;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

import com.nissan.app.NissanAtmApp;
import com.nissan.bean.Customer;

public class CustomerDao {

	// Declaring the array to store customer details
	static ArrayList<Customer> customerArray = new ArrayList<Customer>();

	// Menu Driven Program
	public static void customerServicesMenu() {

		// Declaring the scanner to get the user input
		Scanner scanner = new Scanner(System.in);

		try {
			// Checking with the customer choice
			int customerChoice = 'n';
			do {
				System.out.println("----- Customer Services ------\n");
				System.out.println("1. Depositing money\n2. Withdraw money\n3. Show balance\n4. Exit");

				switch (Integer.parseInt(scanner.next())) {
				case 1:
					//function to deposit money
					depositeMoney(); 
					break;
				case 2:
					//function to withdraw money
					withdrawMoney();
					break;
				case 3:
					//function to show the balance
					showBalance();
					break;
				default:
					
					System.out.println("Invalid selection!");
				}
			} while (customerChoice == 'y' && customerChoice == 'Y');

		} catch (Exception ex) {
			System.out.println("Some error has been occured!");
		}
		
		customerServicesMenu();
	}

	public static void bankServicesMenu() {

		// Declaring the scanner varible
		Scanner scanner = new Scanner(System.in);

		try {

			// Checking with the customer choice
			int customerChoice = 'n';
			do {
//				prompt input from the user
				System.out.println("----- Bank Services ------\n");
				System.out.println("1. Add an account\n2.Update the customer details\n3.Delete the customer\n"
						+ "4.Display the details of a customer\n5.List all customers\n6.Transfer money\n7.Exit");

				switch (Integer.parseInt(scanner.next())) {
				case 1:
					addAccount();
					break;
				case 2:
					updateAccount();
					break;
				case 3:
					deleteAccount();
					break;
				case 4:
					displayAccountDetails();
					break;
				case 5:
					listAllAccounts();
					break;
				case 6:
					transferMoney();
					break;
				case 7:
					NissanAtmApp.mainMenu();
					break;
				default:
					System.err.println("Invalid selection!!");
				}
				;

			} while (customerChoice == 'y' && customerChoice == 'Y');

		} catch (Exception ex) {
			System.out.println("Some error has been occured!");
		}
		
		bankServicesMenu();
	}

	// Function to check the customer balance
	private static void showBalance() {
		// TODO Auto-generated method stub
		try {

			Scanner objScanner = new Scanner(System.in);

			System.out.println("Enter the account number of the customer to show balance: ");
			int _accNo = objScanner.nextInt();

			//defining the customer variable
			for (Customer customer : customerArray) {
				if (customer.getAccountNo()==_accNo) {
					System.out.println("The balance amount is: "+(customer.getAccountBalance()+customer.getMinBalance()));
				}
			}

		} catch (Exception ex) {
			System.out.println("Some error has been occured!");
		}
	}

	// method to with draw money from customer account
	private static void withdrawMoney() {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			try {

				//declaring the scanner object
				Scanner objScanner = new Scanner(System.in);

				//prompt input from the user
				System.out.println("Enter the account number to withdraw money: ");
				int _accNo = objScanner.nextInt();

				// defining the customer object
				for (Customer customer : customerArray) {
					if (customer.getAccountNo()==_accNo) {
						System.out.println("Enter the amount to withdraw..");
						double withdrawAmt = Double.parseDouble(objScanner.next());
						if ((customer.getAccountBalance()-withdrawAmt)>1000.00f){
							customer.setAccountBalance(customer.getAccountBalance()-withdrawAmt);
							System.out.println("Current balance in your account is :"+customer.getAccountBalance());
						}else {
							System.out.println("“Insufficient funds..!!!”5");
						}
					}
				}

			} catch (Exception ex) {
				System.out.println("Some error has been occured!");
			}
		}

	// method for deposit money from the customer
	private static void depositeMoney() {
		
		try {
			Scanner objScanner = new Scanner(System.in);
			// prompt input from the user
			System.out.println("Enter the account number to deposit money:");
			int _accNo = objScanner.nextInt();

			// checking for the customer input in the customer array
			for (Customer customer : customerArray) {
				if (customer.getAccountNo()==_accNo) {
					System.out.println("Enter the amount to deposit..");
					double depositAmt = Double.parseDouble(objScanner.next());
					if (depositAmt>50000) {
						System.out.println("Enter your PAN number to move forward with the transcation..");
						int panNumber = objScanner.nextInt();
						customer.setAccountBalance(customer.getAccountBalance()+depositAmt);
					}else {
						customer.setAccountBalance(customer.getAccountBalance()+depositAmt);
					}
					System.out.println("Current balance in your account is :"+ customer.getAccountBalance());
				}
			}

		} catch (Exception ex) {
			System.out.println("Some error has been occured!");
		}

	}

//	method to handle the money transfer
	private static void transferMoney() {
		// TODO Auto-generated method stub
		
		try {
			Scanner objScanner = new Scanner(System.in);
			
			// prompt input from the user
			System.out.println("Enter the account number to transfer money:");
			int _accNo = objScanner.nextInt();

			for (Customer customerOne : customerArray) {
				if (customerOne.getAccountNo()==_accNo) {
					
					System.out.println("Enter the account number of the recipient :");
					int _recAccNo = Integer.parseInt(objScanner.next());
					
					System.out.println("Enter the amount to transfer: ");
					Double amount = Double.parseDouble(objScanner.next());
					
					for (Customer customerTwo : customerArray) {
						if (customerTwo.getAccountNo()==_recAccNo) {
						 	customerTwo.setAccountBalance(customerTwo.getAccountBalance()+amount); 
						 	customerOne.setAccountBalance(customerOne.getAccountBalance()-amount); 
						}
					}
				}
			}

		} catch (Exception ex) {
			System.out.println("Some error has been occured!");
		}
		
	}

	// function for listing all the customer accounts
	private static void listAllAccounts() {
		// TODO Auto-generated method stub
		
		try {
			// prompt input from the user
			System.out.println("Customer Name\tAccount type\tBalance\tMinimun balance\tMobile Number\tEmail Id\tAtm Pin");  
			System.out.println("--------------------------------------------------------------------------------------------------------------");
			for(Customer customer:customerArray) {
				System.out.println(customer.getAccountNo());
				System.out.println(customer.getAccountNo()+'\t'+'\t'+customer.getCustomerName()+'\t'+customer.getAccountType()+'\t'+'\t'+
							customer.getAccountBalance()+'\t'+customer.getMinBalance()+'\t'+
					customer.getMobileNumber()+'\t'+customer.getEmailId()+'\t'+customer.getAtmPin()+'\n');
			}
			
		}catch(Exception ex) {
			System.out.println("Some error has been occured!");
		}

	}

	// method to display the details of a single customer based on the account number
	private static void displayAccountDetails() {

		// TODO Auto-generated method stub

		try {
			// declaring the scanner object
			Scanner objScanner = new Scanner(System.in);
			
			// prompt input from the user
			System.out.println("Enter the account number of the customer to search: ");
			int _accNo = objScanner.nextInt();

			System.out.println("Customer Name\tAccount type\tBalance\tMinimun balance\tMobile Number\tEmail Id\tAtm Pin");
			System.out.println("------------------------------------------------------------");
			for (Customer customer : customerArray) {
				if (customer.getAccountNo()==_accNo) {
					System.out.println(customer.getAccountNo() + '\t'+ '\t' + customer.getCustomerName() + '\t'
							+ customer.getAccountType() + '\t' + customer.getAccountBalance() + '\t'
							+ customer.getMinBalance() + '\t' + customer.getMobileNumber() + '\t'
							+ customer.getEmailId() + '\t' + customer.getAtmPin());
				}
			}

		} catch (Exception ex) {
			System.out.println("Some error has been occured!");
		}

	}
	
	// function to delete the account of the by the admin
	private static void deleteAccount() {
		// TODO Auto-generated method stub
		try {

			Scanner objScanner = new Scanner(System.in);
			
			System.out.println("Enter the account number of the customer to delete: ");
			int _accNo = objScanner.nextInt();

			// checking for the user account
			for (Customer customer : customerArray) {
				if (customer.getAccountNo()==_accNo) {
					customerArray.remove(customer);
					System.out.println("Congratualtions! Data has been removed successfully..!");
				}
			}

		} catch (Exception ex) {
			System.out.println("Some error has been occured!");
		}

	}

	// update the account of the customer based on user inputs
	private static void updateAccount() {
		// TODO Auto-generated method stub
		try {
			
			// Declaring the scanner
			Scanner objScanner = new Scanner(System.in);

			// Prompt input from the user
			System.out.println("Enter the account number of the customer to update: ");
			int _accNo = objScanner.nextInt();
			
			for (Customer customer : customerArray) {
				if (customer.getAccountNo()==_accNo) {
					updateCustomerById(customer);
				}
			}
			System.out.println("Congratulations! the user has been updated successfully!!");

		} catch (Exception ex) {
			System.out.println("Some error has been occured!");
		}
	}
	
	// to update the customer by account number
	private static void updateCustomerById(Customer customer) {
		// TODO Auto-generated method stub
		
		try {
			Scanner scanner = new Scanner(System.in);
			int option ;
			System.out.println("Enter the field to update: \n1.Account number\n2.Mobile Number\n3.Email Id");
			switch(Integer.parseInt(scanner.next())){
			case 1:
				System.out.println("Enter the account number: ");
				customer.setAccountNo(Integer.parseInt(scanner.next()));
				break;
			case 2:
				System.out.println("Enter the mobile number: ");
				customer.setMobileNumber(Integer.parseInt(scanner.next()));
				break;
			case 3:
				System.out.println("Enter the email id: ");
				customer.setEmailId(scanner.next());
				break;
			default:
				System.out.println("Invalid input!!");
				break;
			}
			
		}catch(Exception ex) {
			System.out.println("Some error has been occured!");
		}
		
	}
	
//	method to create an account
	private static void addAccount() {

		char choice = 'n';

		try {

			do {
//				declaring the scanner and customer variables
				Scanner objScanner = new Scanner(System.in);
				Customer customer = new Customer();

				System.out.println("Enter the customer name: ");
				customer.setCustomerName(objScanner.nextLine());

				System.out.println("Enter the customer account type: \n1. Savings\n2. Current");
				switch (Integer.parseInt(objScanner.next())) {
				case 1:
					customer.setAccountType("Savings");
					break;
				case 2:
					customer.setAccountType("Fixed");
					break;
				default:
					System.out.println("Invalid selection! please try again");
				}

				System.out.println("Enter the customer balance: ");
				customer.setAccountBalance(Double.parseDouble(objScanner.next()));

				System.out.println("Enter the customer mobile number: ");
				customer.setMobileNumber(objScanner.nextInt());

				System.out.println("Enter the customer email id: ");
				customer.setEmailId(objScanner.next());

				customer.setAccountNo(customer.generateAccountNumber());
				customer.setAtmPin(customer.generateAtmPin());
				customer.setMinBalance(1000.00f);
				
				// Defining the customer array
				customerArray.add(customer);
				System.out.println("Congratulations! your account has been added successfully\n");
				System.out.println("Do you want to add another record..? y or n");
				choice = objScanner.next().charAt(0);
			} while (choice == 'y' || choice == 'Y');

		} catch (Exception ex) {
			System.out.println("Something went wrong!");
		}
		// TODO Auto-generated method stub
	}

	// Function to verify the user based on the user input
	public static boolean verifyCustomer() {

		// declaring the scanner
		Scanner customerScanner = new Scanner(System.in);
		try {
			int entry = 0;
			boolean passwordCheck = false;
			int pin;
			
			// Prompt input from the user
			System.out.println("Enter the admin password to continue...\n");
			while (entry < 3) {
				pin = customerScanner.nextInt();
				for (Customer customer : customerArray) {
					if (Integer.parseInt(customerScanner.next()) == customer.getAtmPin()) {
						passwordCheck = true;
						break;
					}
					System.out.println("Sorry wrong password! please retry now\n");
				}
				entry++;
			}

			return passwordCheck;
		} catch (Exception ex) {
			System.out.println("Sorry user, something went wrong!");
			return false;
		}
		// TODO Auto-generated method stub
	}
	
//	fucntion to verify the admin based on the password
	public static boolean verifyAdmin() {

		Scanner adminScanner = new Scanner(System.in);

		try {
			int entry = 0;
			boolean passwordCheck = false;
			String password;

			System.out.println("Enter the admin password to continue...\n");
			while (entry < 3) {
				password = adminScanner.next();
				if (password.equals("admin")) {
					passwordCheck = true;
					break;
				} else {
					System.out.println("Sorry wrong password! please retry now\n");
				}
				entry++;
			}
			return passwordCheck;
		} catch (Exception ex) {
			System.out.println("Something went wrong!");
			return false;
		}
		// TODO Auto-generated method stub
	}
}
