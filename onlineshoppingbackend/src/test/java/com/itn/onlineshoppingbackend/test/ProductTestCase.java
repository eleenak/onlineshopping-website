package com.itn.onlineshoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.itn.onlineshoppingbackend.dao.ProductDAO;
import com.itn.onlineshoppingbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;

	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.itn.onlineshoppingbackend");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	/*@Test
	public void testCRUDProduct() {
		// create operation
		product = new Product();

		product.setName("Google Pixel 3");
		product.setBrand("Google");
		product.setDescription("Google pixel 3 description");
		product.setUnitPrice(120000);
		product.setCategoryId(3);
		product.setSupplierId(3);

		assertEquals("Something went wrong while inserting a new product!", true, productDAO.add(product));

		// reading and updating the category
		product=productDAO.get(2);
		

		product.setName("Samsung Galaxy S9");
		assertEquals("Something went wrong while updating the existing record!", true, productDAO.update(product));
		assertEquals("Something went wrong while deleting the existing record!", true, productDAO.delete(product));

		//list
		assertEquals("Something went wrong while fetching the list of products",5,productDAO.list().size());
	}*/
	
	@Test
	public void testListActiveProducts() {
		assertEquals("Something went wrong while fetching the list of products",2,productDAO.listActiveProducts().size());
		
	}
	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Something went wrong while fetching the list of products",1,productDAO.listActiveProductsByCategory(3).size());
		assertEquals("Something went wrong while fetching the list of products",1,productDAO.listActiveProductsByCategory(1).size());
		
	}
	@Test
	public void getLatestActiveProducts() {
		assertEquals("Something went wrong while fetching the list of products",1,productDAO.getLatestActiveProducts(1).size());
		
	}
}
