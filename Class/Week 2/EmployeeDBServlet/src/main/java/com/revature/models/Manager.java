package com.revature.models;

import java.util.Objects;

public class Manager 
{
	private int id;
	private int reimbursment_id;
	
	/**
	 * 
	 */
	public Manager()
	{
	}

		
	/**
	 * @param reimbursment_id
	 */
	public Manager(int reimbursment_id)
	{
		this.reimbursment_id = reimbursment_id;
	}

	/**
	 * @param id
	 * @param reimbursment_id
	 */
	public Manager(int id, int reimbursment_id)
	{
		this.id = id;
		this.reimbursment_id = reimbursment_id;
	}

	@Override
	public String toString()
	{
		return String.format("Manager [id=%s, reimbursment_id=%s]", id, reimbursment_id);
	}

	/**
	 * @return the id
	 */
	public int getId()
	{ return id; }


	/**
	 * @param id 
	 * @return the id to set
	 */
	public void setId(int id)
	{ this.id = id; }


	/**
	 * @return the reimbursment_id
	 */
	public int getReimbursment_id()
	{ return reimbursment_id; }


	/**
	 * @param reimbursment_id 
	 * @return the reimbursment_id to set
	 */
	public void setReimbursment_id(int reimbursment_id)
	{ this.reimbursment_id = reimbursment_id; }

	@Override
	public int hashCode()
	{
		return Objects.hash(id, reimbursment_id);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{ return true; }
		if (!(obj instanceof Manager))
		{ return false; }
		Manager other = (Manager) obj;
		return id == other.id && reimbursment_id == other.reimbursment_id;
	}
	
	
}
