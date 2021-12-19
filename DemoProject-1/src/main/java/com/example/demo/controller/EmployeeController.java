package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService empSer;
	
	
	@GetMapping("/")
	public String HomePage(Model model) {
		return "Home";
	}
	@GetMapping("/emplist")
	public String viewHomePage(Model model) {
		model.addAttribute("list", empSer.getAllEmployee());
		return "index";
	}
	
	/*@GetMapping("/emplist-data")
	public List<Employee> viewHomePageData(Model model) {
		model.addAttribute("list", empSer.getAllEmployee());
		return empSer.getAllEmployee();
	}*/
	
	@GetMapping("/addEmp")
	public String addEmpPage(Model model) {
		Employee employee = new Employee();
		
		model.addAttribute("employee", employee);
		return "register";
	}
	
	@GetMapping("/updEmp/{id}")
	public String updEmpPage(@PathVariable (value = "id") long  id, Model model) {
		Employee employee = empSer.getEmployeeById(id);
		
		model.addAttribute("employee", employee);
		return "update";
	}
	
	@GetMapping("/delEmp/{id}")
	public String delEmpPage(@PathVariable (value = "id") long  id) {
		this.empSer.delEmp(id);;
		return "redirect:/emplist";
	}
	@PostMapping("/saveNewEmp")
	public String saveNewEmp(@ModelAttribute("employee") Employee employee) {
		empSer.saveEmp(employee);
		return "redirect:/emplist";
	}
	
	@PostMapping("/updNewEmp")
	public String updNewEmp(@ModelAttribute("employee") Employee employee) {
		empSer.saveEmp(employee);
		return "redirect:/emplist";
	}
}
