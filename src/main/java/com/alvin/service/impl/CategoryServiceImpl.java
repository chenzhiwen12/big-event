package com.alvin.service.impl;

import com.alvin.mapper.CategoryMapper;
import com.alvin.pojo.Category;
import com.alvin.service.CategoryService;
import com.alvin.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * packageName com.alvin.service.impl
 *
 * @author 你的名字
 * @version JDK 8
 * @className CategoryServiceImpl (此处以class为例)
 * @date 2024/6/29 星期六
 * @description TODO
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public void add(Category category) {
		category.setCreateTime(LocalDateTime.now());
		category.setUpdateTime(LocalDateTime.now());
		Map map = ThreadLocalUtil.get();
		Integer id = (Integer) map.get("id");
		category.setCreateUser(id);
		categoryMapper.add(category);
	}

	@Override
	public List<Category> list() {
		Map map = ThreadLocalUtil.get();
		Integer id = (Integer) map.get("id");
		return categoryMapper.list(id);

	}

	@Override
	public Category findById(Integer id) {
		return categoryMapper.findById(id);
	}

	@Override
	public void update(Category category) {
		category.setUpdateTime(LocalDateTime.now());
		categoryMapper.update(category);
	}


}
