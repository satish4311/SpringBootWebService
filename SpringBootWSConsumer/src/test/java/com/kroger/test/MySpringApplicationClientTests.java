package com.kroger.test;


import static org.junit.Assert.assertEquals;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kroger.CustomerClient;
import com.kroger.MySpringApplicationClient;
import com.kroger.wsdl.AddCustomerResponse;
import com.kroger.wsdl.CustomerInfo;
import com.kroger.wsdl.DeleteCustomerResponse;
import com.kroger.wsdl.GetAllCustomerResponse;
import com.kroger.wsdl.GetCustomerByIdResponse;
import com.kroger.wsdl.UpdateCustomerResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MySpringApplicationClient.class })
public class MySpringApplicationClientTests {

	private static final Logger log = LogManager.getLogger(MySpringApplicationClientTests.class);

	@Autowired
	private CustomerClient customerClient;

	@Test
	public void getCustomerId() {
		
		log.info("--- Get Customer by Id ---");
		GetCustomerByIdResponse customerByIdResponse = customerClient.getCustomer(4311);
		CustomerInfo customerInfo = customerByIdResponse.getCustomerInfo();
		log.info("Customer Id : " + customerInfo.getCustomerId() + ":::" + "Customer Name : "
				+ customerInfo.getCustomerName() + ":::" + "Customer Phone : " + customerInfo.getCustomerPhone() + ":::"
				+ "Customer City : " + customerInfo.getCustomerCity() + ":::" + "CustomerLoyalityPoints :"
				+ customerInfo.getCustomerLoyalityPoint());
		

		 assertEquals(customerByIdResponse.getServiceStatus().getStatusCode(), "200");
		


		
	}
	
	
	@Test
	public void getAllCustomers() {
		log.info("--- Get all Customers ---");
		
		GetAllCustomerResponse allArticlesResponse = customerClient.getAllCustomers();
		allArticlesResponse.getCustomerInfo().stream()
				.forEach(e -> log.info("Customer Id : " +e.getCustomerId() + ":::"+"Customer Name : " + e.getCustomerName() + ":::"
						+"Customer City : "+ e.getCustomerCity() + ":::"+"Customer Phone : " + e.getCustomerPhone() + ":::"+"CustomerLoyalityPoints : " + e.getCustomerLoyalityPoint()));
		assertEquals(allArticlesResponse.getServiceStatus().getStatusCode(), "200");
	}
	
	
	@Test
	public void updateCustomer() {
		
		log.info("--- Update Customer ---");
		CustomerInfo customer = new CustomerInfo();
		customer.setCustomerId(4311);
		customer.setCustomerLoyalityPoint(554);
		UpdateCustomerResponse response = customerClient.updateCustomer(customer);
		assertEquals(response.getServiceStatus().getStatusCode(), "200");
		
		
	}
	
	@Test
	public void deleteCustomer() {
		
		
		log.info("--- Delete Customer ---");
		DeleteCustomerResponse response = customerClient.deleteCustomer(4327);
		assertEquals(response.getServiceStatus().getStatusCode(), "200");
	}
	
	
	@Test
	public void addCustomer() {
		
		log.info("--- Add Customer ---");
		AddCustomerResponse response  = customerClient.addCustomer(4328, "Satish", "Hyd", Long.valueOf("9550510989"), 100);
		assertEquals(response.getServiceStatus().getStatusCode(), "200");
		
	}
	
	
	
	
	}
	
	


