
import java.sql.Date;

import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import com.cogent.emsmongodb.dto.Employee;
import com.cogent.emsmongodb.repository.EmployeeRepository;
import com.cogent.emsmongodb.service.EmployeeService;
import com.cogent.emsmongodb.utils.BeanOne;
import com.cogent.emsmongodb.utils.BeanTwo;
import com.cogent.ems.mongodb.config.*;


public class SpringDemoMain {

	 //responsible for creating beans
	public static void main(String[] args) {
		
		//to get that object
		//we have  2 ways ( this 2 ways are containers ==> where containers will manage the object life cycle
		//bean factory
		//application context
		//if you dont want to provide bean name  then provide the expected bean name as a method name which dataSource with lowercase
	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
	System.out.println("hello from application context");
	//EmployeeService employeeService = applicationContext.getBean(EmloyeeService.class);
	//String result = employeeService.addEmployee(new Employee("Ang101", "Angie", "DeVega", new Date(),new Date(),1500.0f ));
	
	///System.out.println(result);
	//Beantwo beantwo = applicationContext.getBean(BeanTwo.class);==> even u commented it ..it will print out Beantwo Initialized as outpout
	
	
	//beanTwo.doSomthing();
	BeanOne beanOne = applicationContext.getBean(BeanOne.class);//bean is the lazy loading one
	beanOne.doSomthing();
	
	DataSource dataSource =applicationContext.getBean("dataSource",DataSource.class);
	/*if u will no tprovide any name to the bean thenn 
	 *  by default it will take  methoid as bean name*/
	
	System.out.println(dataSource.hashCode());
	System.out.println(dataSource.hashCode());
	System.out.println(dataSource.hashCode());
	DataSource dataSource2 = applicationContext.getBean("dataSource",DataSource.class);
	System.out.println(dataSource.hashCode());
	System.out.println(dataSource.equals(dataSource2));
	
	
	}

}
