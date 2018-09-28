package com.tradepost.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tradepost.entity.Article;
import com.tradepost.entity.Comment;
import com.tradepost.entity.User;

@Repository
public class CommentDaoImpl implements CommentDao {

	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	private Comment comment;

	@Override
	public void addComment(String content, Article article, String author, User user, Timestamp timestamp) {
		comment = new Comment();
		Session session = this.sessionFactory.getCurrentSession();
		comment.setContent(content);
		comment.setArticle(article);
		comment.setAuthor(author);
		comment.setUser(user);
		comment.setDate(timestamp);
		session.save(comment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getComment(Integer aid, Integer uid) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "select * from comment c where c.aid=" + aid + " and c.uid=" + uid;
		Query query = session.createSQLQuery(sql).addEntity(Comment.class);
		return (List<Comment>) query.list();
	}

	@Override
	public int getCommentCount(Integer aid) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "select count(*) from comment c where c.aid=" + aid;
		Query query = session.createSQLQuery(sql);
		return Integer.valueOf(query.uniqueResult().toString());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getCommentByAid(Integer aid) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "select * from comment c where c.aid=" + aid;
		Query query = session.createSQLQuery(sql).addEntity(Comment.class);
		return (List<Comment>) query.list();
	}

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public void deleteCommentByAid(Integer aid) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Comment> list = (List<Comment>) session.get(Comment.class, aid);
		session.delete(list);
//		String sql = "delete from comment c where c.aid=" + aid;
//		session.createSQLQuery(sql).executeUpdate();
	}
	
	@Override
	public void deleteCommentByCid(Integer cid) {
		Session session = this.sessionFactory.getCurrentSession();
		Comment comment = (Comment) session.get(Comment.class, cid);
		session.delete(comment);
	}
	
}

