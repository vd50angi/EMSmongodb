package com.cogent.emsmongodb.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cogent.emsmongodb.dto.Employee;
import com.cogent.emsmongodb.repository.EmployeeRepository;
import com.cogent.emsmongodb.repository.EmployeeRepositoryImpl;
import com.cogent.emsmongodb.utils.DBUtils;

@Service
public class EmployeeServiceImpl  implements EmployeeService{
	
@Autowired
private EmployeeRepository employeeRepository;
	
	
@Override
public String addEmployee(Employee employee) {
	// TODO Auto-generated method stub
	return null;
}



@Override
public String deleteEmployeeById(String id) {
	// TODO Auto-generated method stub
	return null;
}



@Override
public void deleteAllEmployees() {
	// TODO Auto-generated method stub
	
}



@Override
public Optional<List<Employee>> getEmployeeById(String id) {
	// TODO Auto-generated method stub
	return null;
}



@Override
public Optional<List<Employee>> getEmployees() {
	// TODO Auto-generated method stub
	return null;
}



@Override
public String updateEmployee(String id, Employee employee) {
	// TODO Auto-generated method stub
	return null;
}



@Override
public boolean isEmployeeExists(String id) {
	// TODO Auto-generated method stub
	return false;

}

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*code before spring  
	
	/*private EmployeeRepository employeeRepository = EmployeeRepositoryImpl.getInstance();
	
	private static EmployeeService employeeService;
	
	public static EmployeeService getInstance() {
		if(employeeService==null) {
			employeeService = new EmployeeServiceImpl();
			return employeeService;
			
		}*
	
		return employeeService;
		}

	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.addEmployee(employee);
	}

	@Override
	public String deleteEmployeeById(String id) {
		// TODO Auto-generated method stub
		return employeeRepository.deleteEmployeeById(id);
	}

	@Override
	public void deleteAllEmployees() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<List<Employee>> getEmployeeById(String id) {
		// TODO Auto-generated method stub
		return employeeRepository.getEmployeeById(id);

	}

	@Override
	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.getEmployees();

	}

	@Override
	public String updateEmployee(String id, Employee employee) {
		// TODO Auto-generated method stub
		return  employeeRepository.updateEmployee(employee);
	};

	

	@Override
	public boolean isEmployeeExists(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	

}


	
	
	
	



	*/