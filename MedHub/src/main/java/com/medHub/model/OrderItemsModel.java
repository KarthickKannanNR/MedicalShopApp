package com.medHub.model;

import java.util.Date;
import java.util.Objects;

import org.apache.catalina.User;

public class OrderItemsModel {

	private int itemId;
	private UserModel user;
	private ProductModel product;
	private OrderModel orderModel;
	private Date orderDate;
	private int quantity;
	private double unitPrice;
	private double totalPrice;
	public int getItemId() {
		return itemId;
	}
	public OrderItemsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public OrderItemsModel( UserModel user, OrderModel orderModel,ProductModel product,int quantity, double unitPrice,
			double totalPrice) {
		super();
		this.user = user;
		this.product = product;
		this.orderModel=orderModel;	
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
	}
	

	
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	public OrderModel getOrderModel() {
		return orderModel;
	}
	public void setOrderModel(OrderModel orderModel) {
		this.orderModel = orderModel;
	}
	@Override
	public String toString() {
		return "OrderItemsModel itemId= " + itemId + "\nuser= " + user + "\nproduct= " + product + "\norderDate="
				+ orderDate + "\nquantity= " + quantity + "\nunitPrice=" + unitPrice + "\ntotalPrice=" + totalPrice;
	}
	public ProductModel getProduct() {
		return product;
	}
	public void setProduct(ProductModel product) {
		this.product = product;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
}
