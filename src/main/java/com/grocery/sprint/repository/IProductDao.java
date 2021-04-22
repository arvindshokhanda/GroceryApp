package com.grocery.sprint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grocery.sprint.beans.Product;
@Repository
public interface IProductDao extends JpaRepository<Product, Long> {

	Product findByName(String name);
	
	@Modifying(clearAutomatically = true)
	  
	@Query( value = "SELECT p FROM Product p WHERE p.category =:givenCategory")
	List<Product> findByCategory(@Param("givenCategory")String Category);
}
