package com.thomas.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thomas.pma.dao.EmployeeRepository;
import com.thomas.pma.dao.ProjectRepository;
import com.thomas.pma.entities.Employee;
import com.thomas.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping
	public String displayProjects(Model model) {
		
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectsList", projects);
		
		return "projects/list-projects";
	}
	
	@GetMapping("/new")
	public String diplayProjectForm(Model model) {
		
		Project aProject = new Project();
		
		//Used for the assignment of employees to the project
		List<Employee> employees = empRepo.findAll();
		
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employees);
		
		
		
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		
		proRepo.save(project);
		
		// use a redirect to prevent duplicate submissions
		return"redirect:/projects";	
	}
	
	
	
}
