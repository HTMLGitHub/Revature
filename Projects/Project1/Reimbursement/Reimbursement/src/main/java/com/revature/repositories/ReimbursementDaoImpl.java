/**
 * 
 */
package com.revature.repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.ReimbursementInfo;
import com.revature.util.connectionUtil;

/**
 * @author bak12
 *
 */
public class ReimbursementDaoImpl implements ReimbursementDAO 
{
	//for logging all information to file
	private static Logger log = Logger.getLogger(ReimbursementDaoImpl.class);

	@Override
	public boolean sendNewReimbursmentRequest(ReimbursementInfo rI)
	{
		try(Connection conn = connectionUtil.getConnection())
		{
			if(rI.getOtherReason()!=null)
			{
				String sql = "INSERT INTO reimbursment_info (submitted, finished, reason, other_reason, amount, submittedby, completedby, pending) VALUES (?, null, ?, ?, ?, ?, null, true);";
			
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setDate(1, rI.getSubmitted());
				stmt.setString(2, rI.getReason());
				stmt.setString(3, rI.getOtherReason());
				stmt.setDouble(4, rI.getAmount());
				stmt.setString(5, rI.getSubmittedBy());
				
				stmt.executeUpdate();
			}
			
			if(rI.getOtherReason()==null)
			{
				String sql = "INSERT INTO reimbursment_info (submitted, finished, reason, other_reason, amount, submittedby, completedby, pending) VALUES (?, null, ?, null, ?, ?, null, true);";
				
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setDate(1, rI.getSubmitted());
				stmt.setString(2, rI.getReason());
				stmt.setDouble(3, rI.getAmount());
				stmt.setString(4, rI.getSubmittedBy());
				
				stmt.executeUpdate();
			}
		}
		catch (SQLException e)
		{
			log.warn("Unable to submit request\n" + e.getMessage());
			return false;
		}
		
		//Request submitted successfully
		log.info("Request sent for approval");
		return true;
	}
	
	@Override
	public boolean updateReimbursementRequest(ReimbursementInfo newInfo)
	{
		try(Connection conn = connectionUtil.getConnection())
		{
			String sql = "UPDATE reimbursment_info " //25 characters
					+ "SET finished=?, completedby=?, pending=? " //total 66 characters
					+ "WHERE id=(SELECT reimbursement_id FROM manager);";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setObject(1, newInfo.getFinished());
			stmt.setString(2, newInfo.getCompletedBy());
			stmt.setBoolean(3, newInfo.isPending());
			
			stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			log.warn("Unable to update reimbursment\n" + e.getMessage());
			return false;
		}
		log.info("Reimbursement successfully changed");
		return true;
	}

	@Override
	public List<ReimbursementInfo> findRecordsByName(String name)
	{
		List<ReimbursementInfo> records = new ArrayList<ReimbursementInfo>();
		
		try(Connection conn = connectionUtil.getConnection())
		{
			String sql = "SELECT * FROM reimbursment_info WHERE submittedby=?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				int id = rs.getInt("id");
				Date submitted = rs.getDate("submitted");
				Date finished = rs.getDate("finished"); //nullable
				String reason = rs.getString("reason");
				String other_reason = rs.getString("other_reason"); //nullable
				Double amount = rs.getDouble("amount");
				String submittedby = rs.getString("submittedby");
				String completedby = rs.getString("completedby"); //nullable
				boolean pending = rs.getBoolean("pending");
				
				ReimbursementInfo info = null;
				
				if(pending)
				{
					if(other_reason==null)
					{
						info = new ReimbursementInfo(id, submitted, reason, amount, submittedby, pending);
					}
					else
					{
						info = new ReimbursementInfo(id, submitted, reason, other_reason, amount, submittedby, pending);
					}
					
				}
				else
				{
					info = new ReimbursementInfo(id, submitted, finished, reason, other_reason, amount, submittedby, completedby, pending);
				}
				
				records.add(info);
			}
		}
		catch(SQLException ex)
		{
			log.warn("Unable to find any users \n" + ex.getMessage());
			return null;
		}
		
		if(records.isEmpty())
		{
			log.info("No users found with name " + name);
			return null;
		}
		else
		{	
			return records;
		}
	}

	
	@Override
	public List<ReimbursementInfo> findRecordsByStatus(boolean status)
	{
		List<ReimbursementInfo> records = new ArrayList<ReimbursementInfo>();
		
		try(Connection conn = connectionUtil.getConnection())
		{
			String sql = "SELECT * FROM reimbursment_info WHERE pending=?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setBoolean(1, status);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				int id = rs.getInt("id");
				Date submitted = rs.getDate("submitted");
				Date finished = rs.getDate("finished"); //nullable
				String reason = rs.getString("reason");
				String other_reason = rs.getString("other_reason"); //nullable
				Double amount = rs.getDouble("amount");
				String submittedby = rs.getString("submittedby");
				String completedby = rs.getString("completedby"); //nullable
				boolean pending = rs.getBoolean("pending");
				
				ReimbursementInfo info = null;
				
				if(pending)
				{
					if(other_reason==null)
					{
						info = new ReimbursementInfo(id, submitted, reason, amount, submittedby, pending);
					}
					else
					{
						info = new ReimbursementInfo(id, submitted, reason, other_reason, amount, submittedby, pending);
					}
					
				}
				else
				{
					info = new ReimbursementInfo(id, submitted, finished, reason, other_reason, amount, submittedby, completedby, pending);
				}
				
				records.add(info);
			}
		}
		catch(SQLException ex)
		{
			log.warn("Unable to retrieve records\n"+ ex.getMessage());
			return null;
		}
		if(records.isEmpty())
		{
			if(status)
			{
				log.info("No pending requests");
			}
			else
			{
				log.info("No completed requests");
			}
			
			return null;
		}
		else
		{
			return records;
		}
	}

	@Override
	public List<ReimbursementInfo> getAllRecords()
	{
		List<ReimbursementInfo> records = new ArrayList<ReimbursementInfo>();
		
		try(Connection conn = connectionUtil.getConnection())
		{
			String sql = "SELECT * FROM reimbursment_info;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				int id = rs.getInt("id");
				Date submitted = rs.getDate("submitted");
				Date finished = rs.getDate("finished"); //nullable
				String reason = rs.getString("reason");
				String other_reason = rs.getString("other_reason"); //nullable
				Double amount = rs.getDouble("amount");
				String submittedby = rs.getString("submittedby");
				String completedby = rs.getString("completedby"); //nullable
				boolean pending = rs.getBoolean("pending");
				
				ReimbursementInfo info = null;
				
				if(pending)
				{
					if(other_reason==null)
					{
						info = new ReimbursementInfo(id, submitted, reason, amount, submittedby, pending);
					}
					else
					{
						info = new ReimbursementInfo(id, submitted, reason, other_reason, amount, submittedby, pending);
					}
					
				}
				else
				{
					info = new ReimbursementInfo(id, submitted, finished, reason, other_reason, amount, submittedby, completedby, pending);
				}
				
				records.add(info);
			}
		}
		catch(SQLException ex)
		{
			log.warn("Unable to find any users\n" + ex.getMessage());
			return null;
		}
		
		if(records.isEmpty())
		{
			log.info("No records");
			return null;
		}
		else
		{
			return records;
		}
	}

}
