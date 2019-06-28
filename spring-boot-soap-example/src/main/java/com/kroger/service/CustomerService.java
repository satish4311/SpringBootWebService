package com.kroger.service;

import java.util.List;

import com.kroger.customer.ServiceFaultException;
import com.kroger.entity.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();

	Customer getCustomerById(long customerId) ;

	Customer addCustomer(Customer customer) ;

	void updateCustomer(Customer customer) ;

	void deleteCustomer(Customer customer);
}
