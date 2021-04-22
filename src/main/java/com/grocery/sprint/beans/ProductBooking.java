package com.grocery.sprint.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_Booking")
public class ProductBooking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long bookingId;
	private long  productId;
	private String productName;
	private int quantity;
	private double amount;
	private String loginId;
	private String email;
	private String mobileNo;
	private String country;
	private String state;
	private String district;
	private String address;
	private int pincode;
	
	public ProductBooking() {}
	
	public ProductBooking(long productId, int quantity, String loginId, String email, String mobileNo, String country,
			String state, String district, String address, int pincode) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.loginId = loginId;
		this.email = email;
		this.mobileNo = mobileNo;
		this.country = country;
		this.state = state;
		this.district = district;
		this.address = address;
		this.pincode = pincode;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getloginId() {
		return loginId;
	}
	public void setloginId(String loginId) {
		this.loginId = loginId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "ProductBooking [productId=" + productId + ", productName=" + productName + ", quantity=" + quantity
				+ ", amount=" + amount + ", loginId=" + loginId + ", email=" + email + ", mobileNo=" + mobileNo
				+ ", country=" + country + ", state=" + state + ", district=" + district + ", address=" + address
				+ ", pincode=" + pincode + "]";
	}
	
}
