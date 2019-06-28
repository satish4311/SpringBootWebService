package com.kroger.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.CassandraConnectionFailureException;
import org.springframework.stereotype.Service;

import com.kroger.constants.ConfigProperties;
import com.kroger.customer.ServiceFaultException;
import com.kroger.entity.Customer;
import com.kroger.gs_ws.ServiceStatus;
import com.kroger.repository.CustomerRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ConfigProperties configProperties;

	@Override
	public List<Customer> getAllCustomers() {
		log.info("Inside getAllCustomers() Method ");
		List<Customer> list = new LinkedList<Customer>();
		try {
			list = customerRepository.findAll();

			if (list.isEmpty()) {
				ServiceStatus serviceStatus = new ServiceStatus();
				serviceStatus.setMessage(configProperties.getCustDataNotExists());
				serviceStatus.setStatusCode(configProperties.getFailStatusCode());
				throw new ServiceFaultException(configProperties.getError(), serviceStatus);
			} else {
				return list;
			}
		} catch (CassandraConnectionFailureException exception) {

			ServiceStatus serviceStatus = new ServiceStatus();
			serviceStatus.setMessage(configProperties.getDataBaseDown());
			serviceStatus.setStatusCode(configProperties.getFailStatusCode());

			throw new ServiceFaultException(configProperties.getError(), serviceStatus);

		}

	}

	@Override
	public Customer getCustomerById(long customerId) {
		log.info("Inside getCustomerById Method " + customerId);
		Customer customer = null;
		try {
			Optional<Customer> optional = customerRepository.findByCustomerId(customerId);
			if (optional.isPresent()) {
				customer = optional.get();
				return customer;
			} else {
				ServiceStatus serviceStatus = new ServiceStatus();
				serviceStatus.setMessage(configProperties.getCustIdNotExists());
				serviceStatus.setStatusCode(configProperties.getFailStatusCode());
				throw new ServiceFaultException(configProperties.getError(), serviceStatus);
			}
		} catch (CassandraConnectionFailureException exception) {

			ServiceStatus serviceStatus = new ServiceStatus();
			serviceStatus.setMessage(configProperties.getDataBaseDown());
			serviceStatus.setStatusCode(configProperties.getFailStatusCode());

			throw new ServiceFaultException(configProperties.getError(), serviceStatus);

		}

	}

	@Override
	public Customer addCustomer(Customer customer) {
		log.info("Inside addCustomer Method " + customer.getCustomerId());
		try {
			Optional<Customer> optional = customerRepository.findByCustomerId(customer.getCustomerId());
			if (optional.isPresent()) {
				ServiceStatus serviceStatus = new ServiceStatus();
				serviceStatus.setMessage(configProperties.getCustIdExists());
				serviceStatus.setStatusCode(configProperties.getFaultCode());
				throw new ServiceFaultException(configProperties.getError(), serviceStatus);
			} else {

				return customerRepository.save(customer);

			}
		} catch (CassandraConnectionFailureException exception) {

			ServiceStatus serviceStatus = new ServiceStatus();
			serviceStatus.setMessage(configProperties.getDataBaseDown());
			serviceStatus.setStatusCode(configProperties.getFailStatusCode());

			throw new ServiceFaultException(configProperties.getError(), serviceStatus);

		}

	}

	@Override
	public void updateCustomer(Customer customer) {
		log.info("Inside updateCustomer Method " + customer.getCustomerId());
		try {
			Optional<Customer> optional = customerRepository.findByCustomerId(customer.getCustomerId());

			if (optional.isPresent()) {

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

			else {
				ServiceStatus serviceStatus = new ServiceStatus();
				serviceStatus.setMessage(configProperties.getCustIdNotExists());
				serviceStatus.setStatusCode(configProperties.getFailStatusCode());
				throw new ServiceFaultException(configProperties.getError(), serviceStatus);
			}
		} catch (CassandraConnectionFailureException exception) {
			ServiceStatus serviceStatus = new ServiceStatus();
			serviceStatus.setMessage(configProperties.getDataBaseDown());
			serviceStatus.setStatusCode(configProperties.getFailStatusCode());
			throw new ServiceFaultException(configProperties.getError(), serviceStatus);
		}
	}

	@Override
	public void deleteCustomer(Customer customer) {
		try {
			log.info("Inside deleteCustomer Method " + customer.getCustomerId());
			customerRepository.delete(customer);
		} catch (CassandraConnectionFailureException exception) {
			ServiceStatus serviceStatus = new ServiceStatus();
			serviceStatus.setMessage(configProperties.getDataBaseDown());
			serviceStatus.setStatusCode(configProperties.getFailStatusCode());
			throw new ServiceFaultException(configProperties.getError(), serviceStatus);
		}
	}
}
