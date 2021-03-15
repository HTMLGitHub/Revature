package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.User;
import com.revature.util.connectionUtil;

public class UserDAOImpl implements UserDAO
{
	//for logging all information to file
	private static Logger log = Logger.getLogger(EmployeeDAOImpl.class);
		
	/**
	 * Attempts to insert a new user into the database.
	 * Will return true if the user was successfully entered into the database
	 **/
	@Override
	public boolean insert(User u) 
	{
		PreparedStatement stmt = null;
		
		try(Connection conn = connectionUtil.getConnection())
		{
			String sql = "INSERT INTO user_info (firstname, lastname, username, password, position) VALUES (?, ?, ?, ?, ?);";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, u.getFirstName());
			stmt.setString(2, u.getLastName());
			stmt.setString(3, u.getUserName());
			stmt.setString(4, u.getPassword());
			stmt.setInt(5, u.getPosition());
			
		}catch(SQLException ex)
		{
			log.warn("Unable to insert user", ex);
			return false;
		}
		
		//if everything is successful, we return true
		log.info(u.getFirstName() + " " + u.getLastName() + " was successfully entered into the database");
		return true;
	}

	/**
	 * Attempts to update a users information.
	 * Will return true if the user was found and updated.
	 */
	@Override
	public boolean update(User u) 
	{
		return false;
	}

	/**
	 * Attempts to delete a users information.
	 * Will return true if the user was found and deleted
	 */
	@Override
	public boolean delete(User u) 
	{
		return false;
	}
	
	/**
	 * Attempts to find and return all user
	 */
	@Override
	public List<User> findAllUsers()
	{
		List<User> list = new ArrayList<User>();
		
		try(Connection conn = connectionUtil.getConnection();)
		{		
			String sql = "SELECT * FROM user_info;";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				int id = rs.getInt("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int position = rs.getInt("position");
				
				User u = new User(id, firstname, lastname, username, password, position);
				list.add(u);
			}
			
		}
		catch(SQLException ex)
		{
			log.warn("Unable to return Users", ex);
		}
		return list;
	}

}
