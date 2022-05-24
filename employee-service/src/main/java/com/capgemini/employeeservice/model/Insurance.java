package com.capgemini.employeeservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Insurance {
	@Id
	@GeneratedValue
	private int insuranceId;
	private String insuranceName, insuranceType;
	private int sumAssured;
	public Insurance() {}
	public Insurance(String insuranceName, String insuranceType, int sumAssured) {
		this.insuranceName = insuranceName;
		this.insuranceType = insuranceType;
		this.sumAssured = sumAssured;
	}
	public int getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}
	public String getInsuranceName() {
		return insuranceName;
	}
	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public int getSumAssured() {
		return sumAssured;
	}
	public void setSumAssured(int sumAssured) {
		this.sumAssured = sumAssured;
	}

}
