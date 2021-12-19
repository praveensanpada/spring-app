package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public List<Employee> getAllEmployee() {
		return empRepo.findAll();
	}
	@Override
	public void saveEmp(Employee employee) {
		this.empRepo.save(employee);
	}
	@Override
	public Employee getEmployeeById(long id) {
		java.util.Optional<Employee>  optional = empRepo.findById(id);
		Employee employee = null;
		if(optional.isPresent()) {
			employee = optional.get();
		}else {
			throw new RuntimeException("Employee Id Not Found");
		}
		return employee;
	}
	
	@Override
	public void delEmp(long id) {
		this.empRepo.deleteById(id);
	}

}
