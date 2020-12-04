package com.cognizant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.cognizant.model.ServiceModel;
import com.cognizant.service.LaundryCustomerService;

@SpringBootApplication
@EnableFeignClients
public class LaundryCustomerServiceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(LaundryCustomerServiceApplication.class, args);
       
	
	
	
	
	}
	
	

}
