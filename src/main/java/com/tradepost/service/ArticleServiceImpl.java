package com.tradepost.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tradepost.dao.ArticleDao;
import com.tradepost.entity.Article;
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
	public void addArticle(String title, String content, String label, Timestamp timestamp, User user, String username) {
		articleDao.addArticle(title, content, label, timestamp, user, username);
	}
	
	@Override
	@Transactional
	public void addArticle(String title, String content, String label, String articleimg, Timestamp timestamp, User user, String username) {
		articleDao.addArticle(title, content, label, articleimg, timestamp, user, username);
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
	public List<Article> searchArticleByKey(String key) {
		return articleDao.searchArticleByKey(key);
	}

	@Override
	@Transactional
	public List<Article> searchArticleByTag(String tagname) {
		return articleDao.searchArticleByTag(tagname);
	}
	
	@Override
	@Transactional
	public void setArticleImg(Integer aid, String img) {
		articleDao.setArticleImg(aid, img);
	}

}
