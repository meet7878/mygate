/*package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.UserMemberBean;

import util.DbConnection;

public class MemberDao {

	public void Addmember(UserMemberBean memberbean) {
		try 
			( Connection con = DbConnection.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("insert into member(gender,age,contactnum,userid,name) values(?,?,?,?,?)");){
			 System.out.println(memberbean.getAge());
            
            pstmt.setString(1,memberbean.getGender());
            pstmt.setInt(2,memberbean.getAge());
            pstmt.setInt(3,memberbean.getContactnumber());
            pstmt.setInt(4, memberbean.getUserid());
            pstmt.setString(5,memberbean.getName());
            int records = pstmt.executeUpdate();
            System.out.println(records);
	
		
		 System.out.println(records+" inserted in member..."); 
		 
	 }catch(Exception e) {
		 System.out.println("some thing wrong in insert member dao()");
	      e.printStackTrace();
	 }
		
	}

	
}




*/


package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.UserMemberBean;


import util.DbConnection;

public class MemberDao {

	public void Addmember(UserMemberBean memberbean) {
		try(Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into members (firstname,contact_number,age,gender,userid) values (?,?,?,?,?)");) {
			pstmt.setString(1, memberbean.getFirstname());
			pstmt.setInt(2, memberbean.getContact_number());
			pstmt.setInt(3, memberbean.getAge());
			pstmt.setString(4, memberbean.getGender());
			pstmt.setInt(5, memberbean.getUserid());
			//pstmt.setInt(6, memberbean.getHouseid());
			int records = pstmt.executeUpdate();
			System.out.println(records + "Data insterted");
		} catch (Exception e) {
			System.out.println("SWR in insertHouse()");
			e.printStackTrace();
		}		
	}
	
	
	
}