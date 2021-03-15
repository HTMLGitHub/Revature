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
	private static Logger log = Logger.getLogger(UserDAOImpl.class);
		
	/**
	 * @param User
	 * <p>Attempts to insert a new user into the database.<p>
	 * 
	 * @return boolean indicating whether the user was inserted into the database
	 * 
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
			
			stmt.executeUpdate();
			
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
	 *@param User
	 *<p>Attempts to update a users information.<p>
	 * 
	 *@return boolean indicating whether the user was updated
	 */
	@Override
	public boolean updateUsersInformation(User user, String newUpdate, String whatUpdating)
	{
		try(Connection conn = connectionUtil.getConnection())
		{
			String sql = "UPDATE user_info SET " + whatUpdating + " = ? WHERE " + whatUpdating + " = ?;";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, newUpdate);
						
			switch(whatUpdating)
			{
			case "firstname":
				stmt.setString(2, user.getFirstName());
				break;
			case "lastname": 
				stmt.setString(2, user.getLastName());
				break;
			case "username":
				stmt.setString(2, user.getUserName());
				break;
			case "password":
				stmt.setString(2, user.getPassword());
				break;
			}
			
			stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			switch(whatUpdating)
			{
			case "firstname":
				log.warn("Unable to update " + user.getFirstName() + " first name");
				break;
			case "lastname": 
				log.warn("Unable to update " + user.getFirstName() + " last name");
				break;
			case "username":
				log.warn("Unable to update " + user.getFirstName() + " user name");
				break;
			case "password":
				log.warn("Unable to update " + user.getFirstName() + " password");
				break;
			}
		}
		
		switch(whatUpdating)
		{
		case "firstname":
			log.info(user.getFirstName()+ " successfully changed first name changed to: " + newUpdate);
			break;
		case "lastname": 
			log.info(user.getLastName()+ " successfully changed last name changed to: " + newUpdate);
			break;
		case "username":
			log.info(user.getUserName()+ " successfully changed user name changed to: " + newUpdate);
			break;
		case "password":
			log.info(user.getPassword()+ " successfully changed password changed to: " + newUpdate);
			break;
		}
	
		return true;
	}

	/**
	 *@param none
	 *<p>Attempts to find and return all users<p>
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
			return null;
		}
		return list;
	}

	/**
	 *@param position
	 *<p>Attempts to find all Users with a particular position<p>
	 * 
	 * @return List of users that match the position
	 */
	@Override
	public List<User> findAllUsersByPosition(int position)
	{
		if(position == 1) log.info("Finding all employees...");
		if(position == 2) log.info("Finding all managers...");
		
		List<User> users = new ArrayList<User>();
		
		try(Connection conn = connectionUtil.getConnection())
		{
			String sql = "SELECT firstname, lastname, username FROM user_info WHERE position = ?;";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, position);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				int id = rs.getInt("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String username = rs.getString("username");
				String password = rs.getString("password");
				
				User u = new User(id, firstname, lastname, username, password, position);
				users.add(u);
			}
		}
		catch (SQLException e)
		{
			
			if(position == 1) log.warn("Could not find employees");
			if(position == 2) log.warn("Could not find managers");
		}
		return users;
	}

	

}
