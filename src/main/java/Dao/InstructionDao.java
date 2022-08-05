package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.InstructionBean;


import util.DbConnection;

public class InstructionDao {

	//addinstruction controller
	public void AddInstruction(InstructionBean instruction1) {
		
			try(Connection con = DbConnection.getConnection();
					PreparedStatement pstmt = con.prepareStatement("insert into instructions (name,allow,type,description,userid,houseid) values (?,?,?,?,?,?)");) {
				pstmt.setString(1, instruction1.getName());
				pstmt.setString(2, instruction1.getAllow());
				pstmt.setString(3, instruction1.getType());
				pstmt.setString(4, instruction1.getDescription());
				pstmt.setInt(5, instruction1.getUserid());
				pstmt.setInt(6, instruction1.getHouseid());
				
				int records = pstmt.executeUpdate();
				System.out.println(records + "Data insterted");
			} catch (Exception e) {
				System.out.println("SWR in insert in instructiondao()");
				e.printStackTrace();
			}		
		}
	
	//Listinstructioncontroller
	public ArrayList<InstructionBean> getAllInstruction(int userid){
		ArrayList<InstructionBean> instructions = new ArrayList<InstructionBean>();
	  try {
		  Connection con = DbConnection.getConnection();
		  PreparedStatement pstmt = con.prepareStatement("select * from instructions where userid=? ");
		  pstmt.setInt(1,userid);
		  ResultSet rs = pstmt.executeQuery();
		  
		  while(rs.next() == true) {
			 int inst = rs.getInt("instructionid");
			  int userId = rs.getInt("userid");
			  String name = rs.getString("name");
			  String allow = rs.getString("allow");
			  String type = rs.getString("type");
			  String description = rs.getString("description");
			  
			  
			  InstructionBean instruction = new InstructionBean();
			  instruction.setInstructionid(inst);
			  instruction.setUserid(userId);
			  instruction.setName(name);
			  instruction.setAllow(allow);
			  instruction.setType(type);
			  instruction.setDescription(description);
			  instructions.add(instruction);
		  }
		  
	  }
	  catch (Exception e) {
			System.out.println("smw in user Dao:getAllUser()");
			e.printStackTrace();
		}
		   return instructions;
	
	
	}
	
	
	//ListInstructionsecuritycontroller
	public ArrayList<InstructionBean> getAllInstructionSecurity(){
		ArrayList<InstructionBean> instructions = new ArrayList<InstructionBean>();
	  try {
		  Connection con = DbConnection.getConnection();
		  PreparedStatement ptsmt = con.prepareStatement("select * from instructions i,houses h where i.houseid=h.houseid");
			//ptsmt.setInt(1, userid);
			ResultSet rs = ptsmt.executeQuery();
			
			while (rs.next()) {

				InstructionBean inst = new InstructionBean();
				System.out.println(rs.getString("name")+"12345678");
				inst.setInstructionid(rs.getInt("instructionid"));
				inst.setName(rs.getString("name"));
				inst.setDescription(rs.getString("description"));
				inst.setAllow( rs.getString("allow"));
				inst.setType(rs.getString("type")) ;
				/*
				 * if (rs.getString("status").equals("y")) { inst.setStatus("allow");
				 * 
				 * } else { inst.setStatus("Not allow"); }
				 */
				inst.setBlock(rs.getString("block"));
				inst.setHousenumber(rs.getInt("housenumber"));
				//inst.setType(rs.getString("type"));
				//inst.setExit_time(rs.getString("exit_time"));
			  instructions.add(inst);
		  }
		  
	  }
	  catch (Exception e) {
			System.out.println("smw in user Dao:getAllUsergetAllInstructionSecurity()");
			e.printStackTrace();
		}
		   return instructions;
	
	
	}
	
	
	
	

	//Deleteinstructioncontroller
	public boolean deleteTask(int instructionid) {
		boolean flag = false;
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from instructions where instructionid=?" );
		    pstmt.setInt(1, instructionid);
		    int deleteRows = pstmt.executeUpdate();
		    if(deleteRows==1) {
		    	flag = true;
		    }
		} 		
		    catch (Exception e) {
				e.printStackTrace();
			}
		  
		
		    return flag;
		 
	}
	
	//Security side
	
	
	public ArrayList<InstructionBean> listinstbyuserid(int userid) {

		ArrayList<InstructionBean> instruction = new ArrayList<InstructionBean>();
		// TODO Auto-generated method stub
		try (Connection con = DbConnection.getConnection();
				PreparedStatement ptsmt = con.prepareStatement(
						"select * from instructions i,houses h where i.houseid=h.houseid and h.userid=?");) {
			ptsmt.setInt(1, userid);
			ResultSet rs = ptsmt.executeQuery();
			
			while (rs.next()) {

				InstructionBean inst = new InstructionBean();
				System.out.println(rs.getString("name")+"12345678");
				inst.setInstructionid(rs.getInt("instructionid"));
				inst.setName(rs.getString("name"));
				inst.setDescription(rs.getString("description"));
				inst.setAllow( rs.getString("allow"));
				inst.setType(rs.getString("type")) ;
				/*
				 * if (rs.getString("status").equals("y")) { inst.setStatus("allow");
				 * 
				 * } else { inst.setStatus("Not allow"); }
				 */
				inst.setBlock(rs.getString("block"));
				inst.setHousenumber(rs.getInt("housenumber"));
				//inst.setType(rs.getString("type"));
				//inst.setExit_time(rs.getString("exit_time"));
				instruction.add(inst);

			}
		} catch (SQLException e) {
			System.out.println("smw in listinstbyuserid()");
			e.printStackTrace();
		}
		return instruction;

	}
	
	
	
}
	
		 
		
	
	
	


