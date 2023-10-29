package com.audit.banking.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audit.banking.entity.Transaction;
import com.audit.banking.repository.TransactionRepository;

@Service
public class TransactionService {

	private final TransactionRepository transactionRepository;

	@Autowired
	public TransactionService(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

	// Create a new account
	public Transaction createTransaction(Transaction transaction) throws ClassNotFoundException, SQLException {
		transactionRepository.createTransaction(transaction);
		return transaction;
	}

	// Read a single account by ID
	public List<Transaction> getTransactionById(String id) throws ClassNotFoundException, SQLException{
		return transactionRepository.getTransactionById(id);
	}
}
