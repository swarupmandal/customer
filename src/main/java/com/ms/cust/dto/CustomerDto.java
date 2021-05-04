package com.ms.cust.dto;

import java.util.List;

import com.ms.cust.entity.Customer;

public class CustomerDto {

	long phoneNo;
	String name;
	int age;
	char gender;
	List<Long> friendAndFamily;
	String password;
	String address;
	PlanDto currentPlan;
	
	public CustomerDto() {
		
	}

	public CustomerDto(long phoneNo, String name, int age, char gender, List<Long> friendAndFamily, String password,
			String address, PlanDto currentPlan) {
		super();
		this.phoneNo = phoneNo;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.friendAndFamily = friendAndFamily;
		this.password = password;
		this.address = address;
		this.currentPlan = currentPlan;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public List<Long> getFriendAndFamily() {
		return friendAndFamily;
	}

	public void setFriendAndFamily(List<Long> friendAndFamily) {
		this.friendAndFamily = friendAndFamily;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public PlanDto getCurrentPlan() {
		return currentPlan;
	}

	public void setCurrentPlan(PlanDto currentPlan) {
		this.currentPlan = currentPlan;
	}

	@Override
	public String toString() {
		return "CustomerDto [phoneNo=" + phoneNo + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", friendAndFamily=" + friendAndFamily + ", password=" + password + ", address=" + address
				+ ", currentPlan=" + currentPlan + "]";
	}
	
	
	public static CustomerDto valueOf(Customer customer) {
		
		CustomerDto dto = new CustomerDto();
		dto.setAge(customer.getAge());
		dto.setGender(customer.getGender());
		dto.setName(customer.getName());
		dto.setPhoneNo(customer.getPhoneNo());
		dto.setAddress(customer.getAddress());
		PlanDto planDto = new PlanDto();
		planDto.setPlanId(customer.getPlanId());
		dto.setCurrentPlan(planDto);
		
		return dto;		
	}
	
	public Customer createCustEntity(CustomerDto dto) {
		
		Customer customer = new Customer();
		customer.setAge(dto.getAge());
		customer.setGender(dto.getGender());
		customer.setName(dto.getName());
		customer.setPhoneNo(dto.getPhoneNo());
		customer.setAddress(dto.getAddress());
		customer.setPassword(dto.getPassword());
		customer.setPlanId(dto.getCurrentPlan().getPlanId());
		
		return customer;		
		
	}
	
	
	
}
