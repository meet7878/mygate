package com.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;

import Dao.UserDao;


public class LoginController extends HttpServlet {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
			throws ServletException, IOException {
		 String email = request.getParameter("email");
			String password = request.getParameter("password");
			System.out.println(email+password);
			UserDao userDao = new UserDao();
			UserBean user = userDao.login(email, password);
			System.out.println(user);
			

			RequestDispatcher rd = null;
			
			if(user == null) {
				request.setAttribute("errormsg", "Invalid credentials:");
				rd = request.getRequestDispatcher("Login.jsp");
				
			}
			else if(user.getStatus().equalsIgnoreCase("disable")) {
				request.setAttribute("errorMsg1", "Please Talk With chairman Account is Disable");
				rd = request.getRequestDispatcher("Login.jsp");
			}
			else  {
				HttpSession session = request.getSession();
				session.setAttribute("userId", user.getUserid());
				
				System.out.println(user.getRole());
				if(user.getRole().equals("member")){
					rd = request.getRequestDispatcher("Addmember.jsp");
					
				}
				else if(user.getRole().equals("admin")){
					System.out.println(user.getRole());
					rd = request.getRequestDispatcher("AdminListUserController");
				}
				
				else if(user.getRole().equals("security")){
					System.out.println(user.getRole());
					rd = request.getRequestDispatcher("ListInsructionSecurityController");
				}

				else {
					rd = request.getRequestDispatcher("404.jsp");
				}
		}
			rd.forward(request, response);
		
			
	}
	}
	
	
	