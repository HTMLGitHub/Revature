package com.revature.services;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.EmployeeDAOImpl;

public class EmployeeService
{
	public static EmployeeDAO eDao = new EmployeeDAOImpl();
	private static Logger log = Logger.getLogger(Connection.class);
	
	public static void main(String[] args) 
	{
		Employee Ashli = new Employee(	"Ashli", 		"Lee", 		"Ash", 			"pw1", 		2);
		Employee Krystal = new Employee("Krystal",		"Lee", 		"Coco", 		"pw2", 		2);
		Employee Bridget = new Employee("Bridget", 		"Lee", 		"Bridge", 		"pw3", 		2);
		Employee Rileigh = new Employee("Rileigh", 		"Lee", 		"Rye", 			"pw4", 		2);
		Employee Emelia = new Employee(	"Emelia", 		"Lee", 		"Emmy", 		"pw5", 		2);
		Employee WOW = new Employee(	"Wade", 		"Watts", 	"WOW", 			"Parzival",	1);
		Employee Ken = new Employee(	"Ken", 			"Adams", 	"Joey", 		"Kenny",	1);
		Employee Wade = new Employee(	"Wade", 		"Wilson", 	"Deadpool", 	"Dead1",	1);
		Employee James = new Employee(	"James", 		"Howlett",	"Wolverene",	"Logan",	1);
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(Ashli);
		employees.add(Krystal);
		employees.add(Bridget);
		employees.add(Rileigh);
		employees.add(Emelia);
		employees.add(WOW);
		employees.add(Ken);
		employees.add(Wade);
		employees.add(James);
		
		List<Boolean> done = new ArrayList<Boolean>(Arrays.asList(new Boolean[9]));
		Collections.fill(done, Boolean.FALSE);
		
		for(int i = 0; i < employees.size(); i++)
		{
			done[i] = 
		}
		
	}
	
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
