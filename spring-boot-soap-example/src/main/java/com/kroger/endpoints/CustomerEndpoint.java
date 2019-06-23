package com.kroger.endpoints;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.kroger.constants.CustomerUtils;
import com.kroger.customer.ServiceFaultException;
import com.kroger.entity.Customer;
import com.kroger.gs_ws.AddCustomerRequest;
import com.kroger.gs_ws.AddCustomerResponse;
import com.kroger.gs_ws.CustomerInfo;
import com.kroger.gs_ws.DeleteCustomerRequest;
import com.kroger.gs_ws.DeleteCustomerResponse;
import com.kroger.gs_ws.GetAllCustomerResponse;
import com.kroger.gs_ws.GetCustomerByIdRequest;
import com.kroger.gs_ws.GetCustomerByIdResponse;
import com.kroger.gs_ws.ServiceStatus;
import com.kroger.gs_ws.UpdateCustomerRequest;
import com.kroger.gs_ws.UpdateCustomerResponse;
import com.kroger.service.CustomerService;

@Endpoint
public class CustomerEndpoint {

	private static final Logger log = LogManager.getLogger(CustomerEndpoint.class);

	@Autowired
	private CustomerService customerService;

	@PayloadRoot(namespace = CustomerUtils.NAMESPACE_URI, localPart = CustomerUtils.LOCALPART_CUST_BY_ID)
	@ResponsePayload
	public GetCustomerByIdResponse getCustomer(@RequestPayload GetCustomerByIdRequest request) {
		log.info("getCustomer Method Request Object" + request.getCustomerId());
		GetCustomerByIdResponse response = new GetCustomerByIdResponse();
		log.info("CustomerId " + request.getCustomerId());
		try {

			if (Objects.isNull(request.getCustomerId()) || request.getCustomerId() == 0) {
				ServiceStatus service = new ServiceStatus();
				service.setMessage(CustomerUtils.ENTER_CUSTOMER_ID);
				service.setStatusCode(CustomerUtils.FAULT_CODE);
				throw new ServiceFaultException(CustomerUtils.ERROR, service);
			}

			Customer customerResponse = customerService.getCustomerById(request.getCustomerId());
			log.info("Response " + customerResponse);
			CustomerInfo customerInfo = new CustomerInfo();
			customerInfo.setCustomerId(customerResponse.getCustomerId());
			customerInfo.setCustomerName(customerResponse.getCustomerName());
			customerInfo.setCustomerCity(customerResponse.getCustomerCity());
			customerInfo.setCustomerPhone(customerResponse.getCustomerPhone());
			customerInfo.setCustomerLoyalityPoint(customerResponse.getCustomerRewardPoints());
			ServiceStatus serviceStatus = new ServiceStatus();
			serviceStatus.setStatusCode(CustomerUtils.SUCCESS_STATUS_CODE);
			serviceStatus.setMessage(CustomerUtils.RETRIEVE_STATUS_MESSAGE);
			response.setServiceStatus(serviceStatus);
			response.setCustomerInfo(customerInfo);
			return response;
		} catch (ServiceFaultException exception) {
			throw new ServiceFaultException(exception.getMessage(), exception.getServiceStatus());
		}
	}

	@PayloadRoot(namespace = CustomerUtils.NAMESPACE_URI, localPart = CustomerUtils.LOCALPART_ALL_CUST)
	@ResponsePayload
	public GetAllCustomerResponse getAllCustomers() {
		try {
			GetAllCustomerResponse response = new GetAllCustomerResponse();
			List<CustomerInfo> customerInfoList = new LinkedList<CustomerInfo>();
			List<Customer> customerList = customerService.getAllCustomers();
			customerList.forEach(customer -> {
				CustomerInfo customerInfo = new CustomerInfo();
				customerInfo.setCustomerId(customer.getCustomerId());
				customerInfo.setCustomerName(customer.getCustomerName());
				customerInfo.setCustomerPhone(customer.getCustomerPhone());
				customerInfo.setCustomerLoyalityPoint(customer.getCustomerRewardPoints());
				customerInfo.setCustomerCity(customer.getCustomerCity());
				customerInfoList.add(customerInfo);
			});
			response.getCustomerInfo().addAll(customerInfoList);
			ServiceStatus serviceStatus = new ServiceStatus();
			serviceStatus.setStatusCode(CustomerUtils.SUCCESS_STATUS_CODE);
			serviceStatus.setMessage(CustomerUtils.RETRIEVE_STATUS_MESSAGE);
			response.setServiceStatus(serviceStatus);
			return response;
		} catch (ServiceFaultException exception) {
			throw new ServiceFaultException(exception.getMessage(), exception.getServiceStatus());
		}
	}

