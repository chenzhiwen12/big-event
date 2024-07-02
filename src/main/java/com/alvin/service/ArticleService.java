package com.alvin.service;

import com.alvin.pojo.Article;
import com.alvin.pojo.PageBean;

public interface ArticleService {
	void add(Article article);

	PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);
}
