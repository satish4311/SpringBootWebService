package com.kroger.constants;

public class CustomerUtils {

	public static final String WSDL_MAPPING_URI = "/soapws/*";
	public static final String WSDL_MAPPING_BEAN_NAME = "customers";
	public static final String WSDL_PORT = "CustomerPort";
	public static final String WSDL_LOCATION_URI = "/soapws";
	public static final String WSDL_TARGET_NAME_SPACE = "http://www.kroger.com/Customer-ws";
	public static final String WSDL_EXCEPTION_TARGET_NAME_SPACE = "http://www.kroger.com/exception";
	public static final String WSDL_XSD_LOCATION = "xsds/customer.xsd";
	public static final String NAMESPACE_URI = "http://www.kroger.com/Customer-ws";
	public static final String LOCALPART_CUST_BY_ID = "getCustomerByIdRequest";
	public static final String LOCALPART_ALL_CUST = "getAllCustomerRequest";
	public static final String LOCALPART_ADD_CUST = "addCustomerRequest";
	public static final String LOCALPART_UPDATE_CUST = "updateCustomerRequest";
	public static final String LOCALPART_DELETE_CUST = "deleteCustomerRequest";
	public static final String STATUS_CONFLICT_CODE = "CONFLICT";
	public static final String STATUS_FAIL_CODE = "FAIL";
	public static final String STATUS_FAIL_MESSAGE = "Content Not Available";
	public static final String STATUS_CONFLICT_MESSAGE = "Content Already Available";
	public static final String SUCCESS_STATUS_CODE = "200";
	public static final String RETRIEVE_STATUS_MESSAGE = "Customer Data Retrieved Successfully";
	public static final String ADD_STATUS_MESSAGE = "Customer Data Added Successfully";
	public static final String UPDATE_STATUS_MESSAGE = "Customer Data Updated Successfully";
	public static final String DELETE_STATUS_MESSAGE = "Customer Data Deleted Successfully";
	public static final String CUSTOMER_DATA_NOT_EXISTS = "Customer Data Not Exists";
	public static final String CASSANDRA_DB_DOWN = "Cassandra DataBase is Down";
	public static final String NO_CUSTOMER_DETAILS = "No Customer Details are Available";
	public static final String CUSTOMER_ID_NOT_EXISTS = "Invalid Customer Id";
	public static final String CUSTOMER_ID_EXISTS = "Customer Id Already Exists";
	public static final String ENTER_CUSTOMER_ID = "Please Enter Customer Id";
	public static final String ENTER_CUSTOMER_NAME = "Please Enter Customer Name";
	public static final String ENTER_CUSTOMER_CITY = "Please Enter Customer City";
	public static final String ENTER_CUSTOMER_PHONE = "Please Enter Customer Phone";
	public static final String FAULT_CODE = "505";
	public static final String FAIL_STATUS_CODE = "404";
	public static final String ERROR = "ERROR";
	public static final String CUSTOMER_DATA_ADD_ERROR_MSG = "Please Enter CustomerId, CustomerName, CustomerCity and CustomerPhoneNumber to Save Customer Data";
	public static final String CUSTOMER_DATA_ADD_ERRORS_MSG = "Please Enter CustomerName, CustomerCity and CustomerPhoneNumber to Save Customer Data ";
	public static final String CUSTOMER_DATA_UPDATE_ERROR_MSG = "Please Enter  any one or all the fields like CustomerName,CustomerCity,CustomerPhoneNumber,CustomerLoyalityPoint to Update Customer Data";
	public static final String CUSTOMER_DATA_UPDATE_ERRORS_MSG = "Please Enter CustomerId and  any one or all the fields like CustomerName,CustomerCity,CustomerPhoneNumber,CustomerLoyalityPoint to update the Customer Data";
	public static final String NULL_CONDITION = "null";

}
