package com.tradepost.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tradepost.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	private User user;
	
	@Override
	public void addUser(String username, String password, String headimg, String role) {
		user = new User();
		Session session = this.sessionFactory.getCurrentSession();
		user.setUsername(username);
		user.setPassword(password);
		user.setHeadimg(headimg);
		user.setRole(role);
		session.save(user);
	}

	@Override
	public User getUser(String username, String password) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User u where u.username=? and u.password=?").setParameter(0, username).setParameter(1, password);
		return (User) query.uniqueResult();
	}

	@Override
	public User getUserByID(Integer uid) {
		Session session = this.sessionFactory.getCurrentSession();
		return (User) session.get(User.class, uid);
	}

	@Override
	public User getUserByUsername(String username) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User u where u.username=?").setParameter(0, username);
		return (User) query.uniqueResult();
	}

	@Override
	public void changePassword(String username, String password) {
		Session session = this.sessionFactory.getCurrentSession();
		user = (User) session.createQuery("from User u where u.username=?").setParameter(0, username).uniqueResult();
		user.setPassword(password);
		session.save(user);
	}

	@Override
	public void changeHeadimg(String username, String headimg) {
		Session session = this.sessionFactory.getCurrentSession();
		user = (User) session.createQuery("from User u where u.username=?").setParameter(0, username).uniqueResult();
		user.setHeadimg(headimg);
		session.save(user);
	}
	
}
