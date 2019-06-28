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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
@Table("customer")
@Getter
@Setter
@NoArgsConstructor
public class Customer implements Serializable {

	private static final long serialVersionUID = -3221396565752597939L;
	@PrimaryKey("customer_id")
	@Positive(message = "Customer Id must be a Positive Integer")
	private Long customerId;
	@Column("customer_name")
	@NotEmpty(message = "CustomerName cannot be Empty")
	private String customerName;
	@Column("customer_city")
	@NotEmpty(message = "ContactCity cannot be Empty")
	private String customerCity;
	@Column("customer_reward_points")
	@Positive(message = "Customer Reward Point must be a Positive Integer")
	private Long customerRewardPoints;
	@Column("customer_phone")
	@Positive(message = "Customer Phone must be a Positive Integer")
	private Long customerPhone;

}
