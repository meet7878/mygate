package com.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;

import Dao.UserDao;


public class AdminListUserController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userdao = new UserDao();
		ArrayList<UserBean> user = userdao.getAllUsers();
		request.setAttribute("users", user);
		
		RequestDispatcher rd = request.getRequestDispatcher("ListUserAdmin.jsp");
        rd.forward(request, response);
		
	}


}
