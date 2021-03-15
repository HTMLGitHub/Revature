package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.log4j.Logger;

import com.revature.models.Employee;
import com.revature.util.connectionUtil;

public class EmployeeDaoImpl implements EmployeeDAO
{

	//for logging all information to file
	private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);
		
	@Override
	public boolean insert(Employee servant)
	{
		try(Connection conn = connectionUtil.getConnection())
			{
				String sql = "INSERT INTO employee (id, reimbursement_id) VALUES (?,?);";
				PreparedStatement stmt = conn.prepareStatement(sql);
				
				stmt.setInt(1, servant.getUser().getId());
				stmt.setInt(2, servant.getReimbursement_id());
				stmt.executeUpdate();
			}
			catch (SQLException e)
			{
				log.warn("Unable to add employee\n" + e.getMessage());
				return false;
			}
			log.info(servant.getUser().getFirstName() + " successfully added as employee");
			return true;
	}
}