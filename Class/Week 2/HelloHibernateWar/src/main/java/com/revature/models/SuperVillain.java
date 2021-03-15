package com.revature.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/*
 * JPA (Java Persistence API) This is the specification and Hibernate is the implementation
 * 
 * We communicate with teh Schema through Hibernate by using annotations to define our tables, columns, and relationships from the JPA
 * */
@Cacheable
@Entity //we can use HQL to target this Object
@Table(name="Super_Villain") //tables can be capitalized

public class SuperVillain
{
	@Id
	@Column(name="svill_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="name", unique=true, nullable=false)
	private String name; //HQL targets this
	
	@Column(name="power", nullable=false)
	private String power;
	
	@Column(name="bounty")
	private double bounty;
	
	//This is a many to many relationship
	//2 ways to retrieve data
	//1. Lazy fetching: the associated data is not loaded into menory UNTIL we call getCrimes()
	//2. Eager fetching: the associated data will be readily loaded into memory and available.
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	//a separate "virtual" joins table will be created in memory
	private List<Crime> crimes;

	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="Prison_FK")
	private SuperPrison superPrisonHolder;
	
	public SuperVillain() {super();}
	
	public SuperVillain(String name, String power, double bounty, List<Crime> crimes, SuperPrison superPrisonHolder) {
		super();
		this.name = name;
		this.power = power;
		this.bounty = bounty;
		this.crimes = crimes;
		this.superPrisonHolder = superPrisonHolder;
	}

	public SuperVillain(int id, String name, String power, double bounty, List<Crime> crimes,
			SuperPrison superPrisonHolder) {
		super();
		this.id = id;
		this.name = name;
		this.power = power;
		this.bounty = bounty;
		this.crimes = crimes;
		this.superPrisonHolder = superPrisonHolder;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public double getBounty() {
		return bounty;
	}

	public void setBounty(double bounty) {
		this.bounty = bounty;
	}

	public List<Crime> getCrimes() {
		return crimes;
	}

	public void setCrimes(List<Crime> crimes) {
		this.crimes = crimes;
	}

	public SuperPrison getSuperPrisonHolder() {
		return superPrisonHolder;
	}

	public void setSuperPrisonHolder(SuperPrison superPrisonHolder) {
		this.superPrisonHolder = superPrisonHolder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(bounty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((crimes == null) ? 0 : crimes.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((power == null) ? 0 : power.hashCode());
		result = prime * result + ((superPrisonHolder == null) ? 0 : superPrisonHolder.hashCode());
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
		SuperVillain other = (SuperVillain) obj;
		if (Double.doubleToLongBits(bounty) != Double.doubleToLongBits(other.bounty))
			return false;
		if (crimes == null) {
			if (other.crimes != null)
				return false;
		} else if (!crimes.equals(other.crimes))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (power == null) {
			if (other.power != null)
				return false;
		} else if (!power.equals(other.power))
			return false;
		if (superPrisonHolder == null) {
			if (other.superPrisonHolder != null)
				return false;
		} else if (!superPrisonHolder.equals(other.superPrisonHolder))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SuperVillain [id=" + id + ", name=" + name + ", power=" + power + ", bounty=" + bounty + ", crimes="
				+ crimes + ", superPrisonHolder=" + superPrisonHolder + "]";
	}

	
	
}