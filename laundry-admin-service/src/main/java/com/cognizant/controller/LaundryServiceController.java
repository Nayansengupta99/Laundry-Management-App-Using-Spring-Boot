package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.LaundryServiceModel;
import com.cognizant.repository.LaundryServiceRepo;

@RestController
@RequestMapping("admin")
public class LaundryServiceController {

	@Autowired
	private LaundryServiceRepo serviceRepo;

	@GetMapping("/details")
	public List<LaundryServiceModel> getAllDetails() {
		return serviceRepo.findAll();
	}

}
