package com.medHub.module;

import java.util.Objects;

public class Cart {
	private int items;
	private int productId;
	private int userId;
	private int unitPrice;
	private int qty;
	public int getItems() {
		return items;
	}
	public void setItems(int items) {
		this.items = items;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUnitPrice() {
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
	@Override
	public int hashCode() {
		return Objects.hash(items, productId, qty, unitPrice, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		return items == other.items && productId == other.productId && qty == other.qty && unitPrice == other.unitPrice
				&& userId == other.userId;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int items, int productId, int userId, int unitPrice, int qty) {
		super();
		this.items = items;
		this.productId = productId;
		this.userId = userId;
		this.unitPrice = unitPrice;
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "Cart [items=" + items + ", productId=" + productId + ", userId=" + userId + ", unitPrice=" + unitPrice
				+ ", qty=" + qty + "]";
	}
	

}
