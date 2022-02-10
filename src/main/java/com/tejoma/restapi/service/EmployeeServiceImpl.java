package com.tejoma.restapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejoma.restapi.model.Employee;
import com.tejoma.restapi.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	public static List<Employee> list=new ArrayList<>();
	
@Autowired
private EmployeeRepository empRepo;
	
	@Override
	public List<Employee> getEmployees() {
		
		return empRepo.findAll();
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		
		return empRepo.save(emp);
	}

	@Override
	public Employee getSingleEmployee(Long id) {
		
		Optional<Employee>emp=empRepo.findById(id);
		if(emp.isPresent())
			return emp.get();
		throw new RuntimeException("Employee with the following id:"+id+"is not Available");
	}

	@Override
	public void deleteEmployee(Long id) {
		empRepo.deleteById(id);
		
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		
		return empRepo.save(emp);
	}

}
