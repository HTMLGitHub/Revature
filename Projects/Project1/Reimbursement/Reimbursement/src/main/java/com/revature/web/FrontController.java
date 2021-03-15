package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.RequestHelper;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {super();}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//we will rewrite the URL's 
   		final String URI = request.getRequestURI().replace("/Reimbursement/", "");
   		
   		switch(URI)
   		{
   		case "submitRequest":
   			RequestHelper.processRequest(request, response);
   			break;
   		case "viewMyRequests":
   			RequestHelper.viewMyRequests(request, response);
   			break;
   		case "viewMyInformation":
   			RequestHelper.viewMyInformation(request, response);
   			break;
   		case "updateMyInformation":
   			RequestHelper.updateMyInformation(request, response);
   			
   			
   		//Manager Requests
   		case "updateRequest":
   			RequestHelper.updateRequest(request, response);
   			break;
   		case "viewPendingRequests":
   			RequestHelper.viewPending(request, response);
   			break;
   		case "viewAllResolvedRequests":
   			RequestHelper.viewResolved(request, response);
   			break;
   		case "viewAllRequests":
   			RequestHelper.viewAllRequests(request, response);
   			break;
   		case "viewRequestsFromSingle":
   			RequestHelper.findEmployeeRequest(request, response);
			break;
   		case "employee":
   			RequestHelper.findAllEmployees(request, response);
   			break;
   		
   			//general requests	
   		case "login":
   			RequestHelper.processLogin(request, response);
   			break;
   		case "logout":
   			RequestHelper.processLogout(request, response);
   			break;
   		case "error":
   			RequestHelper.processError(request, response);
   			break;
   		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//we will rewrite the URL's 
   		final String URI = request.getRequestURI().replace("/Reimbursement/", "");
   		
   		switch(URI)
   		{
   		//Employee Requests
   		case "submitRequest":
   			RequestHelper.processRequest(request, response);
   			break;
   		case "viewMyRequests":
   			RequestHelper.viewMyRequests(request, response);
   			break;
   		case "viewMyInformation":
   			RequestHelper.viewMyInformation(request, response);
   			break;
   		case "updateMyInformation":
   			RequestHelper.updateMyInformation(request, response);
   			
   			
   		//Manager Requests
   		case "updateRequest":
   			RequestHelper.updateRequest(request, response);
   			break;
   		case "viewPending":
   			RequestHelper.viewPending(request, response);
   			break;
   		case "viewResolved":
   			RequestHelper.viewResolved(request, response);
   			break;
   		case "viewAllRequests":
   			RequestHelper.viewAllRequests(request, response);
   			break;
   		case "findEmployeeRequest":
   			RequestHelper.findEmployeeRequest(request, response);
			break;
   		case "employee":
   			RequestHelper.findAllEmployees(request, response);
   			break;
   		
   			//general requests	
   		case "login":
   			RequestHelper.processLogin(request, response);
   			break;
   		case "logout":
   			RequestHelper.processLogout(request, response);
   			break;
   		case "error":
   			RequestHelper.processError(request, response);
   			break;
   		}

	}

}
