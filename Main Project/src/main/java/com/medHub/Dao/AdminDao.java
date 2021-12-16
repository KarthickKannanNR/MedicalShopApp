package com.medHub.Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.medHub.connection.GetConnection;
import com.medHub.module.AdminModule;

public class AdminDao {
	

	public AdminModule login(String email, String password) throws SQLException
	{
		String check="select * from admins where admin_email='"+email+"' and admin_password='"+password+"'";
		String commit="commit";

		GetConnection conn= new GetConnection();
		Connection con=conn.getDBconnect();		
		Statement stm=con.createStatement();
		
		ResultSet rscommit=stm.executeQuery(commit);
		ResultSet rs = stm.executeQuery(check);
		
		rs.next();
			AdminModule adminmodule=new AdminModule(rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getLong(6));
		return adminmodule;
		
		}
	
}
