package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BLManager;
import com.pojo.Registration;
import com.pojo.Role;


@WebServlet("/Registrationservlet")
public class Registrationservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	BLManager bl = new BLManager();
	Registration r = new Registration();
	Role role1=new Role();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String role = request.getParameter("role");
		
		Date cd = new Date();
		
		role1=bl.serachbyrole(role);
		
		r.setRole(role1);
		r.setFname(fname);
		r.setLname(lname);
		r.setEmail(email);
		r.setPassword(pass);
		r.setRegdate(cd);
		
		bl.saveregister(r);
		
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Register Successfully..');");
		out.println("location='registration.jsp';");
		out.println("</script>");
	}

}
