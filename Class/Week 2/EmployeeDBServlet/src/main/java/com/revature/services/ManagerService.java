package com.revature.services;

import java.util.List;

import com.revature.models.User;

public class ManagerService
{
	public static List<User> findAllEmployees()
	{
		return UserService.findUsersByPosition(1);
	}
	
	public static boolean fireEmployee(User u)
	{
		return UserService.delete(u);
	}
}
