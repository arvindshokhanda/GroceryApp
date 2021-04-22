package com.grocery.sprint.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grocery.sprint.beans.Product;
import com.grocery.sprint.repository.IProductDao;
@Service
@Transactional
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	IProductDao productDao;

	public Product addProduct(Product product) {
		
		return productDao.save(product);
	}

	@Override
	public Product viewProductById(long id) {
		
		return (Product) productDao.findById(id).get();
	}

	@Override public Product viewProductByName(String name) 
	{ 
		return productDao.findByName(name); 
	}
	 
	@Override
	public List<Product> viewAllProducts() {
		return (List<Product>) productDao.findAll();
	}

	@Override public List<Product> viewProductsByCategory(String category) 
	{
		return productDao.findByCategory(category); 
	}
	
	@Override 
	public Product updateProduct(Product product) 
	{ 
		if(productDao.findById(product.getProductId())!=null)
		{
			Product prod=productDao.findById(product.getProductId()).get();
			prod.setName(product.getName());
			prod.setPrice(product.getPrice());
			prod.setQuantity(product.getQuantity());
			prod.setCategory(product.getCategory());
			prod.setDescription(product.getDescription());
			
			return prod;
		}
		
		return null;
	}
	 
	@Override
	public boolean deleteProduct(long id) {
		if (productDao.findById(id) != null) {
			Product product1 = (Product) productDao.findById(id).get();
			productDao.delete(product1);
			return true;
		}
		else
			return false;
	}
	
}
