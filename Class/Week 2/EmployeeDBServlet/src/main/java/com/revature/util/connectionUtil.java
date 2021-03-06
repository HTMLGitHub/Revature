package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class connectionUtil 
{
//this is boilerplate code
	private static Logger log = Logger.getLogger(Connection.class);
	
	public static Connection getConnection()
	{
		try
		{
			Class.forName("org.postgresql.Driver");
		}
		catch(ClassNotFoundException e)
		{
			log.warn("Cannot load the driver");
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		
		//this ClassLoader isn't always necessary, but it's an obj used to search through our entire project
		//to find our connection.properties file to give us the connections credentials
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		
		Connection conn = null;
		
		try
		{
			prop.load(loader.getResourceAsStream("connection.properties"));
			
			//capture the connection URL
			String url = prop.getProperty("url");
			//capture the username
			String username = prop.getProperty("username");
			//capture the password
			String password = prop.getProperty("password");
			
			try
			{
				conn= DriverManager.getConnection(url, username, password);
				log.info("connection successful");
			}
			catch(SQLException e)
			{
				log.warn("Unable to obtain a connection to database");
			}
			
			
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}
		log.info("Connected to DB");
		return conn;
	}
}
