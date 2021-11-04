package com.cogent.emsmongodb.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.cogent.emsmongodb.dto.Employee;

public interface EmployeeRepository {
	
	public String addEmployee(Employee employee ) throws ClassNotFoundException, SQLException;
	public String deleteEmployeeById(String id) ;
	public void deleteAllEmployees();
	public Optional<List<Employee>> getEmployeeById(String id) ;
	public Optional<List<Employee>> getEmployees();
	public String updateEmployee( Employee employee);
	public boolean isEmployeeExists(String id);
	
	
	
}

	
	
	
	
	
	
	
	


