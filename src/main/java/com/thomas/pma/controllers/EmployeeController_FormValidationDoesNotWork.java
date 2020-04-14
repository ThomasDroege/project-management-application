package com.thomas.pma.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thomas.pma.entities.Employee;
import com.thomas.pma.services.EmployeeService;

@RequestMapping("/employees")
public class EmployeeController_FormValidationDoesNotWork {

	@Autowired
	EmployeeService empService;
	
	


	@GetMapping
	public String displayEmployees(Model model) {	
		List<Employee> employees = empService.getAll();
		model.addAttribute("employeesList", employees);
		return "employees/list-employees";
	}
	
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		
		Employee aEmployee = new Employee();
		
		model.addAttribute("employee", aEmployee);
		
		return "employees/new-employee";
	}
	
	
	@GetMapping("/")
	public String errorForm(Model model, Employee employee) {
		return "employees/list-employees";
	}
	
	
	@PostMapping("/save")
	public String createEmployee(@Valid Employee employee, Model model, BindingResult bindingResult) {
		
		
		if(bindingResult.hasErrors()) {
			empService.save(employee);
			return "employees/list-employees";
		}
	
		empService.save(employee);
		return "redirect:/employees";
	}
	

	
}
