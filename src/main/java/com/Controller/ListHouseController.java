package com.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.HouseBean;

import Dao.HouseDao;


public class ListHouseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HouseDao houseDao = new HouseDao();
	ArrayList<HouseBean> houses = houseDao.listhouse();
	request.setAttribute("houses", houses);
	request.getRequestDispatcher("AddInstructionSecurity.jsp").forward(request, response);
	}


}
