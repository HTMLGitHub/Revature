package com.revature.repositories;

import java.util.List;

import com.revature.models.Employee;

/*
 * DAO stands for data access Object -- the object (in impl form) tha twe use to access our DB
 * We use the DAO design pattern to seperate business logic (java) from our persistence layer
 * */
public interface EmployeeDAO 
{
	//DAO is for CRUD methods (Create R Update Delete)
	public boolean insert(Employee e); //returns true if successful inserted
	public boolean update(Employee e);
	public boolean delete(Employee e);
	
	public List<Employee> findAll(); //this will return ALL employee objects from the DB. We will use this in our service layer and filter it to return JUST one employee that matches username + password
}
