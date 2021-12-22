package com.medHub.model;

import java.util.Objects;

public class OrderItemsModel {

	private int itemId;
	private int orderId;
	private int productId;
	private int quantity;
	private double unitPrice;
	private double totalPrice;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
	@Override
	public int hashCode() {
		return Objects.hash(itemId, orderId, productId, quantity, totalPrice, unitPrice);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemsModel other = (OrderItemsModel) obj;
		return itemId == other.itemId && orderId == other.orderId && productId == other.productId
				&& quantity == other.quantity
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice)
				&& Double.doubleToLongBits(unitPrice) == Double.doubleToLongBits(other.unitPrice);
	}
	public OrderItemsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderItemsModel(int itemId, int orderId, int productId, int quantity, double unitPrice, double totalPrice) {
		super();
		this.itemId = itemId;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "OrderItems [itemId=" + itemId + ", orderId=" + orderId + ", productId=" + productId + ", quantity="
				+ quantity + ", unitPrice=" + unitPrice + ", totalPrice=" + totalPrice + "]";
	}
	
}
