package com.itn.onlineshoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.itn.onlineshoppingbackend.dao.CategoryDAO;
import com.itn.onlineshoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories=new ArrayList<>();
	
	static {
		Category category=new Category();
		//adding first category inside the list
		
		category.setId(1);
		category.setName("Television");
		category.setDescription("this is a description");
		category.setImageUrl("CAT_1.png");
		
		categories.add(category);
		
		//second category
		category=new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("this is mobile description");
		category.setImageUrl("CAT_2.png");
		
		categories.add(category);
		
		//3rd category
		category=new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("this is a laptop description");
		category.setImageUrl("CAT_3.png");
		
		categories.add(category);
	}
	
	@Override
	public List<Category> list() {
		
		return categories;
	}

	@Override
	public Category get(int id) {
		
		//enhance for loop
		for(Category category:categories) {
			if(category.getId()==id)
				return category;
		}
		
		return null;
	}

}
