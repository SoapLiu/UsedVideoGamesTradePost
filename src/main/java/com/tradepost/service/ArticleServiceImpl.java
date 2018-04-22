package com.tradepost.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tradepost.dao.ArticleDao;
import com.tradepost.entity.Article;
import com.tradepost.entity.Page;
import com.tradepost.entity.User;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	private ArticleDao articleDao;
	
	@Autowired
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	@Transactional
	public List<Article> getArticleList() {
		return articleDao.getArticleList();
	}

	@Override
	@Transactional
	public Article getArticleByID(Integer aid) {
		return articleDao.getArticleByID(aid);
	}

	@Override
	@Transactional
	public void addArticle(String title, String content, Timestamp timestamp, User user) {
		articleDao.addArticle(title, content, timestamp, user);
	}

	@Override
	@Transactional
	public List<Article> getArticleByUID(Integer uid) {
		return articleDao.getArticleByUID(uid);
	}

	@Override
	@Transactional
	public void deleteArticleByID(Integer aid) {
		articleDao.deleteArticleByID(aid);
	}

	@Override
	@Transactional
	public List<Article> getArticlePageList(int currentPage, int pageSize) {
		return articleDao.getArticlePageList(currentPage, pageSize);
	}

	@Override
	@Transactional
	public List<Article> searchArticleByKey(String key) {
		return articleDao.searchArticleByKey(key);
	}

	@Override
	@Transactional
	public List<Article> searchArticleByTag(String tagname) {
		return articleDao.searchArticleByTag(tagname);
	}

}
