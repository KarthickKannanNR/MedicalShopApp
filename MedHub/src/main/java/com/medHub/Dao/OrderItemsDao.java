package com.medHub.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.medHub.connection.GetConnection;
import com.medHub.model.ProductModel;
import com.medHub.model.UserModel;

public class OrderItemsDao {
//	currentUser,buyProducts,buyProductQuantity, totalPrice
	public  void  insertOrders(UserModel currentUser,ProductModel buyProducts,int buyProductQuantity,double totalPrice ) {
		// TODO Auto-generated method stub
		String orderQuery="insert into order_items alues(user_id,product_id,product_name,quantity,unit_price,total_price) values(?,?,?,?,?,?)";
		Connection con = GetConnection.getDBconnect();

		try {
			PreparedStatement pst = con.prepareStatement(orderQuery);
			pst.setInt(1, currentUser.getUserId());
			pst.setInt(2, buyProducts.getProductId());
			pst.setString(3, buyProducts.getProductName());
			pst.setInt(4, buyProductQuantity);
			pst.setDouble(5, buyProducts.getUnitPrice());
			pst.setDouble(6, totalPrice);
			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	

	}
}


