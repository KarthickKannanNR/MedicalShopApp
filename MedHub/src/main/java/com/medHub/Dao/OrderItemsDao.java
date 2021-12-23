package com.medHub.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.medHub.connection.GetConnection;
import com.medHub.model.OrderItemsModel;
import com.medHub.model.OrderModel;
import com.medHub.model.ProductModel;
import com.medHub.model.UserModel;

public class OrderItemsDao {
//	currentUser,buyProducts,buyProductQuantity, totalPrice
	public  void  insertOrders(OrderItemsModel oi) {
		// TODO Auto-generated method stub
		System.out.println("method called");
		String orderQuery="insert into order_items (user_id,order_id,product_id,quantity,unit_price,total_price) values(?,?,?,?,?,?)";
		Connection con = GetConnection.getDBconnect();

		try {
			PreparedStatement pst = con.prepareStatement(orderQuery);
			pst.setInt(1, oi.getUser().getUserId());
			pst.setInt(2, oi.getOrderModel().getOrderId());
			pst.setInt(3, oi.getProduct().getProductId());
			pst.setInt(4, oi.getQuantity());
			pst.setDouble(5, oi.getUnitPrice());
			pst.setDouble(6, oi.getTotalPrice());
			System.out.println(pst.executeUpdate()+" rows updated");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	

	}
}


