//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.28 at 05:38:31 PM IST 
//


package com.kroger.gs_ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="serviceStatus" type="{http://www.kroger.com/Customer-ws}serviceStatus"/&gt;
 *         &lt;element name="customerInfo" type="{http://www.kroger.com/Customer-ws}customerInfo"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "serviceStatus",
    "customerInfo"
})
@XmlRootElement(name = "addCustomerResponse")
public class AddCustomerResponse {

    @XmlElement(required = true)
    protected ServiceStatus serviceStatus;
    @XmlElement(required = true)
    protected CustomerInfo customerInfo;

    /**
     * Gets the value of the serviceStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceStatus }
     *     
     */
    public ServiceStatus getServiceStatus() {
        return serviceStatus;
    }

    /**
     * Sets the value of the serviceStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceStatus }
     *     
     */
    public void setServiceStatus(ServiceStatus value) {
        this.serviceStatus = value;
    }

    /**
     * Gets the value of the customerInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerInfo }
     *     
     */
    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    /**
     * Sets the value of the customerInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerInfo }
     *     
     */
    public void setCustomerInfo(CustomerInfo value) {
        this.customerInfo = value;
    }

}
