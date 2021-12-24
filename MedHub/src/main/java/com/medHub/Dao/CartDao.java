package com.medHub.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.medHub.connection.GetConnection;
import com.medHub.model.CartModel;
import com.medHub.model.ProductModel;
import com.medHub.model.UserModel;

public class CartDao {



	public void insertProduct(CartModel cart) {
		// TODO Auto-generated method stub
		
		Connection con = GetConnection.getDBconnect();
		try {
		String insertProduct ="insert into cart (product_id,user_id,unit_price,qty,total_price) values (?,?,?,?,?)"; 
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
			System.out.println("Something Went Wrong");
		}
		
		
		
	}
//	public List<ProductModel> viewProduts()
//	{
//		String viewQuery="select * from products";
//		Connection con=GetConnection.getDBconnect();
//		List<ProductModel> productList=new ArrayList<ProductModel>();
//		try {
//			Statement smt = con.createStatement();
//			ResultSet rs= smt.executeQuery(viewQuery);
//			
//			while(rs.next()) {
//				ProductModel product=new ProductModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),
//						rs.getInt(6),rs.getString(7));
//				productList.add(product);				
//				}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
//		
//		return productList;
//	}

	public List<CartModel> viewCart(UserModel currentUser) {
		currentUser.getUserId();
		String query= "select * from cart where user_id='"+currentUser.getUserId()+"'";
		Connection con=GetConnection.getDBconnect();
		List<CartModel> allCartItems=new ArrayList<CartModel>();
		Statement smt = null;
		ResultSet rs= null;
		try {
			smt = con.createStatement();
			rs=smt.executeQuery(query);
			ProductDao proDao=new ProductDao();
			while(rs.next()) {
				
				ProductModel product=proDao.findProductByProductId(rs.getInt(2));
				CartModel cart=new CartModel(product,currentUser,rs.getInt(4),rs.getDouble(5),rs.getDouble(6));
				allCartItems.add(cart);				
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		return allCartItems;
	}
	
}
