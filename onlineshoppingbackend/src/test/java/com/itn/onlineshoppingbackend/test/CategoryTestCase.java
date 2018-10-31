package com.itn.onlineshoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.itn.onlineshoppingbackend.dao.CategoryDAO;
import com.itn.onlineshoppingbackend.dto.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.itn.onlineshoppingbackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	@Test
	public void testAddCategory() {
		category = new Category();

		category.setName("Television");
		category.setDescription("this is a description");
		category.setImageUrl("CAT_1.png");
		
		assertEquals("successfully added a category inside the table !" ,true,categoryDAO.add(category));
	}

}
