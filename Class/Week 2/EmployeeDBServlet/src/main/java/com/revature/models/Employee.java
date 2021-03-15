package com.revature.models;

import java.util.Objects;

public class Employee
{
	private int id;
	private int reimbursement_id ;
	
	public Employee() {}
		
	/**
	 * @param reimbursement_id
	 */
	public Employee(int reimbursement_id)
	{
		super();
		this.reimbursement_id = reimbursement_id;
	}

	/**
	 * @param id
	 * @param reimbursement_id
	 */
	public Employee(int id, int reimbursement_id)
	{
		super();
		this.id = id;
		this.reimbursement_id = reimbursement_id;
	}

	@Override
	public String toString() 
	{
		return String.format("Employee [id=%s, reimbursement_id=%s]", id, reimbursement_id);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the reimbursement_id
	 */
	public int getReimbursement_id() {
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
	public int hashCode() {
		return Objects.hash(id, reimbursement_id);
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
		
		return id == other.id && reimbursement_id == other.reimbursement_id;
	}

	
	
}
	
