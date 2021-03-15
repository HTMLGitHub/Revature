package com.revature.repositories;

import java.util.List;

import com.revature.models.User;
/**
 * 
 * DAO stands for data access Object -- the object (in impl form) tha twe use to access our DB
 * We use the DAO design pattern to seperate business logic (java) from our persistence layer
 * */
public interface UserDAO 
{
	//DAO is for CRUD methods (Create Read Update Delete)
	public boolean insert(User u); 
	public boolean updateUsersInformation(User user, String newUpdate, String whatUpdating);
	public List<User> findAllUsers();//this will return ALL User objects from the DB. We will use this in our service layer and filter it to return JUST one employee that matches username + password
	public List<User> findAllUsersByPosition(int position);
}
