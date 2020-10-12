package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.Addevent;
import com.pojo.Registration;


@WebServlet("/SearchEventServlet")
public class SearchEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BLManager bl=new BLManager();
	Addevent a=new Addevent();
	Registration reg=new Registration();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		PrintWriter out = response.getWriter();
		
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("email");

		String etype = request.getParameter("etype");
		
		List<Addevent> ls=bl.serachbyeventname(etype);
		session.setAttribute("ename",ls);
		
		response.sendRedirect("viewEventUser1.jsp");
		
	}

}
