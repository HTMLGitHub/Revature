package com.revature.services;

import com.revature.models.User;

public class EmployeeService
{
	
	public static User viewInformation(User personalUser)
	{
		return UserService.findUserByFirstName(personalUser.getFirstName());
	}
	
	public static Boolean updateInformation(User personalUser)
	{
		return UserService.update(personalUser);
	}
	
}
