package com.alvin.service.impl;

import com.alvin.mapper.ArticleMapper;
import com.alvin.pojo.Article;
import com.alvin.pojo.PageBean;
import com.alvin.service.ArticleService;
import com.alvin.utils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
 * @className ArticleServceImpl (此处以class为例)
 * @date 2024/7/2 星期二
 * @description TODO
 */
@Service
public class ArticleServceImpl implements ArticleService {
	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public void add(Article article) {
		article.setCreateTime(LocalDateTime.now());
		article.setUpdateTime(LocalDateTime.now());
		Map<String, Object> map = ThreadLocalUtil.get();
		Integer userId = (Integer) map.get("id");
		article.setCreateUser(userId);
		articleMapper.add(article);
	}

	@Override
	public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
		//1创建pageBean对象
		PageBean<Article> pb = new PageBean<>();
		//2开启分页查询
		PageHelper.startPage(pageNum, pageSize);
		//调用Mapper
		Map<String, Object> map = ThreadLocalUtil.get();
		Integer userId = (Integer) map.get("id");
		List<Article> as = articleMapper.list(userId, categoryId, state);
		Page<Article> p = (Page<Article>) as;
		pb.setTotal(p.getTotal());
		pb.setItems(p.getResult());
		return pb;
	}
}
