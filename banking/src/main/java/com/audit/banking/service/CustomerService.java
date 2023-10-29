package com.audit.banking.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audit.banking.entity.Customer;
import com.audit.banking.repository.CustomerRepository;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@Service
public class CustomerService  {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Create a new customer
    public Customer createCustomer(Customer customer) throws ClassNotFoundException, SQLException {
        customerRepository.createCustomer(customer);
        return customer;
    }

    // Read all customers
    public List<Customer> getAllCustomers() throws ClassNotFoundException, SQLException{
        return customerRepository.getAllCustomers();
    }

    // Read a single customer by ID
    public Customer getCustomerById(String id) throws ClassNotFoundException, SQLException{
        return customerRepository.getCustomerById(id);
    }

    // Update a customer
    public Customer updateCustomer(Customer customer) throws ClassNotFoundException, SQLException, ParseException{
        customerRepository.updateCustomer(customer);
        return customer;
    }

    // Delete a customer
    public void deleteCustomer(String id) throws ClassNotFoundException, SQLException{
        customerRepository.deleteCustomer(id);
    }
}
