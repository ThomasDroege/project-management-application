package com.thomas.pma.services;

import org.springframework.beans.factory.annotation.Qualifier;

//@Service
public class EmployeeService {
	
	
	
	//Field Injection
	//	@Autowired
	//	EmployeeRepository empRepo;
	 
	
	
	
	//Constructor Injection
	  IStaffRepository empRepo;
	
		public EmployeeService(@Qualifier("staffRepositoryImpl1") IStaffRepository empRepo) {
			this.empRepo = empRepo;
		}
	
	//	Setter Injection
	//	EmployeeRepository empRepo;
	
	//	@Autowired
	//	public void setEmpRepo(EmployeeRepository empRepo) {
	//		this.empRepo = empRepo;
	//	}
	
	
	
}
