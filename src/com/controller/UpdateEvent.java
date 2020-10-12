package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.model.BLManager;
import com.pojo.Addevent;
import com.pojo.Registration;

/**
 * Servlet implementation class UpdateEvent
 */
@WebServlet("/UpdateEvent")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 100, // 10MB
maxRequestSize = 1024 * 1024 * 500)
public class UpdateEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String SAV_DIR = "D://MyProject/EventManagement/WebContent/eventimage";
       
	BLManager bl=new BLManager();
	Addevent ad=new Addevent();
	Registration reg=new Registration();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String eid=request.getParameter("eid");
		int id=Integer.parseInt(eid);
		
		ad=bl.serachbyeventid(id);
		
		HttpSession session=request.getSession();
		session.setAttribute("event",ad);
		
		response.sendRedirect("updateEvent.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        PrintWriter out = response.getWriter();
		
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("email");

		String etype = request.getParameter("etype");
		String ename = request.getParameter("ename");
		String cost = request.getParameter("cost");
		String facility = request.getParameter("facility");
		double d=Double.valueOf(cost);
		
		Part img = request.getPart("eimage");

		try 
		{
			String Image1 = extractFileName(img);
			ad.setEventimage(Image1);
			img.write(SAV_DIR + File.separator + Image1);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		reg=bl.searchByEmailId(email);
		
		ad.setRegistration(reg);
		ad.setEventtype(etype);
		ad.setEventname(ename);
		ad.setCost(d);
		ad.setFacility(facility);
		
		bl.updateevent(ad);
		
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Event Update Successfully..');");
		out.println("location='viewEvent.jsp';");
		out.println("</script>");
	}
	private String extractFileName(Part img)
	{
		String contentDisp = img.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

}
