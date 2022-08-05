package com.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;

import Dao.UserDao;


public class SignupController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		long contactnum = Long.parseLong(request.getParameter("contactnum")); 
	
		
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(email);
		System.out.println(password);
		System.out.println(gender);
		System.out.println(contactnum);
		
		
		
			UserDao userDao= new UserDao();
			
			UserBean userBean = new UserBean(); 
			userBean.setFirstname(firstName);
			userBean.setLastname(lastName);
			userBean.setEmail(email);
			userBean.setPassword(password);
			userBean.setGender(gender);	
			userBean.setContactnum(contactnum);;
			userBean.setRole("member");
			userBean.setStatus("disable");
			System.out.println(userBean);
			
			userDao.insertUser(userBean);
		//	request.setAttribute("msg","signup done..");
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
	}

}
