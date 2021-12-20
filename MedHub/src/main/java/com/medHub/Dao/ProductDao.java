package com.medHub.Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public void insertProduct(ProductModule productModule) throws SQLException
	{
	
		String query="insert into products (product_category,product_name,description,unit_price,quantity,product_id) values (?,?,?,?,?,?)";
		Connection con=GetConnection.getDBconnect();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, productModule.getProductCategory());
		pst.setString(2, productModule.getProductName());
		pst.setString(3, productModule.getDescription());
		pst.setInt(4, productModule.getUnitPrice());
		pst.setInt(5, productModule.getQuantity());
		pst.setInt(6, productModule.getProductId());
		int result=pst.executeUpdate();
		System.out.println(result + " product inserted");
	}


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
		pst.setInt(4, updateUnitPrice);
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
	
	
}
