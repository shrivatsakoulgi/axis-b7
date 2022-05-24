package com.capgemini.insuranceservice.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.insuranceservice.model.Insurance;

@Repository
public interface InsuranceRepository extends CrudRepository<Insurance, Integer>{
	
	Optional<Insurance> 
	findByInsuranceName(String insuranceName); //Change
}
