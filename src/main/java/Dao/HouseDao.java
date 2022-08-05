package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.HouseBean;
import com.bean.UserBean;

import util.DbConnection;

public class HouseDao {

	public void inserthouse(HouseBean housebean) {
		
		try {
			 Connection con = DbConnection.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("insert into houses (ownername,housedetail,housenumber,block,floor,userid)values(?,?,?,?,?,?)");
             pstmt.setString(1,housebean.getOwnername());
             pstmt.setString(2,housebean.getHousedetail());
             pstmt.setInt(3,housebean.getHousenumber());
             pstmt.setString(4,housebean.getBlock());
             pstmt.setInt(5, housebean.getFloor());
             pstmt.setInt(6, housebean.getUserid());
             int records = pstmt.executeUpdate();
	
		
		 System.out.println(records+" inserted..."); 
		 
	 }catch(Exception e) {
		 System.out.println("some thing wrong in insert houses()");
	      e.printStackTrace();
	 }
	 
	 
}

	public ArrayList<HouseBean> listhouse() {
		 ArrayList<HouseBean> houses = new ArrayList<HouseBean>();
		   try {
			   Connection con = DbConnection.getConnection();
			   PreparedStatement pstmt = con.prepareStatement("select * from houses");
			  ResultSet rs =  pstmt.executeQuery();//show all data on db
			   
			  while(rs.next() == true)//1st row 2nd row
			  {
			 int houseid = rs.getInt("houseid");//db column name
			  String ownername = rs.getString("ownername");
			  String housedetail = rs.getString("housedetail");
			   int housenumber = rs.getInt("housenumber");
			  String block = rs.getString("block");
			  int floor = rs.getInt("floor");
			   int userid = rs.getInt("userid");
			  
			  HouseBean house = new HouseBean();
			  house.setHouseid(houseid);;
			  house.setOwnername(ownername);
			 house.setHousedetail(housedetail);
			 house.setHousenumber(housenumber);
			 house.setBlock(block);
			 house.setFloor(floor);
			 houses.add(house);
			  
		   }
			  
			   
		} catch (Exception e) {
			System.out.println("smw in listhouse()");
			e.printStackTrace();
		}
		   return houses;
	}

	
}
