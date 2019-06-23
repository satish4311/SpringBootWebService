package com.kroger;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.kroger.wsdl.AddCustomerRequest;
import com.kroger.wsdl.AddCustomerResponse;
import com.kroger.wsdl.CustomerInfo;
import com.kroger.wsdl.DeleteCustomerRequest;
import com.kroger.wsdl.DeleteCustomerResponse;
import com.kroger.wsdl.GetAllCustomerRequest;
import com.kroger.wsdl.GetAllCustomerResponse;
import com.kroger.wsdl.GetCustomerByIdRequest;
import com.kroger.wsdl.GetCustomerByIdResponse;
import com.kroger.wsdl.UpdateCustomerRequest;
import com.kroger.wsdl.UpdateCustomerResponse;


public class CustomerClient extends WebServiceGatewaySupport  {
	public GetCustomerByIdResponse getCustomer(long customerId) {
		GetCustomerByIdRequest request = new GetCustomerByIdRequest();
		request.setCustomerId(customerId);
		GetCustomerByIdResponse response = (GetCustomerByIdResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback(EndPointUrls.CUSTOMER_BY_ID));
		return response;
	}
	public GetAllCustomerResponse getAllCustomers() {
		GetAllCustomerRequest request = new GetAllCustomerRequest();
		GetAllCustomerResponse response = (GetAllCustomerResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback(EndPointUrls.GET_ALL_CUSTOMER));
     	return response;
	}	
	public AddCustomerResponse addCustomer(long customerId,String customerName,String customerCity,long customerPhone,long customerLoyalityPoint) {
		AddCustomerRequest request = new AddCustomerRequest();
		request.setCustomerId(customerId);
		request.setCustomerName(customerName);
		request.setCustomerCity(customerCity);
		request.setCustomerPhone(customerPhone);
		request.setCustomerLoyalityPoint(customerLoyalityPoint);
		
		AddCustomerResponse response = (AddCustomerResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback(EndPointUrls.ADD_CUSTOMER));
     	return response;
	}	
	public UpdateCustomerResponse updateCustomer(CustomerInfo customerInfo) {
		UpdateCustomerRequest request = new UpdateCustomerRequest();
		request.setCustomerInfo(customerInfo);
		UpdateCustomerResponse response = (UpdateCustomerResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback(EndPointUrls.UPDATE_CUSTOMER));
     	return response;
	}	
	public DeleteCustomerResponse deleteCustomer(long customerId) {
		DeleteCustomerRequest request = new DeleteCustomerRequest();
		request.setCustomerId(customerId);
		DeleteCustomerResponse response = (DeleteCustomerResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback(EndPointUrls.DELETE_CUSTOMER));
     	return response;
	}		
}
