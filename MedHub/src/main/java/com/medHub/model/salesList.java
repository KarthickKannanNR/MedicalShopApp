package com.medHub.model;

import java.util.Date;
import java.util.Objects;

public class salesList {

	private int salesId;
	private int adminId;
	private int purchasId; 
	private int userId;
	private int productId;
	private int qty;
	private Date saleDate;
	private long totalAmt;
	
	public salesList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public salesList(int salesId, int adminId, int purchasId, int userId, int productId, int qty, Date saleDate,
			long totalAmt) {
		super();
		this.salesId = salesId;
		this.adminId = adminId;
		this.purchasId = purchasId;
		this.userId = userId;
		this.productId = productId;
		this.qty = qty;
		this.saleDate = saleDate;
		this.totalAmt = totalAmt;
	}
	@Override
	public String toString() {
		return "salesList [salesId=" + salesId + ", adminId=" + adminId + ", purchasId=" + purchasId + ", userId="
				+ userId + ", productId=" + productId + ", qty=" + qty + ", saleDate=" + saleDate + ", totalAmt="
				+ totalAmt + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(adminId, productId, purchasId, qty, saleDate, salesId, totalAmt, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		salesList other = (salesList) obj;
		return adminId == other.adminId && productId == other.productId && purchasId == other.purchasId
				&& qty == other.qty && Objects.equals(saleDate, other.saleDate) && salesId == other.salesId
				&& totalAmt == other.totalAmt && userId == other.userId;
	}
	public int getSalesId() {
		return salesId;
	}
	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public int getPurchasId() {
		return purchasId;
	}
	public void setPurchasId(int purchasId) {
		this.purchasId = purchasId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	public long getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(long totalAmt) {
		this.totalAmt = totalAmt;
	}
}
