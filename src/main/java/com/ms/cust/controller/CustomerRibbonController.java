package com.ms.cust.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ms.cust.dto.CustomerDto;
import com.ms.cust.dto.LoginDto;
import com.ms.cust.dto.PlanDto;
import com.ms.cust.ribbon.CustRibbonConfig;
import com.ms.cust.service.CustomerService;

@RestController
@CrossOrigin
@RibbonClient(name = "custribbon", configuration = CustRibbonConfig.class)
public class CustomerRibbonController {

	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${plan.uri}")
	String planUri;
	
	@PostMapping(value = "/customers", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createCustomer(@RequestBody CustomerDto customerDto) {
		logger.info("Customer creation request ", customerDto);
		customerService.createCustomer(customerDto);
		
	}	
	
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean login(@RequestBody LoginDto loginDto) {
		logger.info("Customer Login request ", loginDto.getPhoneNo() + " - " + loginDto.getPassword());
		return customerService.login(loginDto);		
	}
	
	@GetMapping(value = "/customers-ribbon/{phoneNo}")
	public CustomerDto getCustomerProfile(@PathVariable Long phoneNo) {
		logger.info("Customer profile request ", phoneNo);
		CustomerDto dto = customerService.getCustomerProfile(phoneNo);
		PlanDto plandto = new RestTemplate().getForObject(planUri+dto.getCurrentPlan().getPlanId(), PlanDto.class);
		dto.setCurrentPlan(plandto);
		
		List<Long> friends = restTemplate.getForObject("http://custribbon/customers/"+phoneNo+"/friends", List.class);
		dto.setFriendAndFamily(friends);
		
		return dto;
		
		
		
	}
	
	
	
	
	
	
	
}
