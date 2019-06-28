package com.kroger.constants;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:configprops.properties")
@ConfigurationProperties(prefix = "config")
public class ConfigProperties {

	private String wsdlContext;
	private String wsdlUri;
	private String wsdlPort;
	private String wsdlXsdLoc;
	private String conflictCode;
	private String statusFailCode;
	private String failMessage;
	private String conflictMessage;
	private String successStatusCode;
	private String retrieveStatusMessage;
	private String addStatusMessage;
	private String updateStatusMessage;
	private String deleteStatusMessage;
	private String custDataNotExists;
	private String dataBaseDown;
	private String noCustDetails;
	private String custIdNotExists;
	private String custIdExists;
	private String customerId;
	private String customerName;
	private String customerPhone;
	private String customerCity;
	private String faultCode;
	private String failStatusCode;
	private String error;
	private String addErrorMsg;
	private String addErrorMandMsg;
	private String updateErrorMsg;
	private String updateErrorMandMsg;
	private String nullCheck;
	private String patternCheck;
	
	public String getPatternCheck() {
		return patternCheck;
	}

	public void setPatternCheck(String patternCheck) {
		this.patternCheck = patternCheck;
	}

	public String getWsdlPort() {
		return wsdlPort;
	}

	public void setWsdlPort(String wsdlPort) {
		this.wsdlPort = wsdlPort;
	}

	
	public String getWsdlXsdLoc() {
		return wsdlXsdLoc;
	}

	public void setWsdlXsdLoc(String wsdlXsdLoc) {
		this.wsdlXsdLoc = wsdlXsdLoc;
	}


	public String getConflictCode() {
		return conflictCode;
	}

	public void setConflictCode(String conflictCode) {
		this.conflictCode = conflictCode;
	}

	public String getStatusFailCode() {
		return statusFailCode;
	}

	public void setStatusFailCode(String statusFailCode) {
		this.statusFailCode = statusFailCode;
	}

	public String getFailMessage() {
		return failMessage;
	}

	public void setFailMessage(String failMessage) {
		this.failMessage = failMessage;
	}

	public String getConflictMessage() {
		return conflictMessage;
	}

	public void setConflictMessage(String conflictMessage) {
		this.conflictMessage = conflictMessage;
	}

	public String getSuccessStatusCode() {
		return successStatusCode;
	}

	public void setSuccessStatusCode(String successStatusCode) {
		this.successStatusCode = successStatusCode;
	}

	public String getRetrieveStatusMessage() {
		return retrieveStatusMessage;
	}

	public void setRetrieveStatusMessage(String retrieveStatusMessage) {
		this.retrieveStatusMessage = retrieveStatusMessage;
	}

	public String getAddStatusMessage() {
		return addStatusMessage;
	}

	public void setAddStatusMessage(String addStatusMessage) {
		this.addStatusMessage = addStatusMessage;
	}

	public String getUpdateStatusMessage() {
		return updateStatusMessage;
	}

	public void setUpdateStatusMessage(String updateStatusMessage) {
		this.updateStatusMessage = updateStatusMessage;
	}

	public String getDeleteStatusMessage() {
		return deleteStatusMessage;
	}

	public void setDeleteStatusMessage(String deleteStatusMessage) {
		this.deleteStatusMessage = deleteStatusMessage;
	}

	public String getCustDataNotExists() {
		return custDataNotExists;
	}

	public void setCustDataNotExists(String custDataNotExists) {
		this.custDataNotExists = custDataNotExists;
	}

	public String getDataBaseDown() {
		return dataBaseDown;
	}

	public void setDataBaseDown(String dataBaseDown) {
		this.dataBaseDown = dataBaseDown;
	}

	public String getNoCustDetails() {
		return noCustDetails;
	}

	public void setNoCustDetails(String noCustDetails) {
		this.noCustDetails = noCustDetails;
	}

	public String getCustIdNotExists() {
		return custIdNotExists;
	}

	public void setCustIdNotExists(String custIdNotExists) {
		this.custIdNotExists = custIdNotExists;
	}

	public String getCustIdExists() {
		return custIdExists;
	}

	public void setCustIdExists(String custIdExists) {
		this.custIdExists = custIdExists;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getFaultCode() {
		return faultCode;
	}

	public void setFaultCode(String faultCode) {
		this.faultCode = faultCode;
	}

	public String getFailStatusCode() {
		return failStatusCode;
	}

	public void setFailStatusCode(String failStatusCode) {
		this.failStatusCode = failStatusCode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getAddErrorMsg() {
		return addErrorMsg;
	}

	public void setAddErrorMsg(String addErrorMsg) {
		this.addErrorMsg = addErrorMsg;
	}

	public String getAddErrorMandMsg() {
		return addErrorMandMsg;
	}

	public void setAddErrorMandMsg(String addErrorMandMsg) {
		this.addErrorMandMsg = addErrorMandMsg;
	}

	public String getUpdateErrorMsg() {
		return updateErrorMsg;
	}

	public void setUpdateErrorMsg(String updateErrorMsg) {
		this.updateErrorMsg = updateErrorMsg;
	}

	public String getUpdateErrorMandMsg() {
		return updateErrorMandMsg;
	}

	public void setUpdateErrorMandMsg(String updateErrorMandMsg) {
		this.updateErrorMandMsg = updateErrorMandMsg;
	}

	public String getNullCheck() {
		return nullCheck;
	}

	public void setNullCheck(String nullCheck) {
		this.nullCheck = nullCheck;
	}
	
	public String getWsdlContext() {
		return wsdlContext;
	}

	public void setWsdlContext(String wsdlContext) {
		this.wsdlContext = wsdlContext;
	}

	public String getWsdlUri() {
		return wsdlUri;
	}

	public void setWsdlUri(String wsdlUri) {
		this.wsdlUri = wsdlUri;
	}


}
