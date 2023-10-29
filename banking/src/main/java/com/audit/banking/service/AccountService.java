package com.audit.banking.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audit.banking.entity.Account;
import com.audit.banking.repository.AccountRepository;
@Service
public class AccountService {


    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Create a new account
    public Account createAccount(Account account) throws ClassNotFoundException, SQLException {
        accountRepository.createAccount(account);
        return account;
    }

    // Read all customers
    public List<Account> getAllAccounts() throws ClassNotFoundException, SQLException{
        return accountRepository.getAllAccounts();
    }

    // Read a single account by ID
    public Account getAccountById(String id) throws ClassNotFoundException, SQLException{
        return accountRepository.getAccountById(id);
    }

    // Update a account
    public Account updateAccount(Account account) throws ClassNotFoundException, SQLException, ParseException{
        accountRepository.updateAccount(account);
        return account;
    }

    // Delete a account
    public void deleteAccount(String id) throws ClassNotFoundException, SQLException{
        accountRepository.deleteAccount(id);
    }

}