	@PayloadRoot(namespace = CustomerUtils.NAMESPACE_URI, localPart = CustomerUtils.LOCALPART_ADD_CUST)
	@ResponsePayload
	public AddCustomerResponse addCustomer(@RequestPayload AddCustomerRequest request) {
		log.info("addCustomer Method ");
		try {
			AddCustomerResponse response = new AddCustomerResponse();
			ServiceStatus serviceStatus = new ServiceStatus();

			if ((request.getCustomerId() == 0) && (request.getCustomerName() == null)
					&& (request.getCustomerCity() == null) && (request.getCustomerPhone() == 0)) {
				ServiceStatus service = new ServiceStatus();
				service.setMessage(CustomerUtils.CUSTOMER_DATA_ADD_ERROR_MSG);
				service.setStatusCode(CustomerUtils.FAULT_CODE);
				throw new ServiceFaultException(CustomerUtils.ERROR, service);
			}

			else if ((request.getCustomerId() != 0)
					&& (((CustomerUtils.NULL_CONDITION.equals(request.getCustomerName()))
							|| request.getCustomerName() == null)
							|| ((CustomerUtils.NULL_CONDITION.equals(request.getCustomerCity()))
									|| request.getCustomerCity() == null)
							|| (request.getCustomerPhone() == 0))) {
				ServiceStatus service = new ServiceStatus();
				service.setMessage(CustomerUtils.CUSTOMER_DATA_ADD_ERRORS_MSG);
				service.setStatusCode(CustomerUtils.FAULT_CODE);
				throw new ServiceFaultException(CustomerUtils.ERROR, service);

			}

			else if (Objects.isNull(request.getCustomerId()) || request.getCustomerId() == 0) {
				ServiceStatus service = new ServiceStatus();
				service.setMessage(CustomerUtils.ENTER_CUSTOMER_ID);
				service.setStatusCode(CustomerUtils.FAULT_CODE);
				throw new ServiceFaultException(CustomerUtils.ERROR, service);
			}

			else {
				Customer customer = new Customer();
				customer.setCustomerId(request.getCustomerId());
				customer.setCustomerName(request.getCustomerName());
				customer.setCustomerCity(request.getCustomerCity());
				customer.setCustomerPhone(request.getCustomerPhone());
				customer.setCustomerRewardPoints(request.getCustomerLoyalityPoint());
				boolean flag = customerService.addCustomer(customer);
				if (flag == true) {
					CustomerInfo customerInfo = new CustomerInfo();

					customerInfo.setCustomerId(request.getCustomerId());
					customerInfo.setCustomerName(request.getCustomerName());
					customerInfo.setCustomerCity(request.getCustomerCity());
					customerInfo.setCustomerPhone(request.getCustomerPhone());
					customerInfo.setCustomerLoyalityPoint(request.getCustomerLoyalityPoint());
					response.setCustomerInfo(customerInfo);
					serviceStatus.setStatusCode(CustomerUtils.SUCCESS_STATUS_CODE);
					serviceStatus.setMessage(CustomerUtils.ADD_STATUS_MESSAGE);
					response.setServiceStatus(serviceStatus);
				}
			}
			return response;
		} catch (ServiceFaultException exception) {
			throw new ServiceFaultException(exception.getMessage(), exception.getServiceStatus());
		}
	}

