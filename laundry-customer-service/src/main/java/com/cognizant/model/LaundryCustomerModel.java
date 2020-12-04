package com.cognizant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@XmlRootElement
@Table(name = "customer")
public class LaundryCustomerModel {

	@Id 
	@GeneratedValue 
	private int id;
	private int customerId;
	private int serviceId;
	private String serviceName;
	

	
	public LaundryCustomerModel(int customerId, int serviceId, String serviceName) {
		super();
		this.customerId = customerId;
		this.serviceId = serviceId;
		this.serviceName = serviceName;
	}


}
