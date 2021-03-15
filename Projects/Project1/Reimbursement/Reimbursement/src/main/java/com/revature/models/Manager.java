package com.revature.models;

import java.util.Objects;

public class Manager
{
	private int id;
	private User user;
	private int reimbursment_id;

	public Manager(User user)
	{
		this.user = user;
	}
	
	public Manager(int reimbursement_id)
	{
		this.reimbursment_id = reimbursement_id;
	}
	
	/**
	 * @param user
	 * @param reimbursment_id
	 */
	public Manager(User user, int reimbursment_id)
	{
		this.user = user;
		this.reimbursment_id = reimbursment_id;
	}
	
	/**
	 * @param id
	 * @param user
	 * @param reimbursment_id
	 */
	public Manager(int id, User user, int reimbursment_id)
	{
		this.id = id;
		this.user = user;
		this.reimbursment_id = reimbursment_id;
	}
	
	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * @return the user
	 */
	public User getUser()
	{
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user)
	{
		this.user = user;
	}

	/**
	 * @return the reimbursment_id
	 */
	public int getReimbursment_id()
	{
		return reimbursment_id;
	}

	/**
	 * @param reimbursment_id the reimbursment_id to set
	 */
	public void setReimbursment_id(int reimbursment_id)
	{
		this.reimbursment_id = reimbursment_id;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id, reimbursment_id, user);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (!(obj instanceof Manager))
		{
			return false;
		}
		Manager other = (Manager) obj;
		return id == other.id && reimbursment_id == other.reimbursment_id && Objects.equals(user, other.user);
	}

	@Override
	public String toString()
	{
		return String.format("Manager [id=%s, user=%s, reimbursment_id=%s]", id, user, reimbursment_id);
	}
	
}
