package com.example.sessionservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.SuperVillain;

public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SessionServlet() 
    {
        super();   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		SuperVillain muddy = new SuperVillain("Mud Man", "Mud Armor", 100000);
		
		/*
		 * The Httpsession interface provides a way to identify a user 
		 * across more than just one page request or visit to a web site and to store info about
		 * that user. This makes User Experience (UX) better!
		 * 
		 * This doGet() method is using this interface to create a session between 
		 * */
		HttpSession session = request.getSession();
		
		session.setAttribute("Villian", muddy);
		
		PrintWriter out = response.getWriter();
		out.write(new ObjectMapper().writeValueAsString(muddy));
		out.println("Mud man is on the loose and the session is set"); //this will print to the screen
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//when i hit doPost() (so, i send a POST method to this servlet, I CREATE a new villain object 
		//1. Capture parameters
		String name = request.getParameter("name");
		String superPower = request.getParameter("superpower");
		int bounty = Integer.parseInt(request.getParameter("bounty")); //transforming string to integer
		
		//2 use the captured params to build a supervillain obj
		SuperVillain tempVill = new SuperVillain(name, superPower, bounty);
		
		//3. grab the HttpSession obj from teh request with getSession()
		HttpSession session = request.getSession();
		
		//4. Set teh "villain" attribute = to the custom villain (tempVill
		session.setAttribute("villain", tempVill);
		
		//5. print to teh sceen that A villain is on the loose
		PrintWriter out = response.getWriter();
		out.println("A villain is on the loose...!");
		out.write(new ObjectMapper().writeValueAsString(tempVill));
		
		//then, I open an HttpSession obj...and I set teh attribute as session.setAttribute("villain", tempVillain);
		
		
	}

}
