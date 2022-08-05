package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.HouseBean;

import Dao.HouseDao;


public class AddHouseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	int userid = Integer.parseInt(request.getParameter("userid"));
	String owner_name	= request.getParameter("owner_name");
	String house_details	= request.getParameter("house_details");
	int house_number	= Integer.parseInt(request.getParameter("house_number")) ;
	String block	= request.getParameter("block");
	int floor	= Integer.parseInt(request.getParameter("floor")) ;
	
	HouseDao housedao = new HouseDao();
	HouseBean housebean = new HouseBean();
	housebean.setUserid(userid);
	housebean.setOwnername(owner_name);
	housebean.setHousedetail(house_details);
	housebean.setHousenumber(house_number);
	housebean.setBlock(block);
	housebean.setFloor(floor);
	housedao.inserthouse(housebean);
	response.sendRedirect("AdminListUserController");
	
	
	
	}

}
