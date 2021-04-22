package com.grocery.sprint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.sprint.beans.Product;
import com.grocery.sprint.beans.ProductBooking;
import com.grocery.sprint.beans.User;
import com.grocery.sprint.service.BookingProductServiceImpl;
import com.grocery.sprint.service.ProductServiceImpl;
import com.grocery.sprint.service.UserServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private BookingProductServiceImpl bookingProductService;
	
	@Autowired
	private ProductServiceImpl productService;
	
	@PutMapping(path="/user/update", consumes="application/json", produces="application/json")
	public ResponseEntity<User> updateUser(@RequestBody User u)
	{
		User user=userService.updateUser(u);
		
		if(user!=null)
			return new ResponseEntity<User>(user, HttpStatus.OK);
		else
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(path="/user/delete/{id}", consumes="application/json", produces="application/json")
	public ResponseEntity<String> deleteUser(@PathVariable String id)
	{
		boolean status=userService.deleteUser(id);
		
		if(status)
			return new ResponseEntity<String>("User is deleted", HttpStatus.OK);
		else
			return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(path="/users-id/{userId}", consumes="application/json", produces="application/json")	
	public ResponseEntity<User> getUserById(@PathVariable long userId)
	{
		User user=userService.findById(userId);
		
		if(user!=null)
			return new ResponseEntity<User>(user, HttpStatus.OK);
		else
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
	}
		
	@GetMapping(path="/users/{loginId}", consumes="application/json", produces="application/json")	
	public ResponseEntity<User> getUserByLoginId(@PathVariable String loginId)
	{
		User user=userService.findByLoginId(loginId);
		
		if(user!=null)
			return new ResponseEntity<User>(user, HttpStatus.OK);
		else
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(path="/view-id/{productId}", consumes="application/json", produces="application/json")
	public ResponseEntity<Product> getProductById(@PathVariable long productId)
	{
		Product product=productService.viewProductById(productId);
		
		if(product!=null)
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		else
			return new ResponseEntity<Product>(product, HttpStatus.NOT_FOUND); 
	}
	
	@GetMapping(path="/view-name/{name}", consumes="application/json", produces="application/json")
	public ResponseEntity<Product> getProductByName(@PathVariable String name)
	{
		Product product=productService.viewProductByName(name);
		
		if(product!=null)
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		else
			return new ResponseEntity<Product>(product, HttpStatus.NOT_FOUND); 
	}
	
	@GetMapping(path="/view-category/{category}", consumes="application/json", produces="application/json")
	public ResponseEntity<List<Product>> getProductByCategory(@PathVariable String category)
	{
		List<Product> productList=productService.viewProductsByCategory(category);
		
		if(productList!=null)
			return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
		else
			return new ResponseEntity<List<Product>>(productList, HttpStatus.NOT_FOUND); 
	}
	
	@GetMapping(path="/view-all", consumes="application/json", produces="application/json")
	public ResponseEntity<List<Product>> getAllProduct()
	{
		List<Product> productList=productService.viewAllProducts();
		
		if(productList!=null)
			return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
		else
			return new ResponseEntity<List<Product>>(productList, HttpStatus.NOT_FOUND); 
	}
	
	@GetMapping(path="/booking-history/{loginId}", consumes="application/json", produces="application/json") 
	  public ResponseEntity<List<ProductBooking>> viewBookingHistory(@PathVariable String loginId) 
	  { 
		  List<ProductBooking> bookingHistory=bookingProductService.viewBookingHistory(loginId);
	  
		  if(bookingHistory!=null) 
			  return new ResponseEntity<List<ProductBooking>>(bookingHistory, HttpStatus.OK); 
		  else
			  return new ResponseEntity<List<ProductBooking>>(bookingHistory, HttpStatus.NOT_FOUND); 
	  }
	  
	  @PostMapping(path="/book-product", consumes="application/json", produces="application/json")
	  public ResponseEntity<ProductBooking> bookProduct(@RequestBody ProductBooking productBooking)
	  {
		  ProductBooking bookedProduct=bookingProductService.bookingProduct(productBooking);
		  
		  return new ResponseEntity<ProductBooking>(bookedProduct, HttpStatus.OK);
	  }
	 
}