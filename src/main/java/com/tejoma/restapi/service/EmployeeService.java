package com.tejoma.restapi.service;

import java.util.List;

import com.tejoma.restapi.model.Employee;

public interface EmployeeService {

	List<Employee> getEmployees();
	Employee saveEmployee(Employee emp);
	Employee getSingleEmployee(Long id);
	void deleteEmployee(Long id);
	Employee updateEmployee(Employee emp);
}
