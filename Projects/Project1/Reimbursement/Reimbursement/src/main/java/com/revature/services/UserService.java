package com.revature.services;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Employee;
import com.revature.models.Manager;
import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.repositories.UserDAOImpl;

public class UserService
{
	private static UserDAO uDao = new UserDAOImpl();
	private static Logger log = Logger.getLogger(Connection.class);
	
	public static boolean insert(User u)
	{
		return uDao.insert(u);
	}
	
	public static boolean update(User u, String theNewUpdate, String whatsBeingUpdated)
	{
		return uDao.updateUsersInformation(u, theNewUpdate, whatsBeingUpdated);
	}
	
	
	public static List<User> findAllUsers()
	{
		log.info("Finding All Employees...");
		return uDao.findAllUsers();
	}
	
	public static User findUserByFirstName(String name)
	{
		log.info("Finding all users");
		
		List<User> users = findAllUsers();
		
		log.info("Finding " + name);
		
		for(User u: users)
		{
			if(u.getFirstName().equals(name)) return u;
		}
		
		log.info("No user found with first name: " + name);
		return null;
	}
	
	public static User findUserByName(String username)
	{
		log.info("Finding All Users...");
		
		List<User> all = findAllUsers();
		
		for(User u: all)
		{
			log.info("Finding " + username);
			if(u.getUserName().equals(username))
			{
				return u;
			}
		}
		log.info("No user found with username: " + username);
		return null;
	}
	
	public static User findByUserId(int id)
	{
		log.info("Finding All Users");
		
		List<User> users = findAllUsers();
		
		for(User u: users)
		{
			log.info("Finding id: " + id);
			if(u.getId() == id) return u;
		}
		log.info("No user found with id: " + id);
		return null;
	}
	
	public static List<User> findUsersByPosition(int position)
	{
		log.info("Finding all Users");
		
		List<User> users = findAllUsers();
		List<User> positionedUser = new ArrayList<User>();
				
		if(position == 1)
		{
			log.info("Finding all employees");
		}
		else
		{
			log.info("Finding all managers");
		}
		
		for(User u: users)
		{
			if(u.getPosition()==position)
			{
				positionedUser.add(u);
			}
		}
		return positionedUser;
	}
		
	/**
	 * Confirm Login Method
	 * 
	 * <p>Takes in the user's name and password,
	 * then searching through the database for all Users.<p>
	 * 
	 * <p>If the username is found, compares it with the username's password.<p>
	 * 
	 * <p>If the username's password matches what is in the database, the User
	 * is returned.<p>
	 * 
	 * <p>Otherwise, <code>null<code> is returned.<p>
	 * @return 
	 * */
	@SuppressWarnings("unchecked")
	public static <T> T confirmLogin(String username, String password)
	{
		User u = findUserByName(username);
		if(u==null)
		{
			return null;
		}
		
		if(u.getPassword().equals(password))
		{
			log.info("Login Successful");
			if(u.getPosition() == 1)
			{
				Employee e = new Employee(u);
				return (T) e;
			}
			else
				if(u.getPosition()==2)
				{
					Manager m = new Manager(u);
					
					return (T)m;
				}
		}
		return null;
	}
}
