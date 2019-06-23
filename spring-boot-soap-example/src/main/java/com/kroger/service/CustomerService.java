package com.kroger.service;

import java.util.List;

import com.kroger.customer.ServiceFaultException;
import com.kroger.entity.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();

	Customer getCustomerById(long customerId) throws ServiceFaultException;

	boolean addCustomer(Customer customer) throws ServiceFaultException;

	void updateCustomer(Customer customer) throws ServiceFaultException;

	void deleteCustomer(Customer customer);
}
