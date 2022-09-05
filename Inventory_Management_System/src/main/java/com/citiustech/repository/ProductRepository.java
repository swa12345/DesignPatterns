package com.citiustech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.citiustech.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	@Query("from Product order by DATEADD(month, useBeforeDate, manufacturingDate) desc")
	List<Product> getSortedProducts();
}
