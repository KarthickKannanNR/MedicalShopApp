package com.medHub.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.medHub.connection.GetConnection;
import com.medHub.model.OrderModel;
import com.medHub.model.ProductModel;

public class OrderDao {
	

	public  void  orders(int userId ,double totalPrice) {
		// TODO Auto-generated method stub
		String orderQuery="insert into orders (user_id,price) values(?,?)";
		
		Connection con = GetConnection.getDBconnect();
		try {
			PreparedStatement pst = con.prepareStatement(orderQuery);
			System.out.println(totalPrice);

			pst.setInt(1,userId );
			pst.setDouble(2, totalPrice);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			}

	}
	
	public int  getByOrderId()
	{
		String qwery="select max(order_id) from orders";
		Connection con = GetConnection.getDBconnect();
		OrderModel order= null;
		int orderId=0;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(qwery);
			
			if(rs.next())
			{
			return orderId=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return orderId;
		
		
	}
	

}
