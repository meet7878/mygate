package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.UserBean;

import util.DbConnection;

public class UserDao {

	public void insertUser(UserBean userBean) {
		 
		 try {
		 Connection con = DbConnection.getConnection();
		 PreparedStatement pstmt = con.prepareStatement("insert into users (firstname,lastname,email,contactnum,password,gender,role,status)values(?,?,?,?,?,?,?,?)");

		 pstmt.setString(1, userBean.getFirstname());
	     pstmt.setString(2, userBean.getLastname());
	     pstmt.setString(3, userBean.getEmail());
		 pstmt.setLong(4, userBean.getContactnum());
	     pstmt.setString(5, userBean.getPassword());
		 pstmt.setString(6, userBean.getGender());
		 pstmt.setString(7, userBean.getRole());
		pstmt.setString(8, userBean.getStatus());		 
		 int records = pstmt.executeUpdate();


		 System.out.println(records+" inserted..."); 
		 
		 }catch(Exception e) {
			 System.out.println("some thing wrong in insert user()");
		      e.printStackTrace();
		 }
		 
		 
}

	public UserBean login(String email, String password) {
		  UserBean user = null;
		
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users where email = ? and password = ? ");
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
		 
			if(rs.next()) {
				user = new UserBean();
		      	  user.setUserid(rs.getInt("userid"));
		      	  user.setRole(rs.getString("role"));
		      	  user.setStatus(rs.getString("status"));
			}
		}
			catch (Exception e) {
				System.out.println("smw in login dao");
			}
		
			return user;
			
		}
	
	
	//List All Data
	 public ArrayList<UserBean>  getAllUsers() {
		   ArrayList<UserBean> users = new ArrayList<UserBean>();
		   try {
			   Connection con = DbConnection.getConnection();
			   PreparedStatement pstmt = con.prepareStatement("select * from users");
			  ResultSet rs =  pstmt.executeQuery();//show all data on db
			   
			  while(rs.next() == true)//1st row 2nd row
			  {
			 int userId = rs.getInt("userid");//db column name
			  String firstName = rs.getString("firstname");
			  String lastName = rs.getString("lastname");
			  String email = rs.getString("email");
			  long contact = rs.getLong("contactnum");
			  String gender = rs.getString("gender");
			  String status = rs.getString("status");
			  System.out.println(status+"vinit");
			  
			  UserBean user = new UserBean();
			  user.setUserid(userId);
			  user.setFirstname(firstName);
			  user.setLastname(lastName);
			  user.setEmail(email);
			  user.setContactnum(contact);;
			  user.setGender(gender);
			  user.setStatus(status);
			  System.out.println(status);
			  users.add(user);
			  
		   }
			  
			   
		} catch (Exception e) {
			System.out.println("smw in user Dao:getAllUser()");
			e.printStackTrace();
		}
		   return users;
		   
	   }
	 
	 
	 public boolean enableUser(int userId) {
			boolean flag=false;
			try(Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("update users set status=? where userid=?");){
				pstmt.setString(1, "enable");
				pstmt.setInt(2, userId);
				
				int updateStatus = pstmt.executeUpdate();
				if(updateStatus==1)
				{
					flag=true;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
	
	
}
