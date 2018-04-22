package com.tradepost.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tradepost.entity.Article;
import com.tradepost.entity.Page;
import com.tradepost.entity.User;

@Repository
public class ArticleDaoImpl implements ArticleDao {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	private Article article;
	private Page page;

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getArticleList() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Article order by aid desc");
		return (List<Article>) query.list();
	}

	@Override
	public Article getArticleByID(Integer aid) {
		Session session = this.sessionFactory.getCurrentSession();
		return (Article) session.get(Article.class, aid);
	}

	@Override
	public void addArticle(String title, String content, Timestamp timestamp, User user) {
		article = new Article();
		Session session = this.sessionFactory.getCurrentSession();
		article.setTitle(title);
		article.setContent(content);
		article.setDate(timestamp);
		article.setUser(user);
		session.save(article);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getArticleByUID(Integer uid) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Article where uid=? order by aid desc").setParameter(0, uid);
		return (List<Article>) query.list();
	}

	@Override
	public void deleteArticleByID(Integer aid) {
		Session session = this.sessionFactory.getCurrentSession();
		Article article = (Article) session.get(Article.class, aid);
		session.delete(article);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getArticlePageList(int currentPage, int pageSize) {
		page = new Page();
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User u inner join u.articleSet order by aid desc").setFirstResult(currentPage).setMaxResults(pageSize);
		page.setList((List<Article>) query.list());
		page.setCurrentPage(currentPage);
		page.setPageSize(pageSize);
		return (List<Article>) query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> searchArticleByKey(String key) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Article a where a.title like ? order by aid desc").setParameter(0, "%"+key+"%");
		return (List<Article>) query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> searchArticleByTag(String tagname) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Article a where a.label like ? order by aid desc").setParameter(0, "%"+tagname+"%");
		return (List<Article>) query.list();
	}

}
