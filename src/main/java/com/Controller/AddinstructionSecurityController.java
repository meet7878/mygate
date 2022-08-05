package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.InstructionBean;

import Dao.InstructionDao;


public class AddinstructionSecurityController extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			/*
			 * HttpSession session = request.getSession(); int userid = (Integer)
			 * session.getAttribute("userId");
			 */
			int houseid = Integer.parseInt( request.getParameter("block"));
			
			String name = request.getParameter("name");
			String per = request.getParameter("per");
			String type =request.getParameter("type");
			String description = request.getParameter("description");
			int  housenumber = Integer.parseInt(request.getParameter("housenumber"));
			
			InstructionDao instruction = new InstructionDao();
			InstructionBean instruction1 = new  InstructionBean();
			
			instruction1.setName(name);
			instruction1.setAllow(per);;
			instruction1.setType(type);
			instruction1.setDescription(description);
			//instruction1.setUserid(32);
			instruction1.setHouseid(houseid);
			
			instruction.AddInstruction(instruction1);
			response.sendRedirect("ListHouseController");
			
	}

}
