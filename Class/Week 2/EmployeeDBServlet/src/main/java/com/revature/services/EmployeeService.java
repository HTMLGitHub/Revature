package com.revature.services;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.EmployeeDAOImpl;

public class EmployeeService
{
	public static EmployeeDAO eDao = new EmployeeDAOImpl();
	private static Logger log = Logger.getLogger(Connection.class);
	

	public static boolean insert(Employee e)
	{
		return eDao.insert(e);
	}
	
	public static boolean update(Employee e)
	{
		return eDao.update(e);
	}
	
	public static List<Employee> findAll()
	{
		log.info("Finding All Employees...");
		return eDao.findAll();
	}
	
	public static Employee findByUserName(String username)
	{
		log.info("Finding All Employees...");
		
		List<Employee> all = findAll();
		
		for(Employee e: all)
		{
			log.info("Matching username");
			if(e.getUserName().equals(username))
			{
				return e;
			}
		}
		return null;
	}
	
	/**
	 * Confirm Login Method
	 * 
	 * <p>Takes in the user's name and password,
	 * then searching through the database for all employees.<p>
	 * 
	 * <p>If the username is found, compares it with the username's password.<p>
	 * 
	 * <p>If the username's password matches what is in the database, the Employee
	 * is returned.<p>
	 * 
	 * <p>Otherwise, <code>null<code> is returned.<p>
	 * */
	public static Employee confirmLogin(String username, String password)
	{
		Employee e = findByUserName(username);
		if(e==null) return null;
		
		if(e.getPassword().equals(password))
		{
			log.info("Login Successful");
			return e;
		}
		else return null;
	}
}