	@PayloadRoot(namespace = CustomerUtils.NAMESPACE_URI, localPart = CustomerUtils.LOCALPART_UPDATE_CUST)
	@ResponsePayload
	public UpdateCustomerResponse updateCustomer(@RequestPayload UpdateCustomerRequest request) {
		log.info("updateCustomer Method ");
		try {
			UpdateCustomerResponse response = new UpdateCustomerResponse();

			if ((request.getCustomerInfo().getCustomerId() != 0)
					&& (((CustomerUtils.NULL_CONDITION.equals(request.getCustomerInfo().getCustomerName()))
							|| request.getCustomerInfo().getCustomerName() == null)
							&& ((CustomerUtils.NULL_CONDITION.equals(request.getCustomerInfo().getCustomerCity()))
									|| request.getCustomerInfo().getCustomerCity() == null)
							&& (request.getCustomerInfo().getCustomerPhone() == 0)
							&& (request.getCustomerInfo().getCustomerLoyalityPoint() == 0))) {
				ServiceStatus service = new ServiceStatus();
				service.setMessage(CustomerUtils.CUSTOMER_DATA_UPDATE_ERROR_MSG);
				service.setStatusCode(CustomerUtils.FAULT_CODE);
				throw new ServiceFaultException(CustomerUtils.ERROR, service);
			}

			else if ((request.getCustomerInfo().getCustomerId() == 0)
					&& (request.getCustomerInfo().getCustomerName() == null)
					&& (request.getCustomerInfo().getCustomerCity() == null)
					&& (request.getCustomerInfo().getCustomerPhone() == 0)
					&& (request.getCustomerInfo().getCustomerLoyalityPoint() == 0)) {
				ServiceStatus service = new ServiceStatus();
				service.setMessage(CustomerUtils.CUSTOMER_DATA_UPDATE_ERRORS_MSG);
				service.setStatusCode(CustomerUtils.FAULT_CODE);
				throw new ServiceFaultException(CustomerUtils.ERROR, service);
			} else if (Objects.isNull(request.getCustomerInfo().getCustomerId())
					|| request.getCustomerInfo().getCustomerId() == 0) {
				ServiceStatus service = new ServiceStatus();
				service.setMessage(CustomerUtils.ENTER_CUSTOMER_ID);
				service.setStatusCode(CustomerUtils.FAULT_CODE);
				throw new ServiceFaultException(CustomerUtils.ERROR, service);
			}

			else {
				Customer customer = new Customer();
				customer.setCustomerId(request.getCustomerInfo().getCustomerId());
				if ((request.getCustomerInfo().getCustomerName()) != null
						&& (!(request.getCustomerInfo().getCustomerName()).trim().isEmpty()))
					customer.setCustomerName(request.getCustomerInfo().getCustomerName());
				if ((request.getCustomerInfo().getCustomerCity()) != null
						&& (!(request.getCustomerInfo().getCustomerCity()).trim().isEmpty()))
					customer.setCustomerCity(request.getCustomerInfo().getCustomerCity());
				if (!(Objects.isNull(request.getCustomerInfo().getCustomerPhone()))) {
					customer.setCustomerPhone(request.getCustomerInfo().getCustomerPhone());
					if (!(Objects.isNull(request.getCustomerInfo().getCustomerLoyalityPoint()))) {
						customer.setCustomerRewardPoints(request.getCustomerInfo().getCustomerLoyalityPoint());
						customerService.updateCustomer(customer);
						ServiceStatus serviceStatus = new ServiceStatus();
						serviceStatus.setStatusCode(CustomerUtils.SUCCESS_STATUS_CODE);
						serviceStatus.setMessage(CustomerUtils.UPDATE_STATUS_MESSAGE);
						response.setServiceStatus(serviceStatus);
					}

				}

			}
			return response;
		} catch (ServiceFaultException exception) {
			throw new ServiceFaultException(exception.getMessage(), exception.getServiceStatus());
		}
	}

	@PayloadRoot(namespace = CustomerUtils.NAMESPACE_URI, localPart = CustomerUtils.LOCALPART_DELETE_CUST)
	@ResponsePayload
	public DeleteCustomerResponse deleteCustomer(@RequestPayload DeleteCustomerRequest request) {
		log.info("deleteCustomer Method ");
		try {
			if (request.getCustomerId() == 0) {
				ServiceStatus service = new ServiceStatus();
				service.setMessage(CustomerUtils.ENTER_CUSTOMER_ID);
				service.setStatusCode(CustomerUtils.FAULT_CODE);
				throw new ServiceFaultException(CustomerUtils.ERROR, service);
			}
			Customer customer = customerService.getCustomerById(request.getCustomerId());
			ServiceStatus serviceStatus = new ServiceStatus();
			customerService.deleteCustomer(customer);
			serviceStatus.setStatusCode(CustomerUtils.SUCCESS_STATUS_CODE);
			serviceStatus.setMessage(CustomerUtils.DELETE_STATUS_MESSAGE);
			DeleteCustomerResponse response = new DeleteCustomerResponse();
			response.setServiceStatus(serviceStatus);
			return response;
		} catch (ServiceFaultException exception) {
			throw new ServiceFaultException(exception.getMessage(), exception.getServiceStatus());
		}
	}
}
