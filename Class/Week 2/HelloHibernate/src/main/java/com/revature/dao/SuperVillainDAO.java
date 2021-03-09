package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.revature.models.SuperVillain;
import com.revature.util.HibernateUtil;

/*
 * 3 differnent ways to write complex queries in Hibernate
 * 1. HQL - Hibernate Query Language
 * 2. Criteria API
 * Native SQL
 * */

public class SuperVillainDAO 
{
	
	public void insert(SuperVillain villain)
	{
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(villain);
		tx.commit();
	}
	
	public void update(SuperVillain villain)
	{
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.update(villain);
		tx.commit();
	}
	
	public SuperVillain selectById(int id)
	{
		Session ses = HibernateUtil.getSession();
		
		SuperVillain vill = ses.get(SuperVillain.class, id); // we can only use 
		
		return vill;
	}
	
	public SuperVillain selectByName(String name)
	{
		Session ses = HibernateUtil.getSession();
		
		//HQL - Hibernate Query Language
		//Creates a complex query by using a combination of native 
		//SQL and OOP
		//HQL targets Java Objects, NOT SQL tables
		
		List<SuperVillain> villList = ses.createQuery("from SuperVillain where name='" + name + "'", SuperVillain.class).list();
		
		//Native SQL
		//Create complex querier using plain old SQL
		//Native ?SQL targets SQL tables, NOT Java Objects
		
		//List<SuperVillain> villList = ses.createNativeQuery("SELECT * FROM Super_Villain WHERE name = '" + name + "'" + SuperVillain.class).list();
		
		//Criteria API
		//Creates comples queries programmatically...it only uses OOP
		//Crioteria API targets Java Objects
		
		//List<SuperVillain> villList = ses.createCriteria(SuperVillain.class).add(Restrictions.like("name", name)).list();
		
		
		if(villList.size() == 0)
		{
			System.out.println("PANIC -- NO VILLAIN FOUNE WITH THAT NAME");
			return null;
		}
		
		return villList.get(0);
	}
	
	public List<SuperVillain> selectAll()
	{
		Session ses = HibernateUtil.getSession();
		
		List<SuperVillain> villList = ses.createQuery("from SuperVillain", SuperVillain.class).list();
		//HQL is returning all instances of the SuperVillain List
		
		//Notice that we dont need a Transaction Object here...
		//We are just Querying data, not inserting 
		return villList;
	}
}
