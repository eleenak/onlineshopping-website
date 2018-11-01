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

	/*
	 * @Test public void testAddCategory() { category = new Category();
	 * 
	 * category.setName("Television");
	 * category.setDescription("this is a description");
	 * category.setImageUrl("CAT_1.png");
	 * 
	 * assertEquals("successfully added a category inside the table !"
	 * ,true,categoryDAO.add(category)); }
	 */

	/*
	 * @Test public void testGetCategory() { category = categoryDAO.get(1);
	 * assertEquals("successfully fetched a category inside the table !",
	 * "Television", category.getName()); }
	 */
	/*
	 * @Test public void testUpdateCategory() { category = categoryDAO.get(1);
	 * category.setName("TV");
	 * assertEquals("successfully updated a category inside the table !", true,
	 * categoryDAO.update(category)); }
	 */

	/*
	 * @Test public void testDeleteCategory() { category = categoryDAO.get(1);
	 * 
	 * assertEquals("successfully deleted a category inside the table !", true,
	 * categoryDAO.delete(category)); }
	 */

	/*
	 * @Test public void testListCategory() { category = categoryDAO.get(1);
	 * 
	 * assertEquals("successfully fetched  list of category from the table !",0,
	 * categoryDAO.list().size()); }
	 */

	@Test
	public void testCRUDCategory() {

		// adding a category
		category = new Category();

		category.setName("Laptop");
		category.setDescription("this is a description");
		category.setImageUrl("CAT_2.png");

		assertEquals("successfully added a category inside the table !", true, categoryDAO.add(category));

		category = new Category();

		category.setName("Television");
		category.setDescription("this is a description");
		category.setImageUrl("CAT_3.png");

		assertEquals("successfully added a category inside the table !", true, categoryDAO.add(category));

//		fetching and renaming the category
		category = categoryDAO.get(2);
		category.setName("TV");
		assertEquals("successfully updated a category inside the table !", true, categoryDAO.update(category));

		// delete the category

		assertEquals("successfully deleted a category inside the table !", true, categoryDAO.delete(category));

		// fetching the list
		assertEquals("successfully fetched  list of category from the table !", 1, categoryDAO.list().size());
	}

}
