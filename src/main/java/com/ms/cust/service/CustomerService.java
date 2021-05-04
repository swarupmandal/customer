package com.ms.cust.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.cust.dto.CustomerDto;
import com.ms.cust.dto.LoginDto;
import com.ms.cust.entity.Customer;
import com.ms.cust.repository.CustomerRepository;

@Service
public class CustomerService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public void createCustomer(CustomerDto dto) {
		logger.info("current request for customer ", dto);
		Customer cust = dto.createCustEntity(dto);
		customerRepository.save(cust);
	}
	
	public boolean login(LoginDto dto) {
		logger.info("current request for customer login ", dto.getPhoneNo() +" - " + dto.getPassword());
		Customer cust=null;
		Optional<Customer> optional = customerRepository.findById(dto.getPhoneNo());
		if(optional.isPresent()) {
			cust = optional.get();
			if(cust.getPassword().equals(dto.getPassword())) {
				return true;
			}
		}
		
		return false;		
	}
	
	public CustomerDto getCustomerProfile(Long phoneNo) {
		CustomerDto custDto = null;
		logger.info("current request for customer profile ", phoneNo);
		
		Optional<Customer> optional = customerRepository.findById(phoneNo);
		if(optional.isPresent()) {
			Customer cust = optional.get();
			custDto = CustomerDto.valueOf(cust);
		}
		
		logger.info("Customer profile ", custDto);
		return custDto;
	}
	
	
	
	
}
