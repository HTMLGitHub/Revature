package com.revature.util;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.models.LoginTemplate;
import com.revature.services.UserService;

public class RequestHelper 
{
	private static Logger log = Logger.getLogger(RequestHelper.class);
	private static ObjectMapper om = new ObjectMapper();
	
	public static void processLogin(HttpServletRequest req, HttpServletResponse response) throws IOException
	{
		//WE want to return whatever we receive as the request (req) into a string to process
		BufferedReader reader = req.getReader();
		StringBuilder s = new StringBuilder();
		
		//logic to transfer everything from our reader to our string builder
		String line = reader.readLine();
		while(line!=null)
		{
			s.append(line);
			line = reader.readLine();
		}
		
		String body = s.toString();
		log.info(body);
		
		//I'm going to build a model called LoginTemplate which holds a username and password
		LoginTemplate loginAttempt = om.readValue(body, LoginTemplate.class); //from JSON --> java object
		
		String username = loginAttempt.getUsername();
		String password = loginAttempt.getPassword();
		
		log.info("User attempted to log in with User Name: " + username);
		
		User u = UserService.confirmLogin(username, password);
		
		if(u!=null)
		{
			//get the current session, or create one if it doesn't exist
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			
			PrintWriter pw = response.getWriter();
			response.setContentType("application/json");
			
			
			//this is converting our Java Object (with property firstname!) to JSON format ...
			//that means we can grab the firstName property after we parse it
			pw.println(om.writeValueAsString(u));
			
						
			log.info(username + " has successfully logged in");
		}
		else
		{
			response.setStatus(204); // this means that we still have a connection, but no user was found
		}
	}
	
	public static void processLogout(HttpServletRequest req, HttpServletResponse response) throws IOException
	{
		HttpSession session = req.getSession(false);//I'm capturing the session, but if there isn't one, I do not create a new one.
		log.info("Processing Info");
		
		if(session!=null)
		{
			String username = (String)session.getAttribute("username");
			log.info(username + " has logged out");
			
			session.invalidate();
		}
		
		response.setStatus(200);
	}
	
	public static void processEmployee(HttpServletRequest req, HttpServletResponse response) throws IOException
	{
		//1. Set the content type to app/json because we will be sending json back to the client,
		//stuck alongside the response
		
		response.setContentType("application/json");
		//2. GEt a list of all Employees in the DB
		List<User> allEmps = UserService.findUsersByPosition(1);
		
		//3. turn the list of java Objs into json string
		String json = om.writeValueAsString(allEmps);
		
		PrintWriter pw = response.getWriter();
		pw.println(json);
	}
	
	public static void processManager(HttpServletRequest req, HttpServletResponse response) throws IOException
	{
		response.setContentType("application/json");
		List<User> allManagers = UserService.findUsersByPosition(2);
		String json = om.writeValueAsString(allManagers);
		PrintWriter pw = response.getWriter();
		pw.println(json);
	}

	public static void processError(HttpServletRequest request, HttpServletResponse response) 
	{
		//I will add some custom funtionality to redirect teh user to an error page!
   		try 
   		{
			//we do not create a new request
   			//we also maintian the url
   			request.getRequestDispatcher("error.html").forward(request, response);
		} 
   		catch (ServletException | IOException e) 
   		{
			e.printStackTrace();
		}
	}
}
