package com.tejoma.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tejoma.restapi.model.Employee;
import com.tejoma.restapi.service.EmployeeService;


@RestController

public class EmployeeController {

	@Autowired
	private EmployeeService eService;
	// GET:http://localhost:9092/employees
	@GetMapping("/employees")
	public List<Employee> getEmployees()
	{
		
		return eService.getEmployees();
	}
	// GET:http://localhost:9092/employees/78
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable("id") Long id)
	{
		return eService.getSingleEmployee(id);
		
	}
	// DELETE: http://localhost:9092/employees?id=100
	@DeleteMapping("/employees")
	public void deleteEmployee(@RequestParam("id") Long id)
	{
		eService.deleteEmployee(id);
		
	}
	@PostMapping("/employees")
public Employee saveEmployee(@RequestBody Employee emp)
{
	return eService.saveEmployee(emp);
		
}
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable long id,@RequestBody Employee emp)
	{
		emp.setId(id);
		return eService.updateEmployee(emp);
		
	}
}
