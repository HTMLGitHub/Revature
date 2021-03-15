package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil 
{
	/**
	 * Creating the HibernateUtil.java Helper file
	 * 
	 * To use Hibernate, you need to create a helper clas that handles startup
	 * and access Hibernate's SessionFactory to obtain a Session object
	 * 
	 * (interface)
	 * Session managed the connection to the DB and provides CRUD opertaions (Create, Read, Update, Delete)
	 * 
	 *  (class)
	 *  Configuration's job is to gather info from the hibernate.cfg.xml file and then build the Session Factory
	 *  
	 *  (interface)
	 *  Session Factory's jbo is to create session and store info on how to make connections to your DB	  
	 *  
	 *  (interface)
	 *  Transaciton manages transactions and cache (must be ACID)
	 *  
	 *  Query is used to write complex CRUD operations using HQL (Hibernate Query Language)
	 *  
	 *  Criteria is for programmically writing Select queries
	 *  	
	 */
	
	private static Session ses;
	
	//We will use the SessionFactory interface to create a Configuration()
	//Object which will call the .configure method on our "hibernate.cfg.xml"
	private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	//We create a getSession() method which is going to be called in our DAO layer
	//This method obtains a JDBC connection which we can use to perform a 
	//transaction against our DB
	public static Session getSession()
	{
		if(ses==null)
		{
			ses = sf.openSession();
		}
		
		return ses;
	}
	
	
	//By closing our session, you free up the connection from the connection pool
	//So that it can be used by a new session
	public static void closeSession()
	{
		ses.close();
		sf.close();
	}
	
}
