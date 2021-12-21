package com.medHub.model;

import java.sql.Date;
import java.util.Objects;

public class OrderModel {

	private int orderId;
	private int userId;
	private Date orderDate;
	private double price;
	private String orderStatus;
	private String orderType;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
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
		return Objects.hash(orderDate, orderId, orderStatus, orderType, price, userId);
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
		return Objects.equals(orderDate, other.orderDate) && orderId == other.orderId
				&& Objects.equals(orderStatus, other.orderStatus) && Objects.equals(orderType, other.orderType)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && userId == other.userId;
	}
	@Override
	public String toString() {
		return "OrderModel [orderId=" + orderId + ", userId=" + userId + ", orderDate=" + orderDate + ", price=" + price
				+ ", orderStatus=" + orderStatus + ", orderType=" + orderType + "]";
	}
	public OrderModel(int orderId, int userId, Date orderDate, double price, String orderStatus, String orderType) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.price = price;
		this.orderStatus = orderStatus;
		this.orderType = orderType;
	}
	public OrderModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
