package com.capgemini.employeeservice.controller;

import java.util.ArrayList;

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
import org.springframework.web.client.RestTemplate;

import com.capgemini.employeeservice.model.Employee;
import com.capgemini.employeeservice.model.Insurance;
import com.capgemini.employeeservice.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public ArrayList<Employee> getAllEmployees(){
		return (ArrayList<Employee>) employeeService.getAllEmployees();
	}	
	
	@GetMapping("/employee/id/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}
	
	@GetMapping("/employee/name/{name}")
	public Employee getEmployeeByName(@PathVariable String name) {
		return employeeService.getEmployeeByName(name);
	}
	
	
	@GetMapping("/employee/insurance/{insuranceId}")
	public ResponseEntity<Insurance> getInsuranceData(@PathVariable int insuranceId) {
		String url = "http://localhost:8060/insurance/id/"+insuranceId;
		RestTemplate restTemplate = new RestTemplate();
		
		// call to Insurance service to get Insurance details
		ResponseEntity<Insurance> response = restTemplate.getForEntity(url, Insurance.class);
		
		return response;
		
	}
	 
	
	@PostMapping("/employee/add")
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp) {
		employeeService.saveEmployee(emp);
		return new ResponseEntity<String>("Employee Added successfully with Id:"+emp.getEmployeeId(), HttpStatus.OK);		
	}
	
	@DeleteMapping("/employee/delete/{employeeId}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int employeeId) {	
		employeeService.deleteEmployeeById(employeeId);
		return new ResponseEntity<String>("Employee Removed successfully with Id:"+employeeId, HttpStatus.OK);
	}
	
	@PutMapping("/employee/update/{employeeId}")
	public ResponseEntity<String> updateEmployee(@PathVariable int employeeId,
			@RequestBody Employee updatedEmployee) {
		employeeService.updateEmployee(employeeId, updatedEmployee);
		return new ResponseEntity<String>("Employee updated successfully with Id:"+employeeId, HttpStatus.OK);
		
	}	
}
