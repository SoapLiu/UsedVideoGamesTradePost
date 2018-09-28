package com.tradepost.service;

import java.sql.Timestamp;
import java.util.List;

import com.tradepost.entity.Article;
import com.tradepost.entity.User;

public interface ArticleService {
	
	public List<Article> getArticleList();

	public Article getArticleByID(Integer aid);

	public void addArticle(String title, String content, String label, Timestamp timestamp, User user, String username);

	public List<Article> getArticleByUID(Integer uid);

	public void deleteArticleByID(Integer aid);
	
	public List<Article> searchArticleByKey(String key);

	public List<Article> searchArticleByTag(String tagname);

	public void setArticleImg(Integer aid, String img);

	public void addArticle(String title, String content, String label, String articleimg, Timestamp timestamp, User user, String username);
	
}
