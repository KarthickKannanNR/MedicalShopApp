package com.medHub.Dao;

import java.beans.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.medHub.connection.GetConnection;
import com.medHub.module.AdminModule;
import com.medHub.module.UserModule;

public class UserDao {
	
public void insert(UserModule user) throws Exception {
		
		String ins="insert into users (full_name,age,user_mobile,user_password,user_email) values(?,?,?,?,?)";
		String commit="commit";
		Connection con=GetConnection.getDBconnect();
		PreparedStatement pst=con.prepareStatement(ins);
		pst.setString(1, user.getName());
		//System.out.println(user.getName());
		pst.setInt(2, user.getAge());
		pst.setLong(3,user.getUserMobile());
		pst.setString(4,user.getUserPassword());
		pst.setString(5, user.getUserMail());
		int res=pst.executeUpdate();	
		PreparedStatement smt= con.prepareStatement(commit);
		System.out.println( "SUCESSFULLY REGISTERED");
		pst.close();
		con.close();
	}
	

public UserModule login(String email,String password) throws SQLException
{
	String check="select * from users where user_email='"+email+"' and user_password='"+password+"'";
	System.out.println(check);
	GetConnection conn= new GetConnection();
	Connection con=conn.getDBconnect();
	PreparedStatement ps=con.prepareStatement(check);
	
	ResultSet rs=ps.executeQuery(check);
	UserModule user=null;
	if(rs.next())
	{
	user=new UserModule(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7),
			rs.getInt(8),rs.getLong(9));
	}
	return user;
	
	}

	
	
	
	
	
//	public void update (UserModule userModule) throws ClassNotFoundException, SQLException {
//		
//		 
//		
//		 String update = null;
//		try {
//			update = "update users set full_name=?,getAddress=?,user_mobile=?,user_password=? where user_email='"+userModule.getUserMail()+"'";
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		Connection con=GetConnection.getDBconnect();
//		PreparedStatement pst=con.prepareStatement(update);
//		
//		pst.setString(2, userModule.getName());
//		pst.setString(3, userModule.getAddress());
//		pst.setString(4,userModule.getUserPassword());
//		
//				
//		int res=pst.executeUpdate();
//		System.out.println(res + "is updated");
//		pst.close();
//		con.close();
//		
//	}
}
	



