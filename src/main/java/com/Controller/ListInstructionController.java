package com.Controller;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.InstructionBean;

import Dao.InstructionDao;


public class ListInstructionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int userid = (Integer) session.getAttribute("userId");
		InstructionDao instructiondao = new InstructionDao();
		ArrayList<InstructionBean> instruction = instructiondao.listinstbyuserid(userid);
		request.setAttribute("instructions", instruction);
		System.out.println(instruction+"-----------------");
		
		 request.getRequestDispatcher("ListInstructin.jsp").forward(request, response);
		
	}

	
}
