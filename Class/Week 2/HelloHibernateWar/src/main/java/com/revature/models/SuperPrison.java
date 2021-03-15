package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Super_Prison")
public class SuperPrison
{
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="location")
	private String location;
	
	//We will signal to hibernate that this is a OneToMany relationship...
	@OneToMany(mappedBy="superPrisonHolder", fetch=FetchType.LAZY)
	private List<SuperVillain> vill_list = new ArrayList<SuperVillain>();

	public SuperPrison() {}
	
	
	
	public SuperPrison(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}

	public SuperPrison(String name, String location, List<SuperVillain> vill_list) {
		super();
		this.name = name;
		this.location = location;
		this.vill_list = vill_list;
	}

	public SuperPrison(int id, String name, String location, List<SuperVillain> vill_list) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.vill_list = vill_list;
	}

	@Override
	public String toString() {
		return "SuperPrison [id=" + id + ", name=" + name + ", location=" + location + ", vill_list=" + vill_list + "]";
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<SuperVillain> getVill_list() {
		return vill_list;
	}

	public void setVill_list(List<SuperVillain> vill_list) {
		this.vill_list = vill_list;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((vill_list == null) ? 0 : vill_list.hashCode());
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
		SuperPrison other = (SuperPrison) obj;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (vill_list == null) {
			if (other.vill_list != null)
				return false;
		} else if (!vill_list.equals(other.vill_list))
			return false;
		return true;
	}

	
}
