package com.thomas.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thomas.pma.dao.EmployeeRepository;
import com.thomas.pma.dao.ProjectRepository;
import com.thomas.pma.dto.ChartData;
import com.thomas.pma.dto.EmployeeProject;
import com.thomas.pma.entities.Project;

@Controller
public class HomeController {

	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
		Map<String, Object> map = new HashMap<>();
		
		// querying the database for projects
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectsList", projects);
		
		
		// querying the database for counting the project states
		List<ChartData> projectData = proRepo.getProjectStatus();
		
		// Convert projectData object into a json structure for use in javascript
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		// [["NOTSTARTED", 1], ["INPROGRESS", 2], ["COMPLETED", 1]]
		
		model.addAttribute("projectStatusCnt", jsonString);
		
		
		
		//querying the database for employees
		List<EmployeeProject> employeesProjectCount = empRepo.employeeProjects();
		model.addAttribute("employeesListProjectCnt", employeesProjectCount);
		
		return "main/home";
	}
	
	
}
