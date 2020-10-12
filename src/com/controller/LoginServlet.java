package com.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.Registration;
import com.pojo.Role;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BLManager bl = new BLManager();
	Registration reg = new Registration();
	Role role = new Role();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

		boolean val = bl.validep(email,pass);

		if (val == true) 
		{
			Registration reg = bl.searchByEmailId(email);
			
			if(reg.getRole().getRolename().equals("Admin"))
			{
				String fname=reg.getFname();
				String email1=reg.getEmail();
				
				session.setAttribute("name",fname);
				session.setAttribute("email",email1);
				
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Welcome to Admin');");
				out.println("location='AdminHeader.jsp';");
				out.println("</script>");
				
			}else if(reg.getRole().getRolename().equals("User"))
			{
				String fname=reg.getFname();
				String email1=reg.getEmail();
				
				session.setAttribute("name",fname);
				session.setAttribute("email",email1);
				
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Welcome to User');");
				out.println("location='UserHeader.jsp';");
				out.println("</script>");
			}
			
			
		} else 
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Please Provide Correct Email Id & Password');");
			out.println("location='login.jsp';");
			out.println("</script>");
		}

	}
}
