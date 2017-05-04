package com.mystore.model;

public class OrderDetail {

	private String orderDetailId;
	private String orderId;
	private String productId;
	private double unitPrice;
	private int orderLineNumber;
	private int quantity;
	private double discount;
	
	
	
	public String getOrderDetailId() {
		return orderDetailId;
	}



	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}



	public String getOrderId() {
		return orderId;
	}



	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}



	public String getProductId() {
		return productId;
	}



	public void setProductId(String productId) {
		this.productId = productId;
	}



	public double getUnitPrice() {
		return unitPrice;
	}



	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}



	public int getOrderLineNumber() {
		return orderLineNumber;
	}



	public void setOrderLineNumber(int orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public double getDiscount() {
		return discount;
	}



	public void setDiscount(double discount) {
		this.discount = discount;
	}



	@Override
	public String toString() {
		return "OrderDetail [orderDetailId=" + orderDetailId + ", orderId=" + orderId + ", productId=" + productId + ", unitPrice="
				+ unitPrice + ", orderLineNumber=" + orderLineNumber + ", quantity=" + quantity + ", discount=" + discount + "]";
	}
	
}
