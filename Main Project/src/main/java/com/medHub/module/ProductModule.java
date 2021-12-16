package com.medHub.module;

import java.util.Objects;

public class ProductModule {
	
	
	private int productInt;
	private String productCategory;
	private String productName;
	private String description;
	private int unitPrice;
	private int quantity;
	private String productImg;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	public int getProductInt() {
		return productInt;
	}
	public void setProductInt(int productInt) {
		this.productInt = productInt;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public ProductModule() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProductModule(int productInt, String productCategory, String productName,String description, int unitPrice, int quantity,
			String productImg) {
		super();
		this.productInt = productInt;
		this.productCategory = productCategory;
		this.productName = productName;
		this.description=description;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.productImg = productImg;
	}
	@Override
	public String toString() {
		return "ProductModule [productImg=" + productImg + ", productInt=" + productInt + ", productCategory="
				+ productCategory + ", productName=" + productName + ", unitPrice=" + unitPrice + ", quantity="
				+ quantity + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(productCategory, productImg, productInt, productName, quantity, unitPrice);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductModule other = (ProductModule) obj;
		return Objects.equals(productCategory, other.productCategory) && Objects.equals(productImg, other.productImg)
				&& productInt == other.productInt && Objects.equals(productName, other.productName)
				&& quantity == other.quantity && unitPrice == other.unitPrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}