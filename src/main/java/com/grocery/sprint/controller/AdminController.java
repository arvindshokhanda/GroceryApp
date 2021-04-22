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
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private ProductServiceImpl productService;
	
	@Autowired
	private BookingProductServiceImpl bookingProductService;
	
	@PostMapping(path="/product", consumes="application/json", produces="application/json")
	public ResponseEntity<Product> addProduct(@RequestBody Product pro)
	{
		Product product=productService.addProduct(pro);
		
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@PutMapping(path="/user", consumes="application/json", produces="application/json")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product)
	{
		Product prod=productService.updateProduct(product);
		
		if(prod!=null)
			return new ResponseEntity<Product>(prod, HttpStatus.OK);
		else
			return new ResponseEntity<Product>(prod, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(path="/user/{productId}", consumes="application/json", produces="application/json")
	public ResponseEntity<String> deleteProduct(@PathVariable long productId)
	{
		boolean status=productService.deleteProduct(productId);
		
		if(status)
			return new ResponseEntity<String>("Product is deleted", HttpStatus.OK);
		else
			return new ResponseEntity<String>("Product not found", HttpStatus.OK);
	}
	
	@PutMapping(path="/users", consumes="application/json", produces="application/json")
	public ResponseEntity<User> updateUser(@RequestBody User u)
	{
		User user=userService.updateUser(u);
		
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
	
	@GetMapping(path="/view-cid/{customerId}", consumes="application/json", produces="application/json")	
	public ResponseEntity<User> getUserById(@PathVariable long customerId)
	{
		User user=userService.findById(customerId);
		
		if(user!=null)
			return new ResponseEntity<User>(user, HttpStatus.OK);
		else
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(path="/view-login/{loginId}", consumes="application/json", produces="application/json")	
	public ResponseEntity<User> getUserByLoginId(@PathVariable String loginId)
	{
		User user=userService.findByLoginId(loginId);
		
		if(user!=null)
			return new ResponseEntity<User>(user, HttpStatus.OK);
		else
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
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
	
	@GetMapping(path="/all-booking-history", consumes="application/json", produces="application/json")
	public ResponseEntity<List<ProductBooking>> viewAllBookingHistory()
	{
		List<ProductBooking> bookingHistory=bookingProductService.viewAllBookingHistory();
		  
		if(bookingHistory!=null) 
			return new ResponseEntity<List<ProductBooking>>(bookingHistory, HttpStatus.OK); 
		else
			return new ResponseEntity<List<ProductBooking>>(bookingHistory, HttpStatus.NOT_FOUND); 
	}
}
