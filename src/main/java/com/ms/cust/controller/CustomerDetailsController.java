package com.ms.cust.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class CustomerDetailsController {

	@Value("${my.greeting.cust.dev}")
	private String greetingMessage;

	@Value("${db.url.cust.dev}")
	private String dbURL;
	
	@GetMapping(value = "/customer-details", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getdbDeatils() {
		return greetingMessage +" - " + dbURL;
	}
	
}
