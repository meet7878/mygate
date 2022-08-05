package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;


public class AproveController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int userid = Integer.parseInt(request.getParameter("userid"));
		System.out.println(userid+"meet");
		UserDao userDao = new UserDao();
		if(userDao.enableUser(userid)) {
			request.setAttribute("msg", "Aprroved");
			
		}
		else {
			request.setAttribute("msg", "something wrong in dao");
		}
		request.getRequestDispatcher("AdminListUserController").forward(request, response);
		
	}

	

}
