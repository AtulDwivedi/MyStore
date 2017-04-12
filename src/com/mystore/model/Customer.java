package com.mystore.model;

public class Customer {

	private String cutomerId;
	private String customerName;
	private String gender;
	private int age;
	private long mobileNumber;
	private String email;
	private String address;
	
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCutomerId() {
		return cutomerId;
	}
	public void setCutomerId(String cutomerId) {
		this.cutomerId = cutomerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Customer [cutomerId=" + cutomerId + ", customerName=" + customerName + ", gender=" + gender + ", age="
				+ age + ", mobileNumber=" + mobileNumber + ", email=" + email + ", address=" + address + "]";
	}
}
