package com.revature.models;

public class User 
{
	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private int position;
	
	public User() {}
	
	
	
	public User(String firstName, String lastName, String userName, String password, int position) 
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.position = position;
	}



	public User(int id, String firstName, String lastName, String userName, String password, int position)
	{
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.position = position;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public int getPosition() {
		return position;
	}



	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + position;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		
		if (obj == null) return false;
		
		if (getClass() != obj.getClass()) return false;
		
		User other = (User) obj;
		
		if (firstName == null)
		{
			if (other.firstName != null) return false;
		}
		else
			if (!firstName.equals(other.firstName)) return false;
		
		if (id != other.id) return false;
		
		if (lastName == null)
		{
			if (other.lastName != null) return false;
		}
		else
			if (!lastName.equals(other.lastName)) return false;
		if (password == null)
		{
			if (other.password != null) return false;
		}
		else
			if (!password.equals(other.password)) return false;
		
		if (position != other.position) return false;
		
		if (userName == null)
		{
			if (other.userName != null) return false;
		}
		else
			if (!userName.equals(other.userName)) return false; 
		return true;
	}



	@Override
	public String toString() {
		return String.format("User [id=%s, firstName=%s, lastName=%s, userName=%s, password=%s, position=%s]", id,
				firstName, lastName, userName, password, position);
	}
	
		
}
