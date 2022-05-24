package com.capgemini.insuranceservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.insuranceservice.exception.DuplicateInsuranceException;
import com.capgemini.insuranceservice.exception.InsuranceNotFoundException;
import com.capgemini.insuranceservice.model.Insurance;
import com.capgemini.insuranceservice.repository.InsuranceRepository;

@Service
public class InsuranceServiceImpl implements InsuranceService {
	@Autowired
	private InsuranceRepository insuranceRepo;

	@Override		
	public Insurance getInsuranceById(int insuranceId) {
		Optional<Insurance>opt = insuranceRepo.findById(insuranceId);
		if(!opt.isPresent()) {
			throw new InsuranceNotFoundException();
		}
		return opt.get();
	}

	@Override
	public List<Insurance> getAllInsurances() {
		return (List<Insurance>) insuranceRepo.findAll();
	}

	@Override
	public void saveInsurance(Insurance insurance) {  // change Here
		Optional<Insurance> opt = 
				insuranceRepo.findByInsuranceName(insurance.getInsuranceName());
		if(opt.isPresent()) {
			throw new DuplicateInsuranceException();
		}
		insuranceRepo.save(insurance);
	}

	@Override		
	public void deleteInsurance(int insuranceId) {
		Optional<Insurance>opt = insuranceRepo.findById(insuranceId);
		if(!opt.isPresent()) {
			throw new InsuranceNotFoundException();
		}
		insuranceRepo.deleteById(insuranceId);
	}

	@Override
	public void updateInsurance(int insuranceId, Insurance insurance) {
		deleteInsurance(insuranceId);		
		insuranceRepo.save(insurance);
	}

	@Override
	public Insurance findByInsuranceName(String insuranceName) {
		return insuranceRepo.findByInsuranceName(insuranceName).get();  //Change Here
	}

}
