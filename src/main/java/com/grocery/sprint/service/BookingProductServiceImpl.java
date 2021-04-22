package com.grocery.sprint.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.sprint.beans.Product;
import com.grocery.sprint.beans.ProductBooking;
import com.grocery.sprint.repository.IProductBooking;
import com.grocery.sprint.repository.IProductDao;

@Service
@Transactional
public class BookingProductServiceImpl implements IProductBookingService{

	@Autowired
	private IProductDao productDao;
	
	@Autowired
	private IProductBooking productBookingDao;

	@Override
	public ProductBooking bookingProduct(ProductBooking productBooking) {

		productBookingDao.save(productBooking);
		
		ProductBooking productBook=productBookingDao.findById(productBooking.getBookingId()).get();
		Product product=productDao.findById(productBook.getProductId()).get();
		productBook.setProductName(product.getName());
		productBook.setAmount(product.getPrice() * productBooking.getQuantity());
		product.setQuantity(product.getQuantity() - productBooking.getQuantity());
		
		return productBook;
	}

	@Override
	public List<ProductBooking> viewBookingHistory(String loginId) {
		
		return productBookingDao.findByLoginId(loginId);
	}

	@Override
	public List<ProductBooking> viewAllBookingHistory() {
		return productBookingDao.findAll();
	}
	
	
}
