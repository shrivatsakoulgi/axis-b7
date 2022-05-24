package com.capgemini.employeeservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.employeeservice.exception.EmployeeNotFoundException;
import com.capgemini.employeeservice.model.Employee;
import com.capgemini.employeeservice.repository.EmployeeRepository;

@Service 
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee getEmployeeById(int employeeId) {
		Optional<Employee>opt =  employeeRepository.findById(employeeId);
		if(!opt.isPresent()) {
			throw new EmployeeNotFoundException();
		}
		return opt.get();
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
		
	}

	@Override
	public void deleteEmployeeById(int employeeId) {
		Optional<Employee>opt =  employeeRepository.findById(employeeId);
		if(!opt.isPresent()) {
			throw new EmployeeNotFoundException();
		}
		employeeRepository.deleteById(employeeId);		
	}

	@Override
	public void updateEmployee(int employeeId, Employee employee) {
		deleteEmployeeById(employeeId);
		saveEmployee(employee);
		
	}

	@Override
	public Employee getEmployeeByName(String name) {
		return employeeRepository.findByName(name);
	}

}
