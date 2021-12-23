package com.medHub.Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.medHub.connection.GetConnection;
import com.medHub.model.ProductModel;
import com.medHub.model.UserModel;
public class UserDao {
	
	
public void insert(UserModel user) throws Exception {
		
	try {
		String ins="insert into users (full_name,age,user_mobile,user_password,user_email) values(?,?,?,?,?)";
		String commit="commit";
		Connection con=GetConnection.getDBconnect();
		PreparedStatement pst=con.prepareStatement(ins);
		pst.setString(1, user.getName());
		pst.setInt(2, user.getAge());
		pst.setLong(3,user.getUserMobile());
		pst.setString(4,user.getUserPassword());
		pst.setString(5, user.getUserMail());
		int res=pst.executeUpdate();	
		PreparedStatement smt= con.prepareStatement(commit);
		smt.execute();
		pst.close();
		con.close();
		System.out.println( "SUCESSFULLY REGISTERED");}
	catch(Exception e)
	{
		e.getMessage();
		System.out.println("This Users Already Exists");
	}
		
	}
	

public UserModel login(String email,String password) throws SQLException
{
	String check="select * from users where user_email='"+email+"' and user_password='"+password+"'";
	GetConnection conn= new GetConnection();
	Connection con=conn.getDBconnect();
	PreparedStatement ps=con.prepareStatement(check);
	ResultSet rs=ps.executeQuery(check);
	UserModel user=null;
	try {
	if(rs.next())
	{
	user=new UserModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7),
			rs.getInt(8),rs.getLong(9));
	return user;
	}
	
		}
	catch(Exception e)
	{
		e.getMessage();
	}
	
	return null;
	}

	
public List<UserModel> ViewAllUser() throws SQLException
{
	String viewUsers= "select * from users";
	Connection conn=GetConnection.getDBconnect();
	List<UserModel> userList = new ArrayList<UserModel>();
	Statement stm = conn.createStatement();
	ResultSet rs= stm.executeQuery(viewUsers);
	
	
	 try {
		rs= stm.executeQuery(viewUsers);
		while(rs.next())
		{
			UserModel allUsers= new UserModel(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getLong(9));
			userList.add(allUsers);
			System.out.println(rs.getString(1));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 stm.close();
	 conn.close();
	 rs.close();
	return userList;
	
}
	
	
	public int update (UserModel currentUser) throws ClassNotFoundException, SQLException {
		System.out.println(currentUser);
		String update = null;
		try {
			update = "update users set full_name=?,user_password=?,user_mobile=? where user_email='"+currentUser.getUserMail()+"'";
			Connection con=GetConnection.getDBconnect();
			PreparedStatement pst=con.prepareStatement(update);
			pst.setString(1, currentUser.getName());
			pst.setString(2, currentUser.getUserPassword());
			pst.setLong(3,currentUser.getUserMobile());
			System.out.println(currentUser.getUserMail());
			System.out.println(currentUser.getUserMobile());
			int res=pst.executeUpdate();
			System.out.println(res + "is updated");
			pst=con.prepareStatement("commit");
			res=pst.executeUpdate();
			pst.close();
			con.close();
			return res;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(update);
				
	 return 0;
	}
	
	public UserModel getUserById(int userId)
	{
		String getuserId="select * from users where user_id=?";
		Connection con=null;
		PreparedStatement pstatement = null;
		UserModel userModule = null;
		
		 con = GetConnection.getDBconnect();
		 try {
			pstatement = con.prepareStatement(getuserId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			pstatement.setInt(1, userModule.getUserId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			ResultSet rs = pstatement.executeQuery(getuserId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userModule;
		
	}
	
	
	public boolean deleteUser(int userId) throws SQLException
	{
		
		Connection con = null;
		PreparedStatement pst =null;
		int deleteStatus=0;
		con= GetConnection.getDBconnect();
		String delete="delete from users where user_id=?";
		 
		 
		
			pst=con.prepareStatement(delete);
			pst.setInt(1, userId);
			int result=pst.executeUpdate();
			if(result>0)
			{
				return true;
			}
			else 
				return false;
		}


//														ADD MONEY TO WALLET
	
		public void addMoneyInWallet(double walletAmount,UserModel currentUser) {
			
			System.out.println("addMoneyInWallet called");
			double addAmount=currentUser.getWallet()+walletAmount;
			String walletQuery="update users set user_wallet ="+addAmount+" where user_email ='"+currentUser.getUserMail()+"'";
			Connection con = GetConnection.getDBconnect();
			try {
				PreparedStatement ps = con.prepareStatement(walletQuery);
				ps.executeQuery();
				System.out.println("Money added to wallet");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
		
			}
	
	
	
}
	



