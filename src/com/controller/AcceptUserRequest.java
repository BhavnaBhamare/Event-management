package com.controller;

import java.io.IOException;



import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BLManager;
import com.model.Emailutil;
import com.pojo.Addevent;
import com.pojo.Booking;
import com.pojo.Registration;

@WebServlet("/AcceptUserRequest")
public class AcceptUserRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Addevent ad=new Addevent();
	BLManager bl=new BLManager();
	Booking book=new Booking();
    Registration reg=new Registration();
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		String bid=request.getParameter("bid");
		int id=Integer.parseInt(bid);
		
		book=bl.serchbookid(id);
		
		String email=book.getRegistration().getEmail();
		
		String info1="Your Booking is Confirm..";
		
		ServletContext context = getServletContext();
		String host = context.getInitParameter("host");
		String port = context.getInitParameter("port");
		String user = context.getInitParameter("user");
		String pass = context.getInitParameter("pass");
		System.out.println(host + "   " + port + "    " + user + "   " + pass + "   " + email + "    " + info1);

		try {
			Emailutil.sendEmail1(host, port, user, pass, email, info1);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Request Accept successfully...');");
		out.println("location='viewUserRequest.jsp"+ "';");
		out.println("</script>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
