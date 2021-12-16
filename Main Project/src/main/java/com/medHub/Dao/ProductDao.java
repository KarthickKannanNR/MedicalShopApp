package com.medHub.Dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.medHub.connection.GetConnection;
import com.medHub.module.ProductModule;

public class ProductDao {
	
	public List<ProductModule> viewProduts()
	{
		String viewQuery="select * from products";
		Connection con=GetConnection.getDBconnect();
		List<ProductModule> productList=new ArrayList<ProductModule>();
		try {
			Statement smt = con.createStatement();
			ResultSet rs= smt.executeQuery(viewQuery);
			
			while(rs.next()) {
				ProductModule product=new ProductModule(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),
						rs.getInt(6),rs.getString(7));
				productList.add(product);				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	
		return productList;
	
	}

}
