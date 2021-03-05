package com.revature.services;

import java.util.List;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.EmployeeDAOImpl;

public class EmployeeService
{
	public static EmployeeDAO eDao = new EmployeeDAOImpl();
	
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
	public static Employee confirmLogin(String user_name, String password)
	{
		Employee e = findByUserName(user_name);
		if(e==null) return null;
		
		if(e.getPassword().equals(password))
		{
			return e;
		}
		else return null;
	}
}
