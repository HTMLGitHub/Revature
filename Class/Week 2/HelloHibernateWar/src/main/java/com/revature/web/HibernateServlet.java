package com.revature.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.SuperVillainDAO;
import com.revature.models.SuperVillain;




/**
 * Servlet implementation class HibernateServlet
 */
public class HibernateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static SuperVillainDAO svDao = new SuperVillainDAO();
    /**
     * Default constructor. 
     */
    public HibernateServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("We are in the doGet() method/n\nAbout to select by name: ");
		System.out.println(svDao.selectByName("Joker"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		SuperVillain joker = svDao.selectByName("Joker");
		
		response.setContentType("application/json");
		
		response.getWriter().write(new ObjectMapper().writeValueAsString(joker.toString()));
	}

}
