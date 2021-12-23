package com.medHub.model;

import java.util.Objects;

public class CartModel{
	private ProductModel product;
	private UserModel user;   
	private double unitPrice;
	private double totalPrice;
	private int qty;
	
	
	@Override
	public String toString() {
		return "product= " + product + "user= " + user + "unitPrice= " + unitPrice + "totalPrice= "
				+ totalPrice + "qty= " + qty;
	}

	public CartModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public CartModel(ProductModel product, UserModel user, int qty,double unitPrice,double totalPrice) {
		super();
		this.product = product;
		this.user = user;
		this.unitPrice = unitPrice;
		this.qty = qty;
		this.totalPrice=totalPrice;
	}
	public ProductModel getProduct() {
		return product;
	}
	public void setProduct(ProductModel product) {
		this.product = product;
	}
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}

	


	

}
