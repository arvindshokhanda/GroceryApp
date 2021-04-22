package com.grocery.sprint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grocery.sprint.beans.ProductBooking;
@Repository
public interface IProductBooking extends JpaRepository<ProductBooking, Long>  {

	List<ProductBooking> findByLoginId(String loginId);
}
