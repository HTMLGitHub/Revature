package com.revature.services;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.ReimbursementInfo;
import com.revature.models.User;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.EmployeeDaoImpl;
import com.revature.repositories.ReimbursementDAO;
import com.revature.repositories.ReimbursementDaoImpl;

public class EmployeeService
{
	private static ReimbursementDAO rDao = new ReimbursementDaoImpl();
	private static EmployeeDAO eDao = new EmployeeDaoImpl();
	
	public static boolean insertEmployee(Employee servant)
	{
		return eDao.insert(servant);
	}
	
	public static User viewInformation(User personalUser)
	{
		return UserService.findUserByFirstName(personalUser.getFirstName());
	}
	
	public static boolean updateInformation(User personalUser, String updatedInfo, String whatsBeingUpdated)
	{
		return UserService.update(personalUser, updatedInfo, whatsBeingUpdated);
	}
	
	public static List<ReimbursementInfo> requestInfo(User user)
	{
		return rDao.findRecordsByName(user.getFirstName());
	}
	
	public static boolean submitReimbursementRequest(ReimbursementInfo rI)
	{
		return rDao.sendNewReimbursmentRequest(rI);
	}
}
