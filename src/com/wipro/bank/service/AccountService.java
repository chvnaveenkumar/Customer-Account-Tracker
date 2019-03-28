package com.wipro.bank.service;

import java.util.*;

import com.wipro.bank.bean.Account;
import com.wipro.bank.bean.Customer;
import com.wipro.bank.dao.AccountDAO;

public class AccountService {
	
	AccountDAO accountDAO = new AccountDAO();

	public String addAccount(Account acc){
		accountDAO.accounts.add(acc);
	return "SUCCESS";
	}
	
	public List<Account> getAllAccounts(){
		return accountDAO.getAccounts();
	}
	
	public List<Customer> getAllCustomers(){
		List<Account>  allCustomers= new ArrayList<Account>();
		return new AccountDAO().getCustomers();
	}

	//	This method is expected to return transfer status like “ID MISATCH” or 
	//  “INSUFFICIENT FUNDS” or “SUCCESS” only.
	//	It iterates through “accounts” to find existence id’s for both payer and beneficiary, 
	//  if both found and if payer has sufficient funds then updates the balance for both accounts suitably.
	public String transferFunds(int from,int to,double amount){
		List<Account> listAccounts = accountDAO.getAccounts();
		Account accountBalance  = null;
		String transferStatus = "";
		Boolean payerfrom = false, payerto = false;
		double balancefrom = 0.0, balanceto = 0.0;
		int indexfrom = 0, indexto = 0;
		for(int i=0;i<listAccounts.size();i++){
			if(from == listAccounts.get(i).getAccountID()){
				balancefrom = listAccounts.get(i).getBalance();
				payerfrom = true;
				indexfrom = i;
			}
			if(to == listAccounts.get(i).getAccountID()){
				balanceto = listAccounts.get(i).getBalance();
				payerto = true;
				indexto = i;
			}
			if( payerfrom && payerto){
				if(balancefrom >= amount){
					listAccounts.get(indexfrom).setBalance(listAccounts.get(indexfrom).getBalance() - amount);
					listAccounts.get(indexto).setBalance(listAccounts.get(indexto).getBalance() + amount);
					transferStatus = "SUCCESS";
				}else{
					transferStatus = "INSUFFICIENT FUNDS"; 					
				}
				break;
			}else{
				transferStatus = "ID MISATCH";
			}
		}
		return transferStatus;
	}

	//	This method is expected to return account details by mapping account number.
	//  It iterates through “accounts” to find existence of received account number, 
	//	if account number found it will return account object (details). Otherwise “null” to be returned.
	public Account getBalanceOf(int accountNumber){
		List<Account> listAccounts = accountDAO.getAccounts();
		Account accountBalance  = null;
		for(int i=0;i<listAccounts.size();i++){
			if(accountNumber == listAccounts.get(i).getAccountID()){
				accountBalance = listAccounts.get(i);
			}
		}
		return accountBalance;
	}
}
