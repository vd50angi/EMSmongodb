import java.util.Date;
import com.cogent.emsmongodb.utils.DBUtils;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.cogent.emsmongodb.dto.Employee;
import com.cogent.emsmongodb.service.EmployeeService;
import com.cogent.emsmongodb.service.EmployeeServiceImpl;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// dbUtils = dbUtils.getInstance();
		EmployeeService employeeService = EmployeeServiceImpl.getInstance();
		Scanner scanner = new Scanner(System.in);
		Employee employee = new Employee("ad1001", "Angie", "Devega", new Date(2016,8,05), new Date(2016,8,05), 1800.0f );
		String id = "ad1002";
		String result = employeeService.addEmployee(employee);
	
		
		/*if("success".equals(result)) {
			System.out.println("record added successfully");
		} else {
			System.out.println("not added");
		}
		
		Optional <List<Employee>> optional = employeeService.getEmployees();
		
		Optional<List<Employee>> optional2 = employeeService.getEmployeeById(id);

		//Optional <Employee> optional2 = employeeService.getEmployeeById(id);
		String result3 = employeeService.updateEmployee(id, employee);
		//Optional <String> optional3 = employeeService.deleteEmployeeById(id);
		employeeService.deleteAllEmployees();
		System.out.println("Employee records all deleted");
		System.out.println(result3);
		if(optional.isPresent()) {
			optional.get().forEach(System.out::println);
		} else {
			System.out.println("error");
			
		}
		if(optional2.isPresent()) {
			System.out.println("list employee by id");
			
			

			Employee employee2 = (Employee) optional2.get();
			System.out.println(employee2);
		} else {
			System.out.println("error");
			
		}
//		if(optional3.isPresent()) {
//			System.out.println("records have been deleted");
//			String result2 = optional3.get();
//		} else {
//			System.out.println("no record found");
//		}
		
	}*/

	
	
	}
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public static void main(String[] args) {
	/*EmployeeService employeeService= EmployeeServiceImpl.getInstance();
	
	Scanner scanner = new Scanner(System.in);
		
	Employee employee = new Employee ("an001", "Angie", "DeVega", new Date(), new Date(2016- 8- 05 ), 1100.0f);
			

          String result = employeeService.addEmployee(employee);
          String id = "An002";
            if("success".equals(result))
            {
		 System.out.println("Employee Record Added Succesfully");
			}
				 else{
				 System.out.println(" Employee Record Not Aded Succesfully");
	
   Optional<List<Employee>> optional = Optional.ofNullable(employeeService.getEmployees());
   Optional<Employee> optional2 = Optional.ofNullable(employeeService.getEmployeeById(id));
 
   // Optional<List<Employee>> optional = employeeService.getEmployees();
  // Optional<Employee> optional2 = employeeService.getEmployeeById(id);
   
   
   
   if(optional.isPresent()) {
	  optional.get().forEach(System.out::println);
	   }
   if(optional2.isPresent()) {
	   Employee employee2 = (Employee) optional2.get();
	   System.out.println(employee2);
   
   
   }
				 }
	}*/
            


