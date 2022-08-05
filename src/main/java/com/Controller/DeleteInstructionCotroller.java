package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.InstructionDao;


public class DeleteInstructionCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int userid = Integer.parseInt(request.getParameter("userid"));
		int instructionid = Integer.parseInt(request.getParameter("instructionid"));
		InstructionDao instruction = new InstructionDao();
		if(instruction.deleteTask(instructionid)) {
			request.setAttribute("msg", "Deleted Task Successfully");
		}
			else
			{
				request.setAttribute("msg", "Deleted Task Successfully");
			}
		 response.sendRedirect("ListInstructionController");	
		}
	   

	}


