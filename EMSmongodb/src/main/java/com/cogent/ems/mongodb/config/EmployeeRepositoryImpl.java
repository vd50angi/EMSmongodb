package com.cogent.ems.mongodb.config;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cogent.emsmongodb.dto.Employee;
import com.cogent.emsmongodb.repository.EmployeeRepository;
import com.cogent.emsmongodb.utils.DBUtils;
import com.mysql.cj.protocol.Resultset;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {

	

	@Autowired
	DBUtils dbUtils;

	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub

		Connection connection = dbUtils.getConnection();

		String insertStatement = "insert into employee (empId,empFirstName, empLastName,doj,dob,empSalary) values(?,?,?,?,?,?)";

		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(insertStatement);

			preparedStatement.setString(1, employee.getEmpId());
			preparedStatement.setString(2, employee.getEmpFirstName());
			preparedStatement.setString(3, employee.getEmpLastName());
			preparedStatement.setDate(4, new Date(employee.getDoj().getTime()));

			// can u provide the values accordingly
			preparedStatement.setDate(5, new Date(employee.getDob().getTime()));
			preparedStatement.setFloat(6, employee.getEmpSalary());

			int res = preparedStatement.executeUpdate();
			// no of rows affected by the statement will be returned

			if (res > 0) {
				return "success";
			} else {
				return "fail";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}

		return null;
	}

	public String deleteEmployeeById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteAllEmployees() {
		// TODO Auto-generated method stub

	}

	public Optional<List<Employee>> getEmployeeById(String id) {

		Connection connection = dbUtils.getConnection();
		//ArrayList<Employee> arrayList = new ArrayList<>();

		String query = "select * from employee where empId=?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				Employee employee = new Employee();

				employee.setEmpId(resultSet.getString("empId"));
				employee.setEmpFirstName(resultSet.getString("empFirstName"));
				employee.setEmpLastName(resultSet.getString("empLastName"));
				employee.setEmpSalary(resultSet.getFloat("empSalary"));
				employee.setDob(resultSet.getDate("dob"));
				employee.setDoj(resultSet.getDate("doj"));
				return Optional.empty();
				//arrayList.add(employee);

			}
//			
//			if(arrayList.isEmpty())
//			{
//				return Optional.empty();
//			}
//			else {
//				return Optional.of(arrayList);
//			}

			
//					// empty : returning null
			// of : if u r confirm about the object (its not empty/ not null )
			// ofNullable dicy

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			dbUtils.closeConnection(connection);
		}

		return Optional.empty();

	}

	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub

		Connection connection = dbUtils.getConnection();
		ArrayList<Employee> arrayList = new ArrayList<>();

		String query = "select * from employee";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			preparedStatement = connection.prepareStatement(query);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Employee employee = new Employee();

				employee.setEmpId(resultSet.getString("empId"));
				employee.setEmpFirstName(resultSet.getString("empFirstName"));
				employee.setEmpLastName(resultSet.getString("empLastName"));
				employee.setEmpSalary(resultSet.getFloat("empSalary"));
				employee.setDob(resultSet.getDate("dob"));
				employee.setDoj(resultSet.getDate("doj"));

				arrayList.add(employee);

			}
//			
//			if(arrayList.isEmpty())
//			{
//				return Optional.empty();
//			}
//			else {
//				return Optional.of(arrayList);
//			}

			return Optional.ofNullable(arrayList);
//					// empty : returning null
			// of : if u r confirm about the object (its not empty/ not null )
			// ofNullable dicy

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			dbUtils.closeConnection(connection);
		}

		return Optional.empty();
	}

	public String updateEmployee(String id, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isEmployeeExists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

}


 /*import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;


@Configuration
@PropertySource("classpath:application.properties")
public class DBCOnfig {
	
	
	//db related
	@Autowired //this anotation this will help u enrollment object to the spring
	           //**autowired did singleton environment & confuguration all at one
	Environment environment; //getinstance(); //is an interface..to get the property values /thid the reference of type interface
	
	//we need object , created by spring/ we need  need to inform spring  the environmenttal object
	/* do we need already created object from the spring? inject the already created object/  Dependency injection (DI)*/
	
	
	// data source==1
	//singleton object
	//@Bean//used to get /hold singleton object
	

	//method level annotation
	/*@Bean//used to get /hold singleton object
	@Scope("prototype")
	public DataSource dataSource() {
	BasicDataSource basicDataSource = new BasicDataSource();
	basicDataSource.setUrl(environment.getProperty("db.url"));
    basicDataSource.setUsername(environment.getProperty("db.username"));
    basicDataSource.setPassword(environment.getProperty("db.password"));
    basicDataSource.setDriverClassName(environment.getProperty("db.className"));
    
    return basicDataSource;
	
		
		
	}

*///}
