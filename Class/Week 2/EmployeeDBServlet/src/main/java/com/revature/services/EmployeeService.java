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
		return eDao.findAll();
	}
	
	public static Employee findByUserName(String username)
	{
		List<Employee> all = eDao.findAll();
		
		for(Employee e: all)
		{
			if(e.getUserName().equals(username))
			{
				return e;
			}
		}
		return null;
	}
	
	//confirm login method
	public static Employee confirmLogin(String username, String password)
	{
		Employee e = findByUserName(username);
		if(e==null) return null;
		
		if(e.getPassword().equals(password))
		{
			return e;
		}
		else return null;
	}
}
