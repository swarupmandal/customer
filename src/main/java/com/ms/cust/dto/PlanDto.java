package com.ms.cust.dto;

public class PlanDto {

	Integer planId;
	String planName;
	Integer nationalRate;
	
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public Integer getNationalRate() {
		return nationalRate;
	}
	public void setNationalRate(Integer nationalRate) {
		this.nationalRate = nationalRate;
	}
	
	public PlanDto() {
		super();
	}
	
	@Override
	public String toString() {
		return "PlanDto [planId=" + planId + ", planName=" + planName + ", nationalRate=" + nationalRate + "]";
	}	
	
}
