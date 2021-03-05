package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import com.revature.util.RequestHelper;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   	{
   		
   		//we will rewrite the URL's 
   		final String URI = request.getRequestURI().replace("/EmployeeDBServlet/", "");
   		
   		switch(URI)
   		{
   		case "login":
   			RequestHelper.processLogin(request, response);
   			break;
   		case "logout":
   			RequestHelper.processLogout(request, response);
   			break;
   		case "employees":
   			RequestHelper.processEmployee(request, response);
   			break;
   		}
	}

   	
   	//this method's purpose is to return all employees from teh db in json form
   	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
