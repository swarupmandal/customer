package com.ms.cust.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ms.cust.dto.CustomerDto;
import com.ms.cust.dto.PlanDto;
import com.ms.cust.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {

Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "/customers/{phoneNo}")
	public CustomerDto getCustomerProfile(@PathVariable Long phoneNo) {
		logger.info("Customer profile request ", phoneNo);
		CustomerDto dto = customerService.getCustomerProfile(phoneNo);
		PlanDto plandto = new RestTemplate().getForObject("http://localhost:1016/plans/"+dto.getCurrentPlan().getPlanId(), PlanDto.class);
		dto.setCurrentPlan(plandto);
		
		List<Long> friends = new RestTemplate().getForObject("http://localhost:1014/customers/"+phoneNo+"/friends", List.class);
		dto.setFriendAndFamily(friends);
		
		return dto;
		
		
		
	}
	
}
