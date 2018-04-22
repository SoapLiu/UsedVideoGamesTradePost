package com.tradepost.service;

import java.sql.Timestamp;
import java.util.List;

import com.tradepost.entity.Article;
import com.tradepost.entity.Page;
import com.tradepost.entity.User;

public interface ArticleService {
	
	public List<Article> getArticleList();

	public Article getArticleByID(Integer aid);

	public void addArticle(String title, String content, Timestamp timestamp, User user);

	public List<Article> getArticleByUID(Integer uid);

	public void deleteArticleByID(Integer aid);
	
	public List<Article> getArticlePageList(int currentPage, int pageSize);

	public List<Article> searchArticleByKey(String key);

	List<Article> searchArticleByTag(String tagname);
}
