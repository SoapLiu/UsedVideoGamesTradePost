package com.tradepost.dao;

import com.tradepost.entity.User;

public interface UserDao {

	public void addUser(String username, String password);
	
	public User getUser(String username, String password);
	
	public User getUserByID(Integer uid);
}
