package com.tradepost.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tradepost.dao.UserDao;
import com.tradepost.entity.User;

@Service
public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional
	public void addUser(String username, String password, String headimg, String role) {
		userDao.addUser(username, password, headimg, role);
	}

	@Override
	@Transactional
	public User getUser(String username, String password) {
		return userDao.getUser(username, password);
	}

	@Override
	@Transactional
	public User getUserByID(Integer uid) {
		return userDao.getUserByID(uid);
	}
	
	@Override
	@Transactional
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}
	
	@Override
	@Transactional
	public void changePassword(String username, String password) {
		userDao.changePassword(username, password);
	}
	
	@Override
	@Transactional
	public void changeHeadimg(String username, String headimg) {
		userDao.changeHeadimg(username, headimg);
	}

}
