package com.thomas.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thomas.pma.dao.EmployeeRepository;
import com.thomas.pma.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	EmployeeRepository empRepo;
	
	
	
	@Autowired
	public void setEmpRepo(EmployeeRepository empRepo) {
		this.empRepo = empRepo;
	}


	@GetMapping
	public String displayEmployees(Model model) {
		
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("employeesList", employees);
		
		return "employees/list-employees";
	}
	
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		
		Employee aEmployee = new Employee();
		
		model.addAttribute("employee", aEmployee);
		
		return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String createEmployee(Employee employee, Model model) {
		empRepo.save(employee);
		
		return "redirect:/employees/new";
	}
	

	
}
