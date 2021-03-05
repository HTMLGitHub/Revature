package com.example.indirectServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class IndirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(IndirectServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		log.info("In the indirect 'doGet()' method");
		
		//there is a method on hte response object called sendRedirect
		//this allows us to redirect the user to another resource
		
		//redirect to external page
		/*response.sendRedirect("https://www.google.com");*/
		
		//redirect to another servlet
		//response.sendRedirect("http://localhost:8080/HelloServlets/dirserv");
		
		//redirect to an HTML page
		response.sendRedirect("resources/html/somepage.html");
		
		//sendRirect saves query parameters (in the url)
	}

	/*
	 * 
	 * */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//redirect to an html page
		/*RequestDispatcher rdis = request.getRequestDispatcher("resources/html/somepage.html");*/
		
		//redirect to another servlet
		RequestDispatcher rdis = request.getRequestDispatcher("/dirserv");
				
		
		rdis.forward(request, response);
		
		
		
		//doGet(request, response);
	}

}
