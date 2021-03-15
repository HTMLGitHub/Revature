package com.revature.services;

import java.util.List;
import com.revature.models.Manager;
import com.revature.models.ReimbursementInfo;
import com.revature.models.User;
import com.revature.repositories.ManagerDAO;
import com.revature.repositories.ManagerDaoImpl;
import com.revature.repositories.ReimbursementDAO;
import com.revature.repositories.ReimbursementDaoImpl;

public class ManagerService
{
	
	private static ReimbursementDAO rDao = new ReimbursementDaoImpl();
	private static ManagerDAO mDao = new ManagerDaoImpl();
	
	public static boolean insertManager(Manager boss)
	{
		return mDao.insert(boss);
	}
	public static List<User> findAllEmployees()
	{
		return UserService.findUsersByPosition(1);
	}
	
	public static List<User> findAllUsers()
	{
		return UserService.findAllUsers();
	}
	
	public static boolean updateRequest(ReimbursementInfo rI)
	{
		return rDao.updateReimbursementRequest(rI);  
	}
	
	public static List<ReimbursementInfo> findPending(boolean status)
	{
		return rDao.findRecordsByStatus(status);
	}
	
	public static List<ReimbursementInfo> findAllRecords()
	{
		return rDao.getAllRecords();
	}
	
	public static List<ReimbursementInfo> findUserRecord(String name)
	{
		return rDao.findRecordsByName(name);
	}
}
