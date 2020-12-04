package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.feign.LaundryAdminFeignClient;
import com.cognizant.model.LaundryServiceModel;
import com.cognizant.model.ServiceDto;
import com.cognizant.model.ServiceModel;
import com.cognizant.service.LaundryCustomerService;

@RestController
@RequestMapping("customer")
public class LaundryCustomerController {

	@Autowired
	LaundryCustomerService custService;
    
	@GetMapping("/servicedetails")
	public List<LaundryServiceModel> getDetailsFromLaundryAdminClient() {
		return custService.getDetailsFromLaundryAdminClient();
	}
	@PostMapping("/cart/{customerId}/{serviceId}")
	public String addToCart(@PathVariable("customerId") int customerId,@PathVariable("serviceId") int serviceId) {
		return custService.addToLaundryCart(customerId, serviceId);
	}
	@GetMapping("/cart/{customerId}")
	public List<ServiceDto> getAllCartItemsByCustomerId(@PathVariable("customerId") int customerId){
		
		return custService.showCartItemsByUserId(customerId);
		
	}

}
