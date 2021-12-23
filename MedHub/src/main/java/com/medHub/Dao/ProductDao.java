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

public class ProductDao {
	
	
//																		Show All Products
	public List<ProductModel> viewProduts()
	{
		String viewQuery="select * from products";
		Connection con=GetConnection.getDBconnect();
		List<ProductModel> productList=new ArrayList<ProductModel>();
		try {
			Statement smt = con.createStatement();
			ResultSet rs= smt.executeQuery(viewQuery);
			
			while(rs.next()) {
				ProductModel product=new ProductModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),
						rs.getInt(6),rs.getString(7));
				productList.add(product);				
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return productList;
	}
	
																		//Insert Product By Admin
	public void insertProduct(ProductModel productModel) throws SQLException
	{
	
		String query="insert into products (product_category,product_name,description,unit_price,quantity,product_id) values (?,?,?,?,?,?)";
		Connection con=GetConnection.getDBconnect();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, productModel.getProductCategory());
		pst.setString(2, productModel.getProductName());
		pst.setString(3, productModel.getDescription());
		pst.setDouble(4, productModel.getUnitPrice());
		pst.setInt(5, productModel.getQuantity());
		pst.setInt(6, productModel.getProductId());
		int result=pst.executeUpdate();
		System.out.println(result + " product inserted");
	}


//																				Update Products By ADmin
	public void updateProducts(int updateProductId, String updateproductcategory, String updateProductName, String updateProductDescription, int updateUnitPrice, int updateQuantity) throws SQLException {
		// TODO Auto-generated method stub
		String updateQwery="update products set product_category=?,product_name=?,description=?,unit_price=?,Quantity=? where product_id=?";
		Connection con = GetConnection.getDBconnect();
		PreparedStatement pst=null;
		try {
		 pst = con.prepareStatement(updateQwery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pst.setString(1, updateproductcategory);
		pst.setString(2, updateProductName);
		pst.setString(3, updateProductDescription);
		pst.setDouble(4, updateUnitPrice);
		pst.setInt(5, updateQuantity);
		pst.setInt(6, updateProductId);
		int result=pst.executeUpdate();
		if(result>0)
		{
			System.out.println(result+" product is updated");
		}
		else
		{
			System.out.println("product not update something went wrong");
		}
		con.close();
		pst.close();
		}
	
//																				Delete Product by admin
		public void deleteProduct(int productId) throws SQLException
		{
			String qwery="delete from products where product_id=?";
			Connection con = GetConnection.getDBconnect();
			PreparedStatement pst=con.prepareStatement(qwery);
			pst.setInt(1, productId);
			int res=pst.executeUpdate();
			if(res>0)
			{
				System.out.println(res+"Product deleted");
				
			}
			else {
				System.out.println("product not deleted");
			}
			con.close();
			pst.close();
			
		}
		
		
//		public int findProductId()
//		{
//			int productId=0;
//			String query="select id from products where product_name=?";
//			Connection con = GetConnection.getDBconnect();
//			try {
//				PreparedStatement pst= con.prepareStatement(query);
//				pst.setString(1,query);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			
//			return 0;
//			}
	
		
		
		
																//find Product By Name
		public ProductModel findProductByName(String productName)
		{
			int productId=0;
			String query="select * from products where product_name='"+productName+"'";
			Connection con = GetConnection.getDBconnect();
			ProductModel product=null;
			try {
				PreparedStatement pst= con.prepareStatement(query);
				System.out.println(6);
//				pst.setString(1,productName);
				ResultSet rs = pst.executeQuery();
				if(rs.next())
				{
				 product= new ProductModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6),rs.getString(7));
					}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return product;
			}
		
		public ProductModel findProductByProductId(int id)
		{
			int productId=0;
			String query="select * from products where product_id='"+id+"'";
			Connection con = GetConnection.getDBconnect();
			ProductModel product=null;
			try {
				PreparedStatement pst= con.prepareStatement(query);
				System.out.println(6);
//				pst.setString(1,productName);
				ResultSet rs = pst.executeQuery();
				if(rs.next())
				{
				 product= new ProductModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6),rs.getString(7));
					}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return product;
			}
	
}
