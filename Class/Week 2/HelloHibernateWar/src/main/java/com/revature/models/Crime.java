package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//All these annotations are from the javax.persistence API
@Entity 				//Entity means a class that will be a table
@Table(name="Crime")	//here we specify the table name

public class Crime 
{
	@Id					//This mean that this column will be the Primary Key
	@Column(name="crime_id")
	@GeneratedValue(strategy=GenerationType.AUTO) //this is how we generate a serial value
	private int crimeId;
	
	@Column(name="crime_name", unique=true, nullable=false)
	private String crimeName;
	
	@Column(name="description")
	private String description;
	
	public Crime() {super();}
		
	public Crime(String crimeName, String description)
	{
		super();
		this.crimeName = crimeName;
		this.description = description;
	}


	public Crime(int crimeId, String crimeName, String description) 
	{
		super();
		this.crimeId = crimeId;
		this.crimeName = crimeName;
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + crimeId;
		result = prime * result + ((crimeName == null) ? 0 : crimeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Crime other = (Crime) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (crimeId != other.crimeId)
			return false;
		if (crimeName == null) {
			if (other.crimeName != null)
				return false;
		} else if (!crimeName.equals(other.crimeName))
			return false;
		return true;
	}

	public int getCrimeId() {
		return crimeId;
	}

	public void setCrimeId(int crimeId) {
		this.crimeId = crimeId;
	}

	public String getCrimeName() {
		return crimeName;
	}

	public void setCrimeName(String crimeName) {
		this.crimeName = crimeName;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Crime [crimeId=" + crimeId + ", crimeName=" + crimeName + ", description=" + description
				+ "]";
	}
	
	
}
