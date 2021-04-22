package com.grocery.sprint.service;

import java.util.List;

import com.grocery.sprint.beans.Product;

public interface IProductService {
	Product addProduct(Product product);

	Product viewProductById(long id);
	
	Product viewProductByName(String name);
	
	List<Product> viewAllProducts();
	
	List<Product> viewProductsByCategory(String category);
	
	boolean deleteProduct(long id);

	Product updateProduct(Product product);
	
	
}