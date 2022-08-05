/*package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserMemberBean;


import Dao.MemberDao;


public class AddMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userid = (Integer) session.getAttribute("userId");
		String name	= request.getParameter("name");
		String gender	= request.getParameter("gender");
		int age	= Integer.parseInt(request.getParameter("age")) ;
		int contactnumber	= Integer.parseInt(request.getParameter("contactnumber"));
		
		MemberDao memberdao = new MemberDao();
		UserMemberBean memberbean = new UserMemberBean();
		memberbean.setUserid(userid);
		memberbean.setName(name);
		memberbean.setGender(gender);
		memberbean.setAge(age);
		memberbean.setContactnumber(contactnumber); 
		memberdao.Addmember(memberbean);
	     request.getRequestDispatcher("Addmember.jsp").forward(request, response);;
		
		
		
		
		
	
	}

}
*/

package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserMemberBean;
import Dao.MemberDao;

public class AddMemberController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		HttpSession session = request.getSession();
		int userid = (Integer) session.getAttribute("userId");
		
		String firstname = request.getParameter("name");
		int contact_number = Integer.parseInt(request.getParameter("contactnumber"));
		int age = Integer.parseInt(request.getParameter("age")); 
		String gender = request.getParameter("gender");
		
		System.out.println(userid);
		MemberDao memberDao = new MemberDao();
		UserMemberBean member = new UserMemberBean();
		
		member.setFirstname(firstname);
		member.setContact_number(contact_number);
		member.setAge(age);
		member.setGender(gender);
		member.setUserid(userid);
		memberDao.Addmember(member);
		response.sendRedirect("Addmember.jsp");
	}
}
		


