package com.cogent.emsmongodb.service;

import java.util.List;
import java.util.Optional;

import com.cogent.emsmongodb.dto.Employee;

public interface EmployeeService {
	
	public String addEmployee(Employee employee );
	public String deleteEmployeeById(String id) ;
	public void deleteAllEmployees();
	public Optional<List<Employee>> getEmployeeById(String id) ;
	public Optional<List<Employee>> getEmployees();
	public String updateEmployee(String id, Employee employee);
	public boolean isEmployeeExists(String id);
	//public String deleteEmployee(String string, String string2, String string3);
	//public String deleteEmployee1(String string, String string2, String string3);
	
}

	
	
	

