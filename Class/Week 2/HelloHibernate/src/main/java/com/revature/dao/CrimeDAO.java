package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Crime;
import com.revature.util.HibernateUtil;

/*
 * Session methods:
 * 
 * save() and persist() ----- result in a SQL insert
 * update() and merge() ----- result in a SQL update
 * saveOrUpdate() ----------- result in a SQL insert OR Update (Depends)
 * get() and load() --------- result in a SQL results in a SQL Select
 * */

public class CrimeDAO 
{
	//we will just create an insert method for Crime
	public void insert(Crime crime)
	{
		//1. catpure the session
		Session ses = HibernateUtil.getSession();
		
		//The transaction interface is used for managing ACID complient transactions against the DB
		//Transaction is a mechanism for dispatchign SSQL statemtnes against the DB
		Transaction tx = ses.beginTransaction(); //2. Perform an operation on the DB
		
		ses.save(crime);//3. use the save() session method to perform an insert operation
		
		tx.commit(); //4. commit the transactionby utilizing a method from the actual Transaction interface
		
	}
}
