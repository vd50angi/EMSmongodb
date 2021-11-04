package com.cogent.emsmongodb.utils;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBConfig {
	
	public DataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl(environment.getProperty("db.url"));
		basicDataSource.setUsername(environment.getProperty("db.username"));
		basicDataSource.setPassword(environment.getProperty("db.password"));
		basicDataSource.setDriverClassName(environment.getProperty("db.className"));
         
		return basicDataSource;
	
	}
	
	
}
