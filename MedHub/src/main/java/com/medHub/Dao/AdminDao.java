package com.medHub.Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.medHub.connection.GetConnection;
import com.medHub.module.AdminModule;
import com.medHub.module.UserModule;

public class AdminDao {
	

	public AdminModule login(String email, String password) throws SQLException
	{
		AdminModule adminmodule=null;
		String check="select * from admin where admin_email='"+email+"' and admin_password='"+password+"'";

		GetConnection conn= new GetConnection();
		Connection con=conn.getDBconnect();	
		Statement stm=con.createStatement();	
		ResultSet rs = stm.executeQuery(check);
	
		if(rs.next()) {
			adminmodule=new AdminModule(rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getLong(6));
			System.out.println(rs.getString(2));
			return adminmodule;
		}
		return adminmodule;
		
		}
	
	
}
