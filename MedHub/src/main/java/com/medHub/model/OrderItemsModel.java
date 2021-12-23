package com.medHub.model;

import java.util.Date;
import java.util.Objects;

import org.apache.catalina.User;

public class OrderItemsModel {

	private int itemId;
	private User user;
	private ProductModel product;
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
	public OrderItemsModel(int itemId, User user, ProductModel product, Date orderDate, int quantity, double unitPrice,
			double totalPrice) {
		super();
		this.itemId = itemId;
		this.user = user;
		this.product = product;
		this.orderDate = orderDate;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "OrderItemsModel [itemId=" + itemId + ", user=" + user + ", product=" + product + ", orderDate="
				+ orderDate + ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", totalPrice=" + totalPrice
				+ "]";
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
