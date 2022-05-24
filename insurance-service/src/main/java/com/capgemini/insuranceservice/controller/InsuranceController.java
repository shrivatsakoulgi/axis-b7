package com.capgemini.insuranceservice.controller;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.insuranceservice.model.Insurance;
import com.capgemini.insuranceservice.service.InsuranceServiceImpl;
@RestController
public class InsuranceController {
	
	@Autowired
	private InsuranceServiceImpl insuranceService;
	
	@GetMapping("/insurance/id/{insuranceId}")
	public Insurance getInsurance(@PathVariable int insuranceId) {
		return insuranceService.getInsuranceById(insuranceId);
	}
	
	@GetMapping("/insurance/insuranceName/{insuranceName}")
	public Insurance getInsurance(@PathVariable String insuranceName) {
		return insuranceService.findByInsuranceName(insuranceName);
	}
	
	@GetMapping("/insurances")
	public ArrayList<Insurance> getInsurance() {
		return (ArrayList<Insurance>) insuranceService.getAllInsurances();
	}
	
	@PostMapping("/insurance/add")
	public ResponseEntity<String> addNewPolicy(@RequestBody Insurance ir){
		insuranceService.saveInsurance(ir);
		return new ResponseEntity<String>("new Insurance Policy was added with Id:"+ir.getInsuranceId(), HttpStatus.OK);
	}
	
	@DeleteMapping("insurance/delete/{insuranceId}")
	public ResponseEntity<String> deleteExistingPolicy(@PathVariable int insuranceId){
		insuranceService.deleteInsurance(insuranceId);
		return new ResponseEntity<String>("Policy is deleted", HttpStatus.OK);
	}
	
	@PutMapping("insurance/update/{insuranceId}")
	public ResponseEntity<String> updatePolicy(@PathVariable int insuranceId, @RequestBody Insurance updatedInsurance){
		insuranceService.updateInsurance(insuranceId, updatedInsurance);
		return new ResponseEntity<String>("Policy Id:"+insuranceId+" is updated", HttpStatus.OK);
	}

}
