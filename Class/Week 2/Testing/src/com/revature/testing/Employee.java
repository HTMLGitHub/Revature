package com.revature.testing;

import java.util.Objects;

public class Employee extends User
{

	private String username;
	private String password;
	
	/**
	 * @param name
	 * @param age
	 */
	public Employee(String name, int age)
	{
		super(name, age);
	}

	/**
	 * @param name
	 * @param age
	 * @param username
	 * @param password
	 */
	public Employee(String name, int age, String username, String password)
	{
		super(name, age);
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString()
	{
		return String.format(
				"Employee [username=%s, password=%s, getName()=%s, getAge()=%s, toString()=%s, hashCode()=%s, getClass()=%s]",
				username, password, getName(), getAge(), super.toString(), hashCode(), getClass());
	}

	/**
	 * @return the username
	 */
	public String getUsername()
	{ return username; }

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username)
	{ this.username = username; }

	/**
	 * @return the password
	 */
	public String getPassword()
	{ return password; }

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password)
	{ this.password = password; }

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(password, username);
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{ return true; }
		if (!super.equals(obj))
		{ return false; }
		if (!(obj instanceof Employee))
		{ return false; }
		Employee other = (Employee) obj;
		return Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
}
