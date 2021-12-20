package com.medHub.module;

import java.util.Objects;

public class ProductModule {
	
	
	private int productId;
	public ProductModule(int productId, String productCategory, String productName, String description, int unitPrice,
			int quantity, String productImg) {
		super();
		this.productId = productId;
		this.productCategory = productCategory;
		this.productName = productName;
		this.description = description;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.productImg = productImg;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
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
	
	public ProductModule(String productCategory, String productName,String description, int unitPrice, int quantity,
			String productImg) {
		super();
		
		this.productCategory = productCategory;
		this.productName = productName;
		this.description=description;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.productImg = productImg;
	}
	public ProductModule(String productname, String productcategory, String description, int unitPrice,
			int quantity,int productId) {
		// TODO Auto-generated constructor stub
		this.productName = productname;
		this.description=description;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.productCategory=productcategory;
		this.productId=productId;
		
	}
	@Override
	public String toString() {
		return  productId+"\nproductCategory="
				+ productCategory + "\nproductName=" + productName + "\nunitPrice=" + unitPrice + "\nquantity="
				+ quantity +"\n";
	}
	@Override
	public int hashCode() {
		return Objects.hash(productCategory, productImg, productName, quantity, unitPrice);
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
				 && Objects.equals(productName, other.productName)
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