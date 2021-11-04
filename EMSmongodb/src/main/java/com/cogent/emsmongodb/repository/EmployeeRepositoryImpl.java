EMSmongodbpackage com.cogent.emsmongodb.repository;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cogent.emsmongodb.dto.Employee;
import com.cogent.emsmongodb.utils.DBUtils;

	
	@Repository
	public class EmployeeRepositoryImpl implements EmployeeRepository {
  //private static employeeRepository
		

		@Autowired
		DBUtils dbUtils;

		@Override
		public String deleteEmployeeById(Employee employee)  {
			// TODO Auto-generated method stub

			Connection connection = null;
			try {
				connection = dbUtils.getConnection();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

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
					return Optional.ofNullable(employee);
					//arrayList.add(employee);

				}
//				
//				if(arrayList.isEmpty())
//				{
//					return Optional.empty();
//				}
//				else {
//					return Optional.of(arrayList);
//				}

				
//						// empty : returning null
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

		@Override
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
//				if(arrayList.isEmpty())
//				{
//					return Optional.empty();
//				}
//				else {
//					return Optional.of(arrayList);
//				}

				return Optional.ofNullable(arrayList);
//						// empty : returning null
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
			
			@Override
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

	

/*	==.old code before spring ==<

	DBUtils dbutils = DBUtils.getInstance();
	private static EmployeeRepository employeeRepository;

	// private String Success;
	public static EmployeeRepository getInstance() {
		if (employeeRepository == null) {
			employeeRepository = new EmployeeRepositoryImpl();
			return employeeRepository;

		}
		return employeeRepository;
	}

	@Aut
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub

		Connection connection = dbutils.getConnection();

		String insertStatement = "insert into  Employee (empId, empFirstName, empLastName, doj,dob,empsalary) values(?,?,?,?,?,?)";

		PreparedStatement preparedStatement = null;

		try {
			// if(connection!=null)
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, employee.getEmpId());
			preparedStatement.setString(2, employee.getEmpFirstName());
			preparedStatement.setString(3, employee.getEmpLastName());
			preparedStatement.setDate(4, new Date(employee.getDoj().getTime()));
			preparedStatement.setDate(5, new Date(employee.getDob().getTime()));// date from mysql package
			preparedStatement.setFloat(6, employee.getEmpSalary());
			preparedStatement.execute();
			// PreparedStatement.setDate(2, new Date(employee.getDob().getyear())); another
			// option as above
			// can u provide the values accordingly

			// int res =preparedStatement.executeUpdate();//no of rowss affected ..that cout
			// will return
			// number of rows of rows affected will be returned

			// if (res>0) {
			// preparedStatement.close();
			// dbutils.closeConnection(connection);
			return "Success";
			// }
			// else {

			// return "fail";
			// }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbutils.closeConnection(connection);
		}

		return null; // Optional.empty();

	}

	// employee details based on employee ID
	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		Connection connection = dbutils.getConnection();
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
				employee.setDob(resultSet.getDate("dob"));
				employee.setDoj(resultSet.getDate("doj"));
				employee.setEmpSalary(resultSet.getFloat("empSalary"));
				arrayList.add(employee);

			}

			return Optional.ofNullable(arrayList);

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			dbutils.closeConnection(connection);
		}

		return Optional.empty();

	}

	@Override
	public String deleteEmployeeById(String id) {
		Connection con = dbutils.getConnection();
		String deleteStatement = "delete from employee where empId = ?";
		int results = 0;
		PreparedStatement preparedStatement = null;
		try {

			preparedStatement.setString(1, id);
			results = preparedStatement.executeUpdate();
			if (results == 0)
				System.out.println(" No  Records of Employee Found to Delete ");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			dbutils.closeConnection(con);
		}

		return (results + "Number of Employee Records are Deleted ");

	}

	@Override
	public void deleteAllEmployees() {
		// TODO Auto-generated method stub

		int count = 0;
		Connection connection = dbutils.getConnection();
		String query = "DELETE FROM employee";
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(query);
			count = ps.executeUpdate();
			if (count == 0)
				System.out.println("No Records Deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbutils.closeConnection(connection);
		}
		System.out.println(count + " records deleted");

	}

	// arrayList.add(employee);

	// Update Employee

	public String updateEmployee( Employee employee) {
				// TODO Auto-generated method stub
			
	 	Connection connection =dbutils.getConnection();
	 	String query = "Update employee set empFirstName =?, empLastName =?, doj=?, dob=?,  empSalary=? where empId = ?";
	 	PreparedStatement preparedStatement = null;
	 	int count = 0;
	 	
	 	try {
	 		
	 		preparedStatement = connection.prepareStatement(query);
		    preparedStatement.setString(6, employee.getEmpId());
		    preparedStatement.setString(1, employee.getEmpFirstName());
		    preparedStatement.setString(2, employee.getEmpLastName());
		    preparedStatement.setDate(3, new Date(employee.getDoj().getTime()));
		    preparedStatement.setDate(4, new Date(employee.getDob().getTime()));// date from mysql package
		    preparedStatement.setFloat(5,employee.getEmpSalary());
	 	    count =preparedStatement.executeUpdate();
	 	
	 	if (count ==0) 
	 		System.out.println("Employee Records Not Updated");
	 	 
	 	}
	 		
	 	
	 	 catch (SQLException e) {
	// TODO: handle exception
   e.printStackTrace();
}
 finally {
 
	dbutils.closeConnection(connection);
}

	return (" Hooray  Employees Records are Finally Updated!!");	
			 // Optional.empty();	

	 	}

	@Override
	public boolean isEmployeeExists(String id) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
			public Optional<List<Employee>>getEmployeeById(String id) {
				// TODO Auto-generated method stub
				
		Connection connection = dbutils.getConnection();
		ArrayList<Employee> arrayList = new ArrayList<>();

		String query = "select * from employee where empId =" + id;
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
				employee.setDob(resultSet.getDate("dob"));
				employee.setDoj(resultSet.getDate("doj"));
				employee.setEmpSalary(resultSet.getFloat("empSalary"));
				arrayList.add(employee);
			}
			return Optional.ofNullable(arrayList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbutils.closeConnection(connection);
		}
		return Optional.empty();

		
	
	
	}

}
	
*/	
	
	
	
	
