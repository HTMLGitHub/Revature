/**
 * 
 */
package com.revature.repositories;

import java.util.List;

import com.revature.models.ReimbursementInfo;

/**
 * @author bak12
 *
 */
public interface ReimbursementDAO
{
	public boolean sendNewReimbursmentRequest(ReimbursementInfo rI);
	public boolean updateReimbursementRequest(ReimbursementInfo newInfo);
	public List<ReimbursementInfo> findRecordsByName(String name);
	public List<ReimbursementInfo> findRecordsByStatus(boolean status);
	public List<ReimbursementInfo> getAllRecords();
	
}
