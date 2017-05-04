package com.mystore.model;

public class Order {
	private String orderId;
	private String customerId;
	private String orderDate;
	private String requiredDate;
	private String dispatchDate;
	private String status;
	
	
	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}


	public String getRequiredDate() {
		return requiredDate;
	}


	public void setRequiredDate(String requiredDate) {
		this.requiredDate = requiredDate;
	}


	public String getDispatchDate() {
		return dispatchDate;
	}


	public void setDispatchDate(String dispatchDate) {
		this.dispatchDate = dispatchDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", orderDate=" + orderDate + ", requiredDate="
				+ requiredDate + ", dispatchDate=" + dispatchDate + ", status=" + status + "]";
	}
}
