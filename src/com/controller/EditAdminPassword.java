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

/**
 * Servlet implementation class EditAdminPassword
 */
@WebServlet("/EditAdminPassword")
public class EditAdminPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Registration reg=new Registration();
	BLManager bl=new BLManager();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        PrintWriter out = response.getWriter();
		
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("email");

		String oldPass = request.getParameter("oldPass");
		String newPass = request.getParameter("newPass");
		String confrmPass = request.getParameter("confrmPass");
		
		boolean val = bl.ValidPassword(oldPass, email);
		
		if (val == true) 
		{
			boolean newVal = valNewConfrm(newPass, confrmPass);
			
			if (newVal == true) 
			{

				Registration rg = bl.searchByEmailId(email);
				reg.setRid(rg.getRid());
				reg.setFname(rg.getFname());
				reg.setLname(rg.getLname());
				reg.setEmail(rg.getEmail());
				reg.setPassword(newPass);
				reg.setRegdate(rg.getRegdate());
				reg.setRole(rg.getRole());
				
				bl.updateRegistration(reg);

				out.println("<script type=\"text/javascript\">");
				out.println("alert('Password change successfully!');");
				out.println("location='AdminDashboard.jsp';");
				out.println("</script>");
			}else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Sorry!! New and Confirm Password Mismatch');");
				out.println("location='changeAdminPassword.jsp';");
				out.println("</script>");

			}
			
		}else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Sorry!! old password incorrect');");
			out.println("location='changeAdminPassword.jsp';");
			out.println("</script>");
		}

}
	private boolean valNewConfrm(String newPass, String confrmPass) 
	{
		if (newPass.equals(confrmPass)) {
			return true;
		} else {
			return false;
		}
	}
}
