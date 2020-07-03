package com.dxc.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.services.AdminServiceImpl;
import com.dxc.services.UserServiceImpl;


@WebServlet("/user")
public class UserServlet extends HttpServlet {
     
			UserServiceImpl userService=new UserServiceImpl();
	  	
		    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
			{
		    		String errorMessage="";
					boolean authenticated=false;
					HttpSession session=request.getSession();
					String user=request.getParameter("user");
					String pass=request.getParameter("pass");
					authenticated=userService.authenticateUser(user,pass);
					if(authenticated==true)
						response.sendRedirect("usermenu.jsp");
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
		    	   String temp=request.getParameter("userbtn");
		    	   if(temp!=null)
		    		   action=temp;   		
		    	   if(action.equals("deposite"))
		    		   response.getWriter().println("call deposite method from user service here...");
		    	   else if(action.equals("transfer_amount"))
		    		   response.getWriter().println("call transfer_amount method from user service here...");
		    	   else if(action.equals("withdraw"))
		    		   response.getWriter().println("call withdraw method from user service here...");
		    	   else if(action.equals("check_balance"))
		    		   response.getWriter().println("call check_balance method from user service here...");
		    	   else if(action.equals("print_statement"))
		    		   response.getWriter().println("call print_mini_statement method from user service here...");
		    	   else if(action.equals("change_password"))
		    		   response.getWriter().println("call change_password method from user service here...");
		    }
}
