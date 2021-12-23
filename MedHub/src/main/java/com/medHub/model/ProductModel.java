package com.medHub.model;

import java.util.Objects;

public class ProductModel
{
	
	private OrderModel order;
	private UserModel user;
	private int productId;
	private String productCategory;
	private String productName;
	private String description;
	private double unitPrice;
	private int quantity;
	private String productImg;
	public ProductModel(int productId, String productCategory, String productName, String description, double unitPrice,
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
	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProductModel(String productCategory, String productName,String description, double unitPrice, int quantity,
			String productImg) {
		super();
		
		this.productCategory = productCategory;
		this.productName = productName;
		this.description=description;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.productImg = productImg;
	}
	public ProductModel(String productname, String productcategory, String description, double unitPrice,
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
		return "Product id="+ productId+"\nproductCategory="
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
		ProductModel other = (ProductModel) obj;
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
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}