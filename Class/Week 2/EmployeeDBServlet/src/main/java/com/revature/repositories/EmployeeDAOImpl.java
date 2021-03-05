package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Employee;
import com.revature.util.connectionUtil;


public class EmployeeDAOImpl implements EmployeeDAO 
{
	private static Logger log = Logger.getLogger(EmployeeDAOImpl.class);
	
	@Override
	public boolean insert(Employee e) {
		PreparedStatement stmt = null;
		
		try(Connection conn = connectionUtil.getConnection())
		{
			String sql = "INSERT INTO employee (firstname, lastname, username, password) VALUES (?, ?, ?, ?);";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, e.getFirstName());
			stmt.setString(2, e.getLastName());
			stmt.setString(3, e.getUserName());
			stmt.setString(4, e.getPassword());
			
			if(!stmt.execute()) 
			{
				log.warn("Unable to insert user");
				return false;
			}
			
		}catch(SQLException ex)
		{
			log.warn("Unable to insert user", ex);
			return false;
		}
		
		//if everything is successful, we return true
		log.info(e.getFirstName() + " " + e.getLastName() + " was successfully entered into the database");
		return true;
	}

	@Override
	public boolean update(Employee e) {
		
		
		return false;
	}

	@Override
	public List<Employee> findAll() 
	{
		List<Employee> list = new ArrayList<Employee>();
		
		try(Connection conn = connectionUtil.getConnection();)
		{
			
			
			String sql = "SELECT * FROM employee;";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				int id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String user_name = rs.getString("user_name");
				String password = rs.getString("password");
				
				Employee e = new Employee(id, first_name, last_name, user_name, password);
				list.add(e);
			}
			
		}
		catch(SQLException ex)
		{
			log.warn("Unable to return Users", ex);
		}
		return list;
	}

	@Override
	public boolean delete(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

}
