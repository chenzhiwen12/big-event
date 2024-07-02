package com.alvin.controller;

import com.alvin.pojo.Category;
import com.alvin.pojo.Result;
import com.alvin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * packageName com.alvin.controller
 *
 * @author 你的名字
 * @version JDK 8
 * @className CategoryController (此处以class为例)
 * @date 2024/6/29 星期六
 * @description TODO
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@PostMapping
	public Result add(@RequestBody @Validated(Category.Addvin.class) Category category) {
		categoryService.add(category);
		return Result.success();
	}

	@GetMapping
	public Result<List<Category>> list() {
		List<Category> cs = categoryService.list();
		return Result.success(cs);
	}

	@GetMapping("/detail")
	public Result<Category> detail(Integer id) {
		Category category=categoryService.findById(id);
		return Result.success(category);
	}

	@PutMapping
	public Result update(@RequestBody @Validated(Category.Updatevin.class) Category category){
		categoryService.update(category);
		return Result.success();
	}
	@DeleteMapping
	public Result delete(@RequestParam Integer id){
		Category category=categoryService.findById(id);
		if(category==null){
			return Result.error("输入id不正确");
		}
		categoryService.delete(id);
		return Result.success(category);
	}
}
