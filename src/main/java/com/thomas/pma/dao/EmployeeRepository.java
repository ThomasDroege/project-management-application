package com.thomas.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.thomas.pma.dto.EmployeeProject;
import com.thomas.pma.dto.ChartData;
import com.thomas.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	
	@Override
	public List<Employee> findAll();
	
	
	@Query(nativeQuery=true, value="SELECT e.firstname as firstName, e.lastname as lastName, COUNT(pe.employee_id) as projectCount " + 
			"FROM employee e left join project_employee pe ON pe.employee_id=e.employee_id " + 
			"GROUP BY e.firstname, e.lastname ORDER BY 3 DESC")
	public List<EmployeeProject> employeeProjects();


}

