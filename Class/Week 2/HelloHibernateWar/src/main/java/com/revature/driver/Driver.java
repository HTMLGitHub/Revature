package com.revature.driver;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.revature.dao.CrimeDAO;
import com.revature.dao.SuperPrisonDAO;
import com.revature.dao.SuperVillainDAO;
import com.revature.models.Crime;
import com.revature.models.SuperPrison;
import com.revature.models.SuperVillain;
import com.revature.util.HibernateUtil;

public class Driver {

	/*
	 * What are the benefits of Hibernate?
	 * --fast
	 * object oriented
	 * it uses Cching (there are conneciton pool which minimize the bottle necked sped caused by forming DB connections)
	 * it's modular
	 * */
	public static void main(String[] args)
	{
		//initialValues();
		//firstLevelCaching();
		secondLevelCaching();
		HibernateUtil.closeSession();
	}
	
	public static void firstLevelCaching()
	{
		/*
		 * By default, Hibernate allows first level caching...
		 * 
		 * This means that any data that a partivular session retrives, is stored and accessible within the 
		 * context of that particular session (and no other session)
		 */
		
		Session ses1 = HibernateUtil.getSession();
		
		//I wil luse the session get() or load methods to return an entity (mapped object) from the database
		SuperVillain vill1 = ses1.load(SuperVillain.class, 4);
		
		System.out.println("First call output: " + vill1.getName());
		
		//this particular object is already in our cache, the session does not fire a call to the Database
		//Instead it loads what we have in our session's cache
		SuperVillain vill2 = ses1.load(SuperVillain.class, 4);
		
		System.out.println("Second call output: " + vill2.getName());
		
		//See here is that there's only 1 entry (JOKER) that we're retieving from our session-level cache
		System.out.println("The amount of entries in our session is " + ses1.getStatistics().getEntityCount());
		
		//Where is the cache?
		//Both the first level and second level is stored on the heap (created by the JVM..where all objects live)
		//
	}
	
	public static void initialValues()
	{
		//Create new Crime objs
		Crime Arson = new Crime("Arson", "Setting Something Ablaze");
		Crime Freeze = new Crime("Freeze", "Covering The Entire City In Ice");
		Crime Time = new Crime("Time Manipulation", "Freeze Time, Rob Banks");
		
		//create a CrimeDAO
		CrimeDAO crimesDao = new CrimeDAO();

		//use the crimeDAO to insert the crimes
		crimesDao.insert(Arson);
		crimesDao.insert(Freeze);
		crimesDao.insert(Time);
		
		//build a list of these crimes
		List<Crime> crimes = new ArrayList<Crime>();
		crimes.add(Arson);
		crimes.add(Freeze);
		crimes.add(Time);
		
		//create a superPrison
		SuperPrison Azkaban = new SuperPrison("Azkaban", "England");
		
		//Ill instantiate some superVillains
		SuperVillain Joker = new SuperVillain("Joker", "Evilness", 100000, crimes, Azkaban);
		
		//Create SuperVillainDAO here
		SuperVillainDAO criminalsDao = new SuperVillainDAO();
		criminalsDao.insert(Joker);
		
		//create a SuperPrisonDAO here
		SuperPrisonDAO prisonDao = new SuperPrisonDAO();
		
		//create a list of all villains
		List<SuperVillain> villains = new ArrayList<SuperVillain>();
		villains.add(Joker);
		
		
		Azkaban.setVill_list(villains);
		
		prisonDao.insert(Azkaban);		
	}

	/**
	 * Second Level Caching
	 * 
	 * by default, hibernate disables this...
	 * the developer is needed to enable it explicitly, 
	 * and the SessionFactory object is responsible for maintain it
	 */
	public static void secondLevelCaching()
	{
		
		
		//open 2 diffenrent sessions
		Session ses1 = HibernateUtil.getSession();
		Session ses2 = HibernateUtil.getSession();
		
		//When we load one particular entity from teh db with our first session
		//this object is accessible by all sessions 
		//(because it is accessible at the SessionFactory scope aka second level)
		SuperVillain vill1 = ses1.load(SuperVillain.class, 4); //here we get it from the DB and put it in the cache
		SuperVillain vill2 = ses1.load(SuperVillain.class, 4);//here we check for it FIRST if it's in the cache ..
		//it is, so we just return it instead of going back to the DB and getting another Enity
		System.out.println(vill1.getName());
		
		System.out.println(ses1.getStatistics().getEntityCount()); //this will return 1
		
		/*
		 * There are some handy methods we ca apply to sessions:
		 * 
		 * .evict() -- clears all the entities from teh particular session itself (only the session level)
		 * .clear()
		 * .refresh()
		 */
		
		//this will kick the entity our of the session's cache..
		//Now if the session wants it, it will need to fetch it from the DB again
		
		ses1.evict(vill1);
		
		System.out.println(ses1.getStatistics().getEntityCount());
		
		/**fetching the same entity again, using the same session
		*not going to the DB, it is checking the 2nd level cache
		*this object will be retrieved from the second level*/
		
		vill1 = ses1.load(SuperVillain.class, 4);
		
		vill1 = ses2.load(SuperVillain.class, 4);
		System.out.println(vill1.getName());
		System.out.println(ses1.getStatistics().getEntityCount());
		System.out.println(ses2.getStatistics().getEntityCount());
		
		
	}
}
