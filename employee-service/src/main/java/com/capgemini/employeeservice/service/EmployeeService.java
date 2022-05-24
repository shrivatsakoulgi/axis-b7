package com.capgemini.employeeservice.service;

import java.util.List;

import com.capgemini.employeeservice.model.Employee;

public interface EmployeeService {
	
	Employee getEmployeeById(int employeeId);
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	void deleteEmployeeById(int employeeId);
	void updateEmployee(int employeeId,Employee employee);
	
	Employee getEmployeeByName(String name);

}
 