package com.kroger.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.CassandraConnectionFailureException;
import org.springframework.stereotype.Service;

import com.kroger.constants.CustomerUtils;
import com.kroger.customer.ServiceFaultException;
import com.kroger.entity.Customer;
import com.kroger.gs_ws.ServiceStatus;
import com.kroger.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static final Logger log = LogManager.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {
		log.info("Inside getAllCustomers() Method ");
		List<Customer> list = new LinkedList<Customer>();
		try {
			customerRepository.findAll().forEach(e -> list.add(e));

			if (list.isEmpty()) {
				ServiceStatus serviceStatus = new ServiceStatus();
				serviceStatus.setMessage(CustomerUtils.CUSTOMER_DATA_NOT_EXISTS);
				serviceStatus.setStatusCode(CustomerUtils.FAIL_STATUS_CODE);
				throw new ServiceFaultException(CustomerUtils.ERROR, serviceStatus);
			} else {
				return list;
			}
		} catch (CassandraConnectionFailureException exception) {

			ServiceStatus serviceStatus = new ServiceStatus();
			serviceStatus.setMessage(CustomerUtils.CASSANDRA_DB_DOWN);
			serviceStatus.setStatusCode(CustomerUtils.FAIL_STATUS_CODE);

			throw new ServiceFaultException(CustomerUtils.ERROR, serviceStatus);

		}

	}

	@Override
	public Customer getCustomerById(long customerId) {
		log.info("Inside getCustomerById Method " + customerId);
		Customer customer = null;
		try {
			Optional<Customer> optional = customerRepository.findById(customerId);
			if (optional.isPresent() == false) {
				ServiceStatus serviceStatus = new ServiceStatus();
				serviceStatus.setMessage(CustomerUtils.CUSTOMER_ID_NOT_EXISTS);
				serviceStatus.setStatusCode(CustomerUtils.FAIL_STATUS_CODE);
				throw new ServiceFaultException(CustomerUtils.ERROR, serviceStatus);
			} else {
				customer = optional.get();
				return customer;
			}
		} catch (CassandraConnectionFailureException exception) {

			ServiceStatus serviceStatus = new ServiceStatus();
			serviceStatus.setMessage(CustomerUtils.CASSANDRA_DB_DOWN);
			serviceStatus.setStatusCode(CustomerUtils.FAIL_STATUS_CODE);

			throw new ServiceFaultException(CustomerUtils.ERROR, serviceStatus);

		}

	}

	@Override
	public boolean addCustomer(Customer customer) {
		boolean flag = false;
		log.info("Inside addCustomer Method " + customer.getCustomerId());
		try {
			Optional<Customer> optional = customerRepository.findById(customer.getCustomerId());
			if (optional.isPresent() == true) {
				ServiceStatus serviceStatus = new ServiceStatus();
				serviceStatus.setMessage(CustomerUtils.CUSTOMER_ID_EXISTS);
				serviceStatus.setStatusCode(CustomerUtils.FAULT_CODE);
				throw new ServiceFaultException(CustomerUtils.ERROR, serviceStatus);
			} else {

				customerRepository.save(customer);
				flag = true;
				return flag;
			}
		} catch (CassandraConnectionFailureException exception) {

			ServiceStatus serviceStatus = new ServiceStatus();
			serviceStatus.setMessage(CustomerUtils.CASSANDRA_DB_DOWN);
			serviceStatus.setStatusCode(CustomerUtils.FAIL_STATUS_CODE);

			throw new ServiceFaultException(CustomerUtils.ERROR, serviceStatus);

		}

	}

	@Override
	public void updateCustomer(Customer customer) {
		log.info("Inside updateCustomer Method " + customer.getCustomerId());
		try {
			Optional<Customer> optional = customerRepository.findById(customer.getCustomerId());

			if (optional.isPresent() == false) {
				ServiceStatus serviceStatus = new ServiceStatus();
				serviceStatus.setMessage(CustomerUtils.CUSTOMER_ID_NOT_EXISTS);
				serviceStatus.setStatusCode(CustomerUtils.FAIL_STATUS_CODE);
				throw new ServiceFaultException(CustomerUtils.ERROR, serviceStatus);
			} else {

				Customer customerResponse = optional.get();

				if ((customer.getCustomerName()) != null && (!(customer.getCustomerName()).trim().isEmpty())) {
					customerResponse.setCustomerName(customer.getCustomerName());
				}
				if ((customer.getCustomerCity()) != null && (!(customer.getCustomerCity()).trim().isEmpty())) {
					customerResponse.setCustomerCity(customer.getCustomerCity());
				}
				if (customer.getCustomerPhone() != 0) {
					customerResponse.setCustomerPhone(customer.getCustomerPhone());
				}
				if (customer.getCustomerRewardPoints() != 0) {
					customerResponse.setCustomerRewardPoints(customer.getCustomerRewardPoints());
				}

				customerRepository.save(customerResponse);
			}
		} catch (CassandraConnectionFailureException exception) {
			ServiceStatus serviceStatus = new ServiceStatus();
			serviceStatus.setMessage(CustomerUtils.CASSANDRA_DB_DOWN);
			serviceStatus.setStatusCode(CustomerUtils.FAIL_STATUS_CODE);

			throw new ServiceFaultException(CustomerUtils.ERROR, serviceStatus);
		}
	}

	@Override
	public void deleteCustomer(Customer customer) {
		try {
			log.info("Inside deleteCustomer Method " + customer.getCustomerId());
			customerRepository.delete(customer);
		} catch (CassandraConnectionFailureException exception) {
			ServiceStatus serviceStatus = new ServiceStatus();
			serviceStatus.setMessage(CustomerUtils.CASSANDRA_DB_DOWN);
			serviceStatus.setStatusCode(CustomerUtils.FAIL_STATUS_CODE);

			throw new ServiceFaultException(CustomerUtils.ERROR, serviceStatus);
		}
	}
}
