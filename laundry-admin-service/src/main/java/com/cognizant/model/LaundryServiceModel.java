package com.cognizant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@XmlRootElement
@Table(name = "admin")
public class LaundryServiceModel {
    @Id
    @NotNull
    @Column(name="serviceid")
	private int serviceId;
    @NotNull
    @Column(name="servicename")
	private String serviceName;
    @NotNull
    @Column(name="servicecost")
	private double serviceCost;

}
