package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.Addevent;
import com.pojo.Booking;
import com.pojo.Registration;

@WebServlet("/BookNowServlet")
public class BookNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Addevent ad=new Addevent();
	BLManager bl=new BLManager();
	Booking book=new Booking();
    Registration reg=new Registration();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
        PrintWriter out = response.getWriter();

        String bdate = request.getParameter("bdate");
		String btime = request.getParameter("btime");
		
		Date d=Date.valueOf(bdate);
		
		HttpSession session=request.getSession();
		String eid=(String)session.getAttribute("eid");
	    String email=(String)session.getAttribute("email");
	    
	    int id=Integer.parseInt(eid);
	    
	    ad=bl.serachbyeventid1(id);
	    
	    reg=bl.searchByEmailId(email);
	    
	    book.setRegistration(reg);
	    book.setAddevent(ad);
	    book.setBookingdate(d);
	    book.setBookingtime(btime);
	    
	    bl.bookingconfirm(book);
	    
	    out.println("<script type=\"text/javascript\">");
		out.println("alert('Booking Confrm Successfully..');");
		out.println("location='UserHeader.jsp';");
		out.println("</script>");
	}

}
