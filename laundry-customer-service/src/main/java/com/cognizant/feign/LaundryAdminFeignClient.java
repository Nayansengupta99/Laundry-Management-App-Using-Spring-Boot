package com.cognizant.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.cognizant.model.LaundryServiceModel;


@FeignClient(name="laundry-admin-service",url="${feign.laundry.admin.url}")
public interface LaundryAdminFeignClient {

	@GetMapping("admin/details")
	public List<LaundryServiceModel> getAllDetails(); 


}
