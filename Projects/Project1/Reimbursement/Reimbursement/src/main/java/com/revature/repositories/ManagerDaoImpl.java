package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.log4j.Logger;

import com.revature.models.Manager;
import com.revature.util.connectionUtil;

public class ManagerDaoImpl implements ManagerDAO
{

	//for logging all information to file
	private static Logger log = Logger.getLogger(ReimbursementDaoImpl.class);
		
	@Override
	public boolean insert(Manager boss)
	{
		try(Connection conn = connectionUtil.getConnection())
		{
			String sql = "INSERT INTO manager (id, reimbursement_id) VALUES (?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, boss.getUser().getId());
			stmt.setInt(2, boss.getReimbursment_id());
			stmt.executeUpdate();
		}
		catch (SQLException e)
		{
			log.warn("Unable to insert manager\n" + e.getMessage());
			return false;
		}
		log.info(boss.getUser().getFirstName() + " successfully added as manager");
		return true;
	}
}
