package com.example.directservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.SuperVillain;

public class DirectServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(DirectServlet.class);
	
	/*
	 * 3 steps to create a servlet:
	 * 
	 * 1: create a class that inherits from HttpServlet or GenericServlet
	 * 
	 * 2: Override the 'doGet' and 'doPost' methods
	 *  -we DO NOT  override the 'init() method (abstracted)
	 *  
	 *  3: Configure the servlet in yoru web.xml (Deployment Descriptor)
	 * */
	
	//this method allows a servlet to handle a GET request
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		//when this servlet recieves a 'get' request, I want it to simply write to the browser, "Hey!"
		res.setContentType("text/html");
		
		//PrinteWriter is an object that prints text data to a char stream
		//we can call it on the response
		PrintWriter out = res.getWriter();
		
		out.println("<html><body><h1>The Servlet is talking directly to the client!</h1></body></html>");
		log.info("We're inside the directServlet 'doGet()' method");
	}
	
	//we hit this method with a POST request from POSTMAN at "http://localhost
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		//the object that i send back will correspond to an object that ive definded in a CLASS for in my java app.
		res.setContentType("application/json");
		
		//Step 1: create a super villain
		SuperVillain sheev = new SuperVillain("Sheev Palpatine", "Evilness", 250000);
		
		//step 2: send this super villain as a JSON object to the browser
		//this will return the json object as the HTTP repsonse
		res.getWriter().write(new ObjectMapper().writeValueAsString(sheev));
		
		log.info("We're in the directServlet 'doPost()' method");
		
	}
}
