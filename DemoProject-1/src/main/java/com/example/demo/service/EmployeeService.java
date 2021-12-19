package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();

	void saveEmp(Employee employee);
	
	Employee getEmployeeById(long id);
	
	void delEmp(long id);
}
