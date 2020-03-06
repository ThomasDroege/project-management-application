package com.thomas.pma.dto;

public interface EmployeeProject {

	// Need to have the property names begin with get. Spring needs it to populate data.
	public String getFirstName();
	public String getLastName();
	public int getProjectCount();
}
