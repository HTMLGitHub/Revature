package com.revature.testing;

import java.util.Objects;

public class User
{
	private String name;
	private int age;
	
	public User() {}

	/**
	 * @param name
	 * @param age
	 */
	public User(String name, int age)
	{
		super();
		this.name = name;
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{ return name; }

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{ this.name = name; }

	/**
	 * @return the age
	 */
	public int getAge()
	{ return age; }

	/**
	 * @param age the age to set
	 */
	public void setAge(int age)
	{ this.age = age; }

	@Override
	public String toString()
	{
		return String.format("User [name=%s, age=%s, getClass()=%s, hashCode()=%s, toString()=%s]", name, age,
				getClass(), hashCode(), super.toString());
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{ return true; }
		if (!(obj instanceof User))
		{ return false; }
		User other = (User) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
}
