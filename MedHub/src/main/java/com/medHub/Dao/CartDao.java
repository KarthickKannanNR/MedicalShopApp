package com.medHub.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.medHub.connection.GetConnection;
import com.medHub.model.CartModel;

public class CartDao {



	public void insertProduct(CartModel cart) {
		// TODO Auto-generated method stub
		
		System.out.println(1);
		Connection con = GetConnection.getDBconnect();
		System.out.println(2);
		try {
			System.out.println(3);
		String insertProduct ="insert into cart (product_id,user_id,unit_price,qty,total_price) values (?,?,?,?,?)"; 
		System.out.println(4);
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(insertProduct);
			pst.setInt(1,cart.getProduct().getProductId());
			pst.setInt(2, cart.getUser().getUserId());
			pst.setDouble(3, cart.getUnitPrice());
			pst.setInt(4, cart.getQty());
			pst.setDouble(5, cart.getTotalPrice());
			int result=pst.executeUpdate();
			System.out.println(result + " products added to cart");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		catch(Exception e)
		{
			e.getMessage();
			System.out.println("Syntax error");
		}
		
		
		
	}
	
}
