package com.kroger.constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerUtils {

	private CustomerUtils() {

	}

	public static final String WSDL_MAPPING_BEAN_NAME = "customers";
	public static final String WSDL_TARGET_NAME_SPACE = "http://www.kroger.com/Customer-ws";
	public static final String WSDL_EXCEPTION_TARGET_NAME_SPACE = "http://www.kroger.com/exception";
	public static final String NAMESPACE_URI = "http://www.kroger.com/Customer-ws";
	public static final String LOCALPART_CUST_BY_ID = "getCustomerByIdRequest";
	public static final String LOCALPART_ALL_CUST = "getAllCustomerRequest";
	public static final String LOCALPART_ADD_CUST = "addCustomerRequest";
	public static final String LOCALPART_UPDATE_CUST = "updateCustomerRequest";
	public static final String LOCALPART_DELETE_CUST = "deleteCustomerRequest";

	public static boolean isValid(Long s) {
		String phoneNumber = String.valueOf(s);
		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
		Matcher m = p.matcher(phoneNumber);
		return (m.find() && m.group().equals(phoneNumber));
	}

}
