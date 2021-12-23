package com.medHub.model;

import java.sql.Date;
import java.util.Objects;

public class OrderModel {
	
	private UserModel user;
	private int orderId;
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public ProductModel getProduct() {
		return product;
	}
	public void setProduct(ProductModel product) {
		this.product = product;
	}
	private ProductModel product;
	private Date orderDate;
	private double price;
	private String orderStatus;
	private String orderType;

	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	@Override
	public int hashCode() {
		return Objects.hash(orderDate, orderStatus, orderType, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderModel other = (OrderModel) obj;
		return Objects.equals(orderDate, other.orderDate) 
				&& Objects.equals(orderStatus, other.orderStatus) && Objects.equals(orderType, other.orderType)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
	@Override
	public String toString() {
		return  ", orderDate=" + orderDate + ", price=" + price
				+ ", orderStatus=" + orderStatus + ", orderType=" + orderType + "]";
	}
	public OrderModel(Date orderDate, double price, String orderStatus, String orderType) {
		super();
		this.orderDate = orderDate;
		this.price = price;
		this.orderStatus = orderStatus;
		this.orderType = orderType;
	}
	
	public OrderModel(ProductModel buyProducts, UserModel currentUser,double totalPrice) {
			this.product=buyProducts;
			this.user=currentUser;
			this.price=totalPrice;
		}
	public OrderModel( UserModel currentUser,double totalPrice) {
		this.user=currentUser;
		this.price=totalPrice;
	}
	public OrderModel(Date orderDate, double price, String orderStatus) {
		super();
		this.orderDate = orderDate;
		this.price = price;
		this.orderStatus = orderStatus;
	}
	public OrderModel() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
}
