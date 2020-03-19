package com.thomas.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thomas.pma.entities.Employee;
import com.thomas.pma.entities.Project;
import com.thomas.pma.services.EmployeeService;
import com.thomas.pma.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectService proService;
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping
	public String displayProjects(Model model) {
		
		List<Project> projects = proService.getAll();
		model.addAttribute("projectsList", projects);
		
		return "projects/list-projects";
	}
	
	@GetMapping("/new")
	public String diplayProjectForm(Model model) {
		
		Project aProject = new Project();
		
		//Used for the assignment of employees to the project
		List<Employee> employees = empService.getAll();
		
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employees);
		
		
		
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		
		proService.save(project);
		
		// use a redirect to prevent duplicate submissions
		return"redirect:/projects";	
	}
	
	
	
}
