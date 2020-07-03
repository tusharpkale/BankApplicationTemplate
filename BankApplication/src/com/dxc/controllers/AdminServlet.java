package com.dxc.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.services.AdminServiceImpl;


@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	
	String errorMessage="";
	AdminServiceImpl adminService=new AdminServiceImpl();
	
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			boolean authenticated=false;
			HttpSession session=request.getSession();
			String admin=request.getParameter("admin");
			String pass=request.getParameter("pass");
			authenticated=adminService.authenticateAdmin(admin,pass);
			if(authenticated==true)
				response.sendRedirect("adminmenu.jsp");
			else
			{
				errorMessage="Invalid login!";
				session.setAttribute("errorMessage", errorMessage);
				response.sendRedirect("error.jsp");
			}
	}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {	
    	   String action="";
    	   String temp=request.getParameter("adminbtn");
    	   if(temp!=null)
    		   action=temp;
    	   		
    	   if(action.equals("add_customer"))
    		   response.getWriter().println("call add_customer method from admin service here...");
    	   else if(action.equals("get_cust_bal"))
    		   response.getWriter().println("call get_cust_bal method from admin service here...");
    	   else if(action.equals("remove_customer"))
    		   response.getWriter().println("call remove_customer method from admin service here...");
    	   else if(action.equals("update_customer"))
    		   response.getWriter().println("call update_customer method from admin service here...");
    	   else if(action.equals("show_customer"))
    		   response.getWriter().println("call show_customer method from admin service here...");
    	   else 
    		   response.getWriter().println("call show_all_customers method from admin service here...");
    }
}
