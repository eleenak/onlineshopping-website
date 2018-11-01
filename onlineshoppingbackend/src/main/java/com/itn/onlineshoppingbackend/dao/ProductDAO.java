package com.itn.onlineshoppingbackend.dao;

import java.util.List;

import com.itn.onlineshoppingbackend.dto.Product;

public interface ProductDAO {
	
	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	//business methods
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int category);
	List<Product> getLatestActiveProducts(int count);
	

}
