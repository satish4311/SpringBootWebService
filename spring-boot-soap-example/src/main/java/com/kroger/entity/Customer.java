package com.kroger.entity;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
@Table("customer")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3221396565752597939L;
	@PrimaryKey
	@Column("customer_id")
	@Positive(message = "Customer Id must be a Positive Integer")
	protected Long customer_id;
	@Column("customer_name")
	@NotEmpty(message = "CustomerName cannot be Empty")
	protected String customer_name;
	@Column("customer_city")
	@NotEmpty(message = "ContactCity cannot be Empty")
	protected String customer_city;

	@Column("customer_reward_points")
	@Positive(message = "Customer Reward Point must be a Positive Integer")
	protected Long customer_reward_points;

	public Long getCustomerId() {
		return customer_id;
	}

	public void setCustomerId(Long customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomerName() {
		return customer_name;
	}

	public void setCustomerName(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomerCity() {
		return customer_city;
	}

	public void setCustomerCity(String customer_city) {
		this.customer_city = customer_city;
	}

	public Long getCustomerRewardPoints() {
		return customer_reward_points;
	}

	public void setCustomerRewardPoints(Long customer_reward_points) {
		this.customer_reward_points = customer_reward_points;
	}

	public Long getCustomerPhone() {
		return customer_phone;
	}

	public void setCustomerPhone(Long customer_phone) {
		this.customer_phone = customer_phone;
	}

	@Column("customer_phone")
	@Positive(message = "Customer Phone must be a Positive Integer")
	protected Long customer_phone;

}
