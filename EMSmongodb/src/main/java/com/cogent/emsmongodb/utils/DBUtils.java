package com.cogent.emsmongodb.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component//singeleton
@Lazy(value = true)
	public class DBUtils {
			
	 @Autowired //DI
		DataSource dataSource;
	     
	 public DBUtils() {
	     }
	
			/*private DBUtils() {
				// TODO Auto-generated constructor stub
			}
			
			private static DBUtils dbUtils;
			public static DBUtils getInstance() {
				// 
				
				if(dbUtils==null) {
					dbUtils = new DBUtils();
					return dbUtils;
				}
				return dbUtils;
			}
			public static void main(String[] args) {
				
				DBUtils  dbUtils  = getInstance();
				
				Properties  properties = dbUtils.readProperties();
				
				System.out.println(properties);
				// can u call readProperties method
				// can u print properties object
				
				Connection connection = dbUtils.getConnection();
				
				System.out.println(connection!=null);
				
			}
			public Properties readProperties() {
				
				Properties properties = new Properties();
				
				InputStream inputStream = getClass()
						.getClassLoader()
						.getResourceAsStream("application.properties");
				
				try {
					properties.load(inputStream);
					return properties;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;*/
				
			//}*/
			// singleton pattern.
			public Connection getConnection() throws SQLException, ClassNotFoundException {
			
				//Properties properties = this.readProperties();
				Connection connection = null;
				connection = dataSource.getConnection();
				//Class.forName(properties.getProperty("db.className"));
				
				return null;
			}
			
			public void closeConnection(Connection connection) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*private DBUtils() {
			// TODO Auto-generated constructor stub
		}
		
		private static DBUtils dbUtils;
		public static DBUtils getInstance() {
			// 
			
			if(dbUtils==null) {
				dbUtils = new DBUtils();
				return dbUtils;
			}
			return dbUtils;
		}
		public static void main(String[] args) {
			
			DBUtils  dbUtils  = getInstance();
			
			Properties  properties = dbUtils.readProperties();
			
			System.out.println(properties);
			// can u call readProperties method
			// can u print properties object
			Connection connection = dbUtils.getConnection();
		}
		public Properties readProperties() {
			
			Properties properties = new Properties();
			
			InputStream inputStream = getClass()
					.getClassLoader()
					.getResourceAsStream("application.properties");
			Connection connection = null;
			try {
				Class.forName(properties.getProperty("com.mysql.cj.jdbc.Driver"));
				connection = DriverManager
						.getConnection(properties.getProperty("db.url"),
				           properties.getProperty("db.root"),
				           properties.getProperty("db.password"));
				return connection;
				
			}catch (ClassNotFoundException e) {	
				//properties.load(inputStream);
				//return properties;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
		}
		// singleton pattern.
		public Connection getConnection() {
		
			Properties properties = this.readProperties();
			
			Class.forName(properties.getProperty("db.className"));
			
			return null;
		}
		
		public void closeConnection(Connection connection) {
			try {
				connection.close();
				
			}catch (SQLException e ) {
				
				e.printStackTrace();
			}
		}

	}
*/













//*************

/*}
	private static DBUtils dbUtils;
	public static DBUtils getInstance() {
	
	 if(dbUtils==null) {
		 dbUtils = new DBUtils();
		 return dbUtils;
		 }
		return dbUtils;
	}
	
	public static void main(String[] args) {
		DBUtils dbUtils = getInstance();
		
		Properties properties = dbUtils.readProperties();
		
		System.out.println(properties);
		
		
		
		
		//dbutils singleton object
		//can u call readProperties method
		//can u print properties object
		
		
	
	public Properties readProperties() {
		
		Properties properties = new Properties();
		
		InputStream inputStream = getClass() //give u curent class name which is DB utils
				.getClassLoader() //load the current class
				.getResourceAsStream("application.properties");
		
		try {
			properties.load(inputStream);;
			return properties;
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		return null;
		
	}
	//singleton  ..I think i implement the wrong one ******************
	
	//singleton DP(default parameter)
	/*private static  EmployeeRepository;
	//private EmployeeRepositoryALImpl() {
		
		
	}
	
	public synchronized static EmployeeRepository getInstance() { //add synchronized keyword if hashcode are different use synchronized
		
		if(employeeRepository==null) {  //do this step   for singleton
			//return employeeRepository;
			
			synchronized (EmployeeRepository.class) { //start of synchronized  block method
			if(employeeRepository==null) {  //we need to mention EmployeeRepository.class) name above because this part is static
			employeeRepository= new EmployeeRepositoryALImpl();
			return employeeRepository;
		}            //end of synchronized block
		}
	
		}
		return employeeRepository;
	}*/
	
	
	
	/*public Connection getConnection() {
		
	Class.forName(null)
		
		return null;
		
	}
	
	public void closeConnection(Connection connection) {
	
	}
	
	
	}*/
