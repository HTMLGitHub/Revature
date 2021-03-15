package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.*;

import com.revature.models.User;
import com.revature.repositories.UserDAOImpl;
import com.revature.services.UserService;

public class ServiceTests
{
	//class to be tested 
	private UserService userv;

	//dependencies that our service layer needs in order to make the contact with the DB
	//later we will MOCK this and trick our application into thinking it's connecting to a DB when it's not 
	private UserDAOImpl udaoImpl;
	
	@Before
	public void setup()
	{
		userv = new UserService();
		
		
		/**
		 * Here we are creating a fake DB connection...
		 * and tricking our Service layer
		 */
		udaoImpl = mock(UserDAOImpl.class);
		
		//here we set the EmployeeDAOImpl of the service to the one that we've mocked
		userv.uDao = udaoImpl;
	}
	
	/*
	 * A happy path is a default scenario in which we 
	 * allow it input and get expected output without exceptions
	 */
	@Test
	public void happyPathScenario()
	{
		User sampleUser = new User(1,"a", "b", "c", "d", 1);
		
		//create a fake list representing the list of Users pulled from the DB
		List<User> list = new ArrayList<User>();
		
		list.add(sampleUser);
		
		//we are essentially programming our fake dao to return this as its fake data
		when(udaoImpl.findAllUsers()).thenReturn(list);
		
		String dummyUserName = sampleUser.getUserName();
		User foundByUserName = userv.findUserByName(dummyUserName);
		
		assertEquals(sampleUser, foundByUserName);
		
	}
	
	@Test
	public void userIsNotPresentInDB()
	{
		/*
		 * the findAll() method in our DAOImpl class will always return a list
		 * (empty or populated) regardless --so I need to program it to
		 * return the empty list in my test case. 
		 */
		List<User> emptyList = new ArrayList<User>();
		
		when(udaoImpl.findAllUsers()).thenReturn(emptyList);
		
		User userFoundByUserName = userv.findUserByName("tester");
		assertEquals(null, userFoundByUserName);
	}
	
}

