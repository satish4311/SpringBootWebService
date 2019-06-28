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
		return (GetCustomerByIdResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback(EndPointUrls.CUSTOMER_BY_ID));
	}
	public GetAllCustomerResponse getAllCustomers() {
		GetAllCustomerRequest request = new GetAllCustomerRequest();
		return (GetAllCustomerResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback(EndPointUrls.GET_ALL_CUSTOMER));
	}	
	public AddCustomerResponse addCustomer(long customerId,String customerName,String customerCity,long customerPhone,long customerLoyalityPoint) {
		AddCustomerRequest request = new AddCustomerRequest();
		request.setCustomerId(customerId);
		request.setCustomerName(customerName);
		request.setCustomerCity(customerCity);
		request.setCustomerPhone(customerPhone);
		request.setCustomerLoyalityPoint(customerLoyalityPoint);
		
		return (AddCustomerResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback(EndPointUrls.ADD_CUSTOMER));
	}	
	public UpdateCustomerResponse updateCustomer(CustomerInfo customerInfo) {
		UpdateCustomerRequest request = new UpdateCustomerRequest();
		request.setCustomerInfo(customerInfo);
		return (UpdateCustomerResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback(EndPointUrls.UPDATE_CUSTOMER));
	}	
	public DeleteCustomerResponse deleteCustomer(long customerId) {
		DeleteCustomerRequest request = new DeleteCustomerRequest();
		request.setCustomerId(customerId);
		return (DeleteCustomerResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback(EndPointUrls.DELETE_CUSTOMER));
	}		
}
