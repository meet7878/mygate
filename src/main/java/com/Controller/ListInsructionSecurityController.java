package com.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.InstructionBean;

import Dao.InstructionDao;


public class ListInsructionSecurityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InstructionDao instructiondao = new InstructionDao();
		ArrayList<InstructionBean> instruction = instructiondao.getAllInstructionSecurity();
		request.setAttribute("instructions", instruction);
		
		 request.getRequestDispatcher("ListInstructionSecurity.jsp").forward(request, response);
	}

	
}
