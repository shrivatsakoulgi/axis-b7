package com.capgemini.insuranceservice.service;

import java.util.List;

import com.capgemini.insuranceservice.model.Insurance;

public interface InsuranceService {
	
	Insurance getInsuranceById(int insuranceId);
	List<Insurance> getAllInsurances();
	void saveInsurance(Insurance insurance);
	void deleteInsurance(int insuranceId);
	void updateInsurance(int insuranceId, Insurance insurance);
	
	
	Insurance findByInsuranceName(String insuranceName);

}
