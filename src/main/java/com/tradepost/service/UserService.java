package com.tradepost.service;

import com.tradepost.entity.User;

public interface UserService {
	
	public void addUser(String username, String password);
	
	public User getUser(String username, String password);
	
	public User getUserByID(Integer uid);
}
