package com.audit.banking.entity;

public class Transaction {
		
	private String modeOfTransaction;
    private String amtOfTransaction;
    private String transactionType;
    private String dot;
    private String transactionNo;
    private String balance;
    private String accountNo;
    
    
    
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getModeOfTransaction() {
		return modeOfTransaction;
	}
	public void setModeOfTransaction(String modeOfTransaction) {
		this.modeOfTransaction = modeOfTransaction;
	}
	public String getAmtOfTransaction() {
		return amtOfTransaction;
	}
	public void setAmtOfTransaction(String amtOfTransaction) {
		this.amtOfTransaction = amtOfTransaction;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getDot() {
		return dot;
	}
	public void setDot(String dot) {
		this.dot = dot;
	}
	public String getTransactionNo() {
		return transactionNo;
	}
	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
    
    
}
