package com.wipro.bank.dao;
import java.util.*;

import com.wipro.bank.bean.*;

public class AccountDAO {

	public static List<Account> accounts;
	public static List<Customer> customers;
	
	public static List<Account> getAccounts() {
		return accounts;
	}

	public static void setAccounts(List<Account> accounts) {
		AccountDAO.accounts = accounts;
	}

	public static List<Customer> getCustomers() {
		customers = new ArrayList<Customer>();
		for(int i=0;i<accounts.size();i++){
			customers.add(accounts.get(i).getCustomer());
		}
		return customers;
	}

	public static void setCustomers(List<Customer> customers) {
		AccountDAO.customers = customers;
	}

	//	This method is expected to save//append new Account details to static variable “accounts” along with customers details 
	//	into variable “customers”
	String saveAccount(Account Account) {
		return "";
	}
	
	// This method is expected to return all account details with their customer profile
	public List<Account> findAllAccounts() {
		return new ArrayList<Account>();
	}
	
	// This method is expected to save//append new Customer profile to “customers”
	String saveCustomer (Customer customer){
		return "";
	}
	
	// This method is expected to return all Customers profile
	public List<Account> findAllCustomers() {
		return new ArrayList<Account>();
	}

	
}
