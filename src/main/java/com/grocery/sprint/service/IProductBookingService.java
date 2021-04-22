package com.grocery.sprint.service;

import java.util.List;

import com.grocery.sprint.beans.ProductBooking;

public interface IProductBookingService {

	public ProductBooking bookingProduct(ProductBooking productBooking);
	
	public List<ProductBooking> viewBookingHistory(String userId);
	
	public List<ProductBooking> viewAllBookingHistory();
}
