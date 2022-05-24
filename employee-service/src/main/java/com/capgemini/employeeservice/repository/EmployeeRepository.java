package com.capgemini.employeeservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.employeeservice.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	
	public Employee findByName(String name);

}
