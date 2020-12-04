package com.cognizant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceModel {

	private int serviceId;
	private String serviceName;
	private double serviceCost;

}
