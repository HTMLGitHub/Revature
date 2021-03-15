package com.revature.models;

import java.util.Objects;

public class Employee
{
	private int id;
	private User user;
	private int reimbursement_id ;	

	public Employee(User user) 
	{
		this.user = user;
	}
	
	public Employee(int id, User user, int reimbursement_id) 
	{
		this.id = id;
		this.user = user;
		this.reimbursement_id = reimbursement_id;
	}
	
	/**
	 * @param reimbursement_id
	 * @param user
	 */
	public Employee(User user, int reimbursement_id)
	{
		this.reimbursement_id = reimbursement_id;
		this.user = user;
	}

	public int getId()
	{
		return id;
	}
	
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
	 * @return the reimbursement_id
	 */
	public int getReimbursement_id()
	{
		return reimbursement_id;
	}

	/**
	 * @param reimbursement_id the reimbursement_id to set
	 */
	public void setReimbursement_id(int reimbursement_id)
	{
		this.reimbursement_id = reimbursement_id;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id, reimbursement_id, user);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (!(obj instanceof Employee))
		{
			return false;
		}
		Employee other = (Employee) obj;
		return id == other.id && reimbursement_id == other.reimbursement_id && Objects.equals(user, other.user);
	}

	@Override
	public String toString()
	{
		return String.format("Employee [id=%s, user=%s, reimbursement_id=%s]", id, user, reimbursement_id);
	}
}