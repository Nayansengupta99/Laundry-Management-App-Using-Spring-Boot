package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.feign.LaundryAdminFeignClient;
import com.cognizant.model.LaundryCustomerModel;
import com.cognizant.model.LaundryServiceModel;
import com.cognizant.model.ServiceDto;
import com.cognizant.model.ServiceModel;
import com.cognizant.repository.LaundryCustomerRepository;

@Service
public class LaundryCustomerService {

	@Autowired
	private LaundryAdminFeignClient client;

	@Autowired
	private LaundryCustomerRepository custRepo;

	public List<LaundryServiceModel> getDetailsFromLaundryAdminClient() {
		return client.getAllDetails();
	}

	public String addToLaundryCart(int customerId, int serviceId) {

		String serviceName = "";
		List<LaundryServiceModel> list = client.getAllDetails();
		for (LaundryServiceModel m : list) {
			if (m.getServiceId() == serviceId) {
				serviceName = m.getServiceName();
			}
		}
		LaundryCustomerModel custModel = new LaundryCustomerModel(customerId, serviceId, serviceName);
		custRepo.save(custModel);

		return "Service Added Successfully";

	}

	public List<ServiceDto> showCartItemsByUserId(int customerId) {

		List<LaundryCustomerModel> list1 = custRepo.findAll();
		List<LaundryServiceModel> list2 = client.getAllDetails();
		List<ServiceModel> l = new ArrayList<>();
		List<ServiceDto> l1 = new ArrayList<>();
		double total = 0;
		for (LaundryCustomerModel m : list1) {

			if (m.getCustomerId() == customerId) {
				for (LaundryServiceModel m1 : list2) {
					if (m.getServiceId() == m1.getServiceId()) {
						ServiceModel sm1 = new ServiceModel(m.getServiceId(), m.getServiceName(), m1.getServiceCost());
						l.add(sm1);
						total=total+m1.getServiceCost();
					}
				}
			}

		}
		ServiceDto dto=new ServiceDto(l,total);
		l1.add(dto);
		return l1;
		
		

	}

//	 if(m.getServiceId()==sm.getServiceId()) {
//		 ServiceModel sm1=new ServiceModel(m.getServiceId(),m.getServiceName(),sm.getServiceCost());
//		 l.add(sm1);
//	 }

}
