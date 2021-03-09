package com.revature.driver;

import java.util.ArrayList;
import java.util.List;

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
		initialValues();
		
		//run a selectAll statement from one of our DAO's
		SuperPrisonDAO spdao = new SuperPrisonDAO();
		
		System.out.println(spdao.selectAllPrisons());
		
		HibernateUtil.closeSession();
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

}
