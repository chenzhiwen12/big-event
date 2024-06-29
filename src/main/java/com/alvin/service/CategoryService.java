package com.alvin.service;

import com.alvin.pojo.Category;

import java.util.List;

public interface CategoryService {
	void add(Category category);

	List<Category> list();

	Category findById(Integer id);

	void update(Category category);
}
