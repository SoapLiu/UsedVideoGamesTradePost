package com.tradepost.service;

import com.tradepost.entity.User;

public interface UserService {
	
	public void addUser(String username, String password, String headimg, String role);
	
	public User getUser(String username, String password);
	
	public User getUserByID(Integer uid);

	public User getUserByUsername(String username);

	public void changePassword(String username, String password);

	public void changeHeadimg(String username, String headimg);
	
}
