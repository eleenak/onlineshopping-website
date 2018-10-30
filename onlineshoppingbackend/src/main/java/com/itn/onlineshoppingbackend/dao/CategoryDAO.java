package com.itn.onlineshoppingbackend.dao;

import java.util.List;

import com.itn.onlineshoppingbackend.dto.Category;

public interface CategoryDAO {
	List<Category> list();
	Category get(int id);
}
